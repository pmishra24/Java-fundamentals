import java.util.Arrays;

public class Day4 {
    public static int uniqueCount(int[] arr){
        int count = 1;
        for(int j= 0; j< arr.length-1;j++)
        {
            if(arr[j] != arr[j+1])
                count++;
        }
        return count;
    }

    public static void removeDuplicatesTwoPointer(int[] arr){
        int i=0;
        for(int j= 0; j< arr.length;j++)
        {
            if(arr[i] != arr[j])
            {
                arr[++i] = arr[j];
            }
        }
        System.out.print("Unique elements are: {");
        for(int a=0; a<=i; a++){
            if(a==i)
                System.out.print(arr[a] + "}");
            else
                System.out.print(arr[a] + ", ");
        }
        System.out.println();
    }

    public static void removeDuplicatesOnePointer(int[] arr){
        int i =0;
        System.out.print("Unique elements are: {");
        int j=0;
        while(j< arr.length-1)
        {
            if(arr[j] != arr[j+1])
                    System.out.print(arr[j] + ", ");
            j++;
        }
        System.out.print(arr[j] + "}");
        System.out.println();
    }

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

        // Remove duplicates
        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(arr));
        System.out.println("Unique element count "+ uniqueCount(arr));
        removeDuplicatesOnePointer(arr);
        removeDuplicatesTwoPointer(arr);
    }
}
