public class Dog extends Animal implements Trainable{

    public Dog(String name)
    {
        super(name);
    }
    @Override
    public void makeSound() {
        System.out.println(this.getName() + " Barks");
    }

    @Override
    public void train() {
        System.out.println("Training in progress");
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Training Interrupted");
        }

        System.out.println("Training completed");
    }
}
