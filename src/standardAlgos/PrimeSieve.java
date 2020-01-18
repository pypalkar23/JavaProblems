import java.util.ArrayList;
import java.util.Iterator;

class PrimeSieve
{
    public static void main(String args[])
    {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        for(int i=2;i<=35;i++)
        {
            arrayList.add(i);
        }
        int temp=0;
     while(true)
     {
         if(arrayList.size()==0)
          break;
         Iterator<Integer>itr=arrayList.iterator();
         if(itr.hasNext())
          {
              temp=(itr.next()).intValue();
              System.out.println(temp);
              itr.remove();
            }
         while(itr.hasNext())
         {
             if((itr.next()).intValue()%temp==0)
             {
                 itr.remove();
             }
         }
     }

    }



}
