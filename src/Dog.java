public class Dog extends Animal{
    public Dog(String soundType){
        super(soundType);
    }
    public void sound(){
        System.out.println("Dog: " + this.getSoundType());
    }
}
