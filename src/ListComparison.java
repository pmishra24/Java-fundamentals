import java.util.ArrayList;
import java.util.LinkedList;

public class ListComparison
{
    public static void main(String[] args)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i<100000; i++)
        {
            arrayList.add(i);
            linkedList.add(i);
        }
        long start = System.nanoTime();
        arrayList.add(0,999);
        long end = System.nanoTime();
        System.out.println("ArrayList insert in start time " + (end - start));
        start = System.nanoTime();
        linkedList.add(0,999);
        end = System.nanoTime();
        System.out.println("LinkedList insert in start time " + (end - start));

        start = System.nanoTime();
        arrayList.get(50000);
        end = System.nanoTime();
        System.out.println("ArrayList get time" + (end - start));
        start = System.nanoTime();
        linkedList.get(50000);
        end = System.nanoTime();
        System.out.println("LinkedList get time" + (end - start));

    }
}
