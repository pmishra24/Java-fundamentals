import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class CustomerDay15 {
    private String customerName;
    private HashSet<Integer> order_ids;

    public void setCustomerName(String customerName) {
        if(customerName == null || customerName.isEmpty())
            throw  new IllegalArgumentException("Invalid Product Name");
        this.customerName = customerName;
    }
    public String getCustomerName() {
        return customerName;
    }

    public HashSet<Integer> getOrder_ids() {
        return order_ids;
    }

    public void setOrder_ids(HashSet<Integer> order_ids) {
        this.order_ids = order_ids;
    }

    public CustomerDay15(String customerName){
        this.setCustomerName(customerName);
    }

    public void addOrder(Integer order_id){
        this.order_ids.add(order_id);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof CustomerDay15)) return false;
        CustomerDay15 c = (CustomerDay15) o;
        return this.customerName.equals(c.customerName);
    }

    public int hashCode(){
        return customerName.hashCode();
    }
}
