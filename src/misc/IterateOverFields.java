package misc;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class IterateOverFields {
    public static final String A="a";

    public static final String B="b";
    public static class sample{
        public static final String A="mandar";
        public static final String B="b";
    }
    public static void main(String[] args) throws IllegalAccessException,NoSuchFieldException {
        Map<String,Class<?>> classMap = new HashMap<>();
        classMap.put("whatsapp",IterateOverFields.sample.class);
        String val = classMap.get("whatsapp").getField("A").get(null).toString();
        System.out.println(val);

        Class[] classes=IterateOverFields.class.getClasses();
        for(Class c:classes){
            System.out.println(c.getName());
            if(c.getSimpleName().equals("sample")){
                String val1 = c.getField("A").get(null).toString();
                System.out.println(val1);
            }
        }
        
    }

}
