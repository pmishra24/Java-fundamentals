import java.util.*;
public class OrderReport extends Report implements Reportable{
    List<String> orders;
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
