import java.util.Arrays;

public class Day4 {
    public static void main(String[] args){
        boolean pairFound = false;
        int[] numbers = {2,11,7,15};
        Arrays.sort(numbers);
        int target = 100;
        int sum = 0;
        for(int i = 0, j= numbers.length - 1; i<=j ;)
        {
            sum = numbers[i] + numbers[j];
            if(sum < target)
                i++;
            else if(sum > target)
                j--;
            else{
                System.out.println("Two numbers are " + numbers[i] + " and "+ numbers[j]);
                pairFound = true;
                break;
            }
            sum = 0;
        }
        if(!pairFound)
            System.out.println("No pair found");
    }
}
