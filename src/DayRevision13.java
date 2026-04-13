import java.util.TreeMap;

public class DayRevision13 {
    public static void main(String[] args){
        String word = "hello";
        StringBuilder sb = new StringBuilder(word);
        sb = sb.reverse();
        System.out.println("Reverse of " + word + " is " + sb);

        StringBuilder appendNumbers = new StringBuilder();
        for(int i=1; i<=100; i++)
            appendNumbers.append(i);

        System.out.println("Concatenated 100 numbers: " + appendNumbers);

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1,"1st entry");
        treeMap.put(3, "2nd entry");
        treeMap.put(4,"3rd entry");
        treeMap.put(2, "4th entry");

        for(int i: treeMap.keySet())
            System.out.println("Key: " + i + " Value: " + treeMap.get(i));

        Day13RevisionAbstract day13RevisionAbstract = new Day13RevisionAbstractChild();
        day13RevisionAbstract.abstractMethod();

    }
}
