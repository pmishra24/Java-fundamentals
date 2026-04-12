import java.util.*;
public class OrderReport extends Report implements Reportable{
    private List<String> orders;

    public List<String> getOrders() {
        return orders;
    }

    public OrderReport(String customerName, String generatedDate, List<String> orders){
        super(customerName, generatedDate);
        this.orders = orders;
    }

    public void generate(){
        this.printHeader();
        for(String order: this.orders)
            System.out.println(order);
    }
}
