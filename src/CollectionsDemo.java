import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args)
    {
        TreeMap<String, Integer> hashMap = new TreeMap<>();
        TreeSet<String> hashSet = new TreeSet<>();
        hashMap.put("Prashant", 89);
        hashMap.put("Suyash", 91);
        hashMap.put("Sachin", 70);
        hashMap.put("Anmol", 68);
        hashMap.put("Prashant", 73);

        hashSet.add("Pune");
        hashSet.add("Mumbai");
        hashSet.add("Ludhiana");
        hashSet.add("Singrauli");
        hashSet.add("Mumbai");

        System.out.println("hashMap " + hashMap);
        System.out.println("hashSet "+ hashSet);

        for(String key: hashMap.keySet())
            System.out.println(key);
        for(int i: hashMap.values())
            System.out.println(i);
        for(Map.Entry<String,Integer> e: hashMap.entrySet())
            System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());

        for(String city: hashSet)
            System.out.println(city);
    }
}
