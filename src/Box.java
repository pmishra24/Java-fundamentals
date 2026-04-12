import java.awt.*;

public class Box<T> {
    private T type;

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public Box(T type){
        this.setType(type);
    }
}
