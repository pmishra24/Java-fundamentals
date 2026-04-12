public class DayRevision12 {
    public static void main(String[] args){
        try
        {
            Dog dog = new Dog("Golden");
            dog.train();
            dog.makeSound();

            dog = new Dog(null);
            dog.train();
            dog.makeSound();
        }
        catch(AnimalException e){
            System.out.println("Error "+ e.getMessage());
        }
    }
}