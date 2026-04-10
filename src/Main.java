import java.util.*;
public class Main
{
    public static void main(String[] args)
{
    int[] numbers = {2,7,11,15};
    int target = 9;
    HashMap<Integer, Integer> h = new HashMap<>();
    for(int i = 0; i<numbers.length; i++)
    {
        int rem = target - numbers[i];
        if(h.get(rem) != null)
        {
            System.out.println(numbers[i]+" "+rem);
            break;
        }
        h.put(numbers[i], i+1);
    }
}
}