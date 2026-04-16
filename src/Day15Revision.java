import javax.print.attribute.standard.ColorSupported;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Day15Revision {
    static HashSet<CustomerDay15> customers = new HashSet<>();
    static HashMap<Integer, Order> orders = new HashMap<>();
    static HashMap<Integer, Product> products = new HashMap<>();

    public static int totalBill(Order o){
        HashMap<Integer, Integer> productWithQty = o.getProductsWithQuantity();
        int totalBill = 0;
        for(int i: productWithQty.keySet()){
            System.out.print("Product name: " + products.get(i).getProduct_name());
            System.out.print(" Product Qty: " + productWithQty.get(i));
            System.out.println(" Product price: " + products.get(i).getPrice());
            int calculatedPrice = productWithQty.get(i) * products.get(i).getPrice();
            System.out.println("Calculated price: " + calculatedPrice);
            totalBill += calculatedPrice;
        }
        System.out.println("Total price for order "+ o.getOrder_id()+ " is: " + totalBill);
       return totalBill;
    }

    public static Order maxOrder(CustomerDay15 c){
        HashSet<Integer> order_ids = c.getOrder_ids();
        int max = 0; int order_id = 0; int i =1;
        System.out.println("Calculating maximum order for Customer " + c.getCustomerName());
        for(int o: order_ids) {
            Order order = orders.get(o);
            int totalBill = totalBill(order);
            if(max<totalBill) {
                max = totalBill;
                order_id = order.getOrder_id();
            }
        }
        System.out.println("Maximum order value for " + c.getCustomerName() + " is: " + max);
        return orders.get(order_id);
    }

    public static Product mostOrderedProduct(){
        HashMap<String, Integer> product = new HashMap<>();
        int max = 0; int productId = 0;
        for(CustomerDay15 c: customers)
        {
            HashSet<Integer> orderids = c.getOrder_ids();
            for(int j: orderids){
                Order o = orders.get(j);
                System.out.println();
                System.out.println("Looking at product for order" + o.getOrder_id());
                HashMap<Integer, Integer> productWithQty = o.getProductsWithQuantity();
                for(int i: productWithQty.keySet()){
                    String productName = products.get(i).getProduct_name();
                    int productQty =  productWithQty.get(i);
                    int addedQty = product.getOrDefault(productName, 0) + productQty;
                    System.out.print("Product: " + productName + ", Product qty: " + productQty);
                    System.out.println(", Product new Qty " + addedQty);
                    if(max< addedQty)
                    {
                        max= addedQty;
                        productId = products.get(i).getProduct_id();
                    }
                    product.put(productName, addedQty);
                }
            }
        }
        System.out.print("The most ordered Product is: Product id " + productId);
        System.out.println(", Product Name: " + products.get(productId).getProduct_name());
        return products.get(productId);
    }

    public  static  void main(String[] args){
        Product p1 = new Product("Router", 220);
        Product p2 = new Product("BFD", 50);
        Product p3 = new Product("SNMP", 60);
        Product p4 = new Product("BW", 80);
        Product p5 = new Product("DHCP", 90);
        Product p6 = new Product("Access points", 110);
        Product p7 = new Product("line Type", 140);
        Product p8 = new Product("Alarm", 180);


        products.put(p1.getProduct_id(), p1);
        products.put(p2.getProduct_id(), p2);
        products.put(p3.getProduct_id(), p3);
        products.put(p4.getProduct_id(), p4);
        products.put(p5.getProduct_id(), p5);
        products.put(p6.getProduct_id(), p6);
        products.put(p7.getProduct_id(), p7);
        products.put(p8.getProduct_id(), p8);

        Order o1 = new Order();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1,2);
        hashMap.put(3, 1);
        hashMap.put(6,1);
        o1.setProductsWithQuantity(hashMap);

        Order o2 = new Order();
        hashMap = new HashMap<>();
        hashMap.put(2,1);
        hashMap.put(3, 2);
        o2.setProductsWithQuantity(hashMap);

        Order o3 = new Order();
        hashMap = new HashMap<>();
        hashMap.put(4,3);
        hashMap.put(5, 4);
        o3.setProductsWithQuantity(hashMap);

        Order o4 = new Order();
        hashMap = new HashMap<>();
        hashMap.put(7,1);
        hashMap.put(8, 2);
        o4.setProductsWithQuantity(hashMap);

        Order o5 = new Order();
        hashMap = new HashMap<>();
        hashMap.put(1,1);
        hashMap.put(8, 2);
        o5.setProductsWithQuantity(hashMap);


        orders.put(o1.getOrder_id(), o1);
        orders.put(o2.getOrder_id(), o2);
        orders.put(o3.getOrder_id(), o3);
        orders.put(o4.getOrder_id(), o4);
        orders.put(o5.getOrder_id(), o5);


        CustomerDay15 c1 = new CustomerDay15("Prashant");
        HashSet<Integer> orderset = new HashSet<>();
        orderset.add(1);
        orderset.add(2);
        c1.setOrder_ids(orderset);

        CustomerDay15 c2 = new CustomerDay15("Sachin");
        orderset = new HashSet<>();
        orderset.add(3);
        orderset.add(4);
        c2.setOrder_ids(orderset);
        c2.addOrder(5);



        customers.add(c1);
        customers.add(c2);

        System.out.println("Calculating total bill for order order 1");
        Order o = orders.get(1);
        totalBill(o);

        System.out.println();
        maxOrder(c1);

        System.out.println();
        mostOrderedProduct();

        CustomerDay15 search = new CustomerDay15("Prashant");
        System.out.println(customers.contains(search));

    }
}
