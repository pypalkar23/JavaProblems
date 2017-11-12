import java.io.IOException;


import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Job;


public class TotalSales {
    //mapper
    public static class TotalSalesMapper extends Mapper<LongWritable /*Input key format*/,
    Text/*Input value format*/,
    Text/*Output key format*/,
    FloatWritable/*Output value format*/> {
        public void map(LongWritable key/*key of input just a line no in this case*/,
         Text value/*value of input just a line no in this case*/, 
         Context context) throws IOException, InterruptedException {
                                    
            String line = value.toString();
            String[] data = line.split("\t");
            if (data.length == 6) {
                String storeName = data[2];
                float cost = Float.parseFloat(data[4]);
                context.write(new Text(storeName), new FloatWritable(cost));
            }
        }
    }

    public static class TotalSalesReducer extends Reducer<Text/*Input key format*/,
     FloatWritable /*Input value format*/,
     Text /*Output key format*/,
     FloatWritable/*Output value format*/> {
        public void reduce(Text key, Iterable<FloatWritable> values, Context context)
                throws IOException, InterruptedException {
            float sum = 0;
            for (FloatWritable val : values) {
                sum += val.get();
            }
            context.write(key, new FloatWritable(sum));
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Sales Count");
        job.setJarByClass(TotalSales.class);
        job.setMapperClass(TotalSalesMapper.class);
        job.setCombinerClass(TotalSalesReducer.class);
        job.setReducerClass(TotalSalesReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FloatWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true)?0:1);
    }

}