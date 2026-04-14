import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

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

    public static int maxSumSubarray(int[] arr, int k){
        int sum = 0;
        int maxSum = 0;
        for(int j = 0; j<k; j++)
            sum = sum + arr[j];
        maxSum= sum;

        for(int i=0,l=k; l<arr.length; i++,l++)
        {
            sum = sum +arr[l] - arr[i];
            if(maxSum < sum)
                maxSum = sum;
        }
        return maxSum;
    }

    public static int longestSubstring(String s){
        HashSet<Character> charSet= new HashSet<>();
        int longestSubString = 0;

        for(int i=0,j = 0 ; i< s.length();)
        {
            if(charSet.contains(s.charAt(i)))
            {
                charSet.remove(s.charAt(j));
                j++;
                continue;
            }
            else
                charSet.add(s.charAt(i));
            if(charSet.size() > longestSubString)
                longestSubString = charSet.size();
            i++;
        }
        return longestSubString;
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
        int[] arr = {2, 1, 5, 1, 3, 2};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Unique element count "+ uniqueCount(arr));
        removeDuplicatesOnePointer(arr);
        removeDuplicatesTwoPointer(arr);

        //Sliding window
        arr = new int[]{4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
        System.out.println(Arrays.toString(arr));
        int k = 3;
        System.out.println("Maximum sum: " + maxSumSubarray(arr, k));

        //Longest substring
        String s = "pwwkew";
        System.out.println("Longest substring in " + s + " is "+ longestSubstring(s));

        // Comparator operator
        Player p1 = new Player("Prashant", 500);
        Player p2 = new Player("Sachin", 300);
        Player p3 = new Player("Suyash", 500);
        Player p4 = new Player("Bala Jee", 400);
        Player p5 = new Player("Anmol", 450);

        ArrayList<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        players.add(p5);
        players.sort((player1,player2) -> Integer.compare(player2.getScore(), player1.getScore()));
        for (Player p : players)
            System.out.println("Player name " + p.getName() + " Player Score: " + p.getScore());

    }
}
