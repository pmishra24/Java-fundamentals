public class Day3 {


    public static <T> void printBox(Box<T> box){
        System.out.println("Box contains "+ box.getType());
    }

    public static void main(String[] args){
        Box<String> stringBox = new Box<>("String value");
        Box<Integer> integerBox = new Box<>(123);
        Box<Dog> dogBox = new Box<>(new Dog("Bernese"));

        System.out.println("String Box: " + stringBox.getType());
        System.out.println("Integer Box: " + integerBox.getType());
        System.out.println("Dog Box: " + dogBox.getType());

        printBox(stringBox);
        printBox(integerBox);
        printBox(dogBox);
    }
}
