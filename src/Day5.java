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

    }

}
