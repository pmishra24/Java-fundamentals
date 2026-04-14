import java.util.*;
public class OrderReport extends Report{
    private ArrayList<String> orders;
    private static int id = 1;
    private int order_id;
    private int location_id;

    public int getId() {
        return id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        if(location_id == 0)
            throw new InvalidReportException("location id cannot be 0 for order");
        this.location_id = location_id;
    }

    public ArrayList<String> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<String> orders) {
        this.orders = orders;
    }

    public OrderReport(int location_id, ArrayList<String> orders){
        super();
        this.order_id = id++;
        this.setOrders(orders);
        this.setLocation_id(location_id);
    }

    public void generate(){
        System.out.println("Order id: " + this.order_id + " Created at: "+ this.getDate());
        System.out.println("Order location id: " + this.getLocation_id());
        System.out.println("Below are order:");
        for(String order: this.getOrders())
            System.out.println(order);
    }
}
