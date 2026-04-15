import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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




    }

}
