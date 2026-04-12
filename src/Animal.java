public abstract class Animal{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if(name == null || name.isEmpty())
            throw new AnimalException("Invalid animal name");
        this.name = name;
    }

    public Animal(String name)
    {
        this.setName(name);
    }

    public abstract void makeSound();
}