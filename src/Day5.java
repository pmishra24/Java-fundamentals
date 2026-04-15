import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Day5 {
    public static char firstNonRepeatingCharacter(String word){
        char firstCharacter = ' ';
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i< word.length(); i++)
        {
            hashMap.put(word.charAt(i), hashMap.getOrDefault(word.charAt(i), 0) + 1);
        }
        for(int i = 0; i< word.length(); i++)
        {
            if(hashMap.get(word.charAt(i)) == 1)
                return word.charAt(i);
        }

        return firstCharacter;
    }
    public static HashMap<String, ArrayList<String>> groupAnagram(ArrayList<String> words){
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for(String word: words)
        {
            char[] a = word.toCharArray();
            Arrays.sort(a);
            String s = String.copyValueOf(a);
            ArrayList<String> arrayList = hashMap.getOrDefault(s, new ArrayList<>());
            arrayList.add(word);
            hashMap.put(s, arrayList);
        }
        return hashMap;
    }

    public static int subarraySum(int[] arr, int k) {
        int count = 0;
        for(int i = 0; i< arr.length; i++)
        {
            int sum = 0;
            for(int j = i;j <arr.length; j++ ){
                sum = sum + arr[j];
                if(sum == k)
                    count ++;
            }
        }
        return count;
    }

    public static boolean checkAnagram(String s, String t){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        s = Arrays.toString(c);
        c= t.toCharArray();
        Arrays.sort(c);
        t = Arrays.toString(c);

        return s.equals(t);
    }

    public static boolean checkAnagramOptimised(String s, String t){
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        char[] c = s.toCharArray();
        for(char a: c)
            hashMap.put(a, hashMap.getOrDefault(a, 0) + 1);
        c= t.toCharArray();
        for(char a: c)
           hashMap.put(a, hashMap.getOrDefault(a, 0) - 1);

        for(char i: hashMap.keySet()){
            if(!hashMap.getOrDefault(i, 0).equals(0))
                return false;
        }

        return true;
    }

    public static int subarraySumOptimised(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;

        for(int num : arr) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static int binarySearch(int[] arr, int target) {
        int i= 0;
        int j = arr.length-1;

        while (i<=j){
            int k = (i+ j)/2;
            if(arr[k] == target)
                return k;
            else if (arr[k] <target)
                i = k+1;
            else
                j=k-1;
        }
        return -1;
    }

    public static int squareWithoutSqrt(int num) {
        int i= 1;
        int j = num/2;

        while (i<=j){
            int k = (i+ j)/2;
            if(k*k == num)
                return k;
            else if (k*k <num)
                i = k+1;
            else
                j=k-1;
        }
        return i-1;
    }

    public static boolean checkDuplicate(int[] arr) {
        HashMap<Integer, Integer> hashMap= new HashMap<>();
        for(int a: arr){
            if(hashMap.getOrDefault(a, 0) > 0)
                return true;
            hashMap.put(a, 1);
        }
         return false;
    }

    public static boolean checkDuplicateOptimised(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr) {
            if(!set.add(num)) return true;
        }
        return false;
    }

    public static int findSingle(int[] arr) {
        int number = arr[0];
        for(int i = 0; i<arr.length -1; i++){
            number = number ^ arr[i+1];
        }
        return number;
    }

    public static int maxProduct(int[] arr) {
        int max = arr[1];
        int secondMax = arr[0];
        for(int a: arr){
            if(max > 0 || a > 0) {
                if (max < a) {
                    secondMax = max;
                    max = a;

                } else if (secondMax < a)
                    secondMax = a;
            }
            else{
                if (max > a) {
                    secondMax = max;
                    max = a;

                } else if (secondMax > a)
                    secondMax = a;
            }

        }
        return max* secondMax;
    }

    public static int maxProductBetter(int[] arr) {
        Arrays.sort(arr);
        return Math.max(arr[0] * arr[1], arr[arr.length -1] * arr[arr.length-2]);
    }



    public static void main(String[] args){

        String word = "aabbcddeff";
        char firstCharacter = firstNonRepeatingCharacter(word);
        if(firstCharacter == ' ')
            System.out.println("No non-repeating character found First ");
        else
            System.out.println("First non repeating character in "+ word + " is " + firstCharacter);


        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        HashMap<String, ArrayList<String>> hashMap = groupAnagram(new ArrayList<>(List.of(words)));
        for(String s: hashMap.keySet()) {
            for (String t : hashMap.getOrDefault(s, new ArrayList<>()))
                System.out.print(t + " ");
            System.out.println();
        }

        int[] a = {1, -1,1,1, 3, 3};
        int k= 6;
        System.out.println(Arrays.toString(a));
        System.out.println("Subarrays with sum " + k + " is " + subarraySum(a, k));

        System.out.println("Subarrays with sum " + k + " is " + subarraySumOptimised(a, k));

        a = new int[]{1, 3, 5, 7};
        System.out.println(Arrays.toString(a));
        int target = 6;
        int result = binarySearch(a, target);
        if(result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at " + (result + 1));

        int num = 34;
        System.out.println("PPerfect square of " + squareWithoutSqrt(2));

        String s = "anagram";
        String t = "nagaram";
        System.out.println(s + " and " + t + " are anagram: " + checkAnagram(s,t));

        System.out.println(s + " and " + t + " are anagram: " + checkAnagramOptimised(s,t));

        a = new int[]{1, 2, 3, 1};
        System.out.println(Arrays.toString(a));
        System.out.println("Array has duplicate: " + checkDuplicate(a));

        System.out.println("Array has duplicate: " + checkDuplicateOptimised(a));

        a = new int[]{1, 2, 3, 1, 2};

        System.out.println(Arrays.toString(a));
        result = findSingle(a);
        if(result == -1)
            System.out.println("There is no single element in array");
        else
            System.out.println("Single element in array is : " + result);


        a = new int[]{-5, -3, -1, -2};

        System.out.println(Arrays.toString(a));
        System.out.println("Maximum product is " + maxProduct(a));
        System.out.println("Maximum product is " + maxProductBetter(a));

    }

}
