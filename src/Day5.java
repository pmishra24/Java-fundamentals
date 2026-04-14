import java.util.HashMap;

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
    public static void main(String[] args){

        String word = "aabbcddeff";
        char firstCharacter = firstNonRepeatingCharacter(word);
        if(firstCharacter == ' ')
            System.out.println("No non-repeating character found First ");
        else
            System.out.println("First non repeating character in "+ word + " is " + firstCharacter);
    }

}
