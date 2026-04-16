import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    private static int id = 1;
    private int order_id;
    private HashMap<Integer, Integer> productsWithQuantity;

    public int getOrder_id() {
        return order_id;
    }

    public HashMap<Integer, Integer> getProductsWithQuantity() {
        return productsWithQuantity;
    }

    public void setProductsWithQuantity(HashMap<Integer, Integer> productsWithQuantity) {
        this.productsWithQuantity = productsWithQuantity;
    }
    public Order(){
        this.order_id = id++;
    }
}
