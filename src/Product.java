public class Product {
    private static int id = 1;
    private int product_id;
    private int price;
    private String product_name;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        if(product_name == null || product_name.isEmpty())
            throw  new IllegalArgumentException("Invalid Product Name");
        this.product_name = product_name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public Product(String product_name, int price)
    {
        this.setProduct_name(product_name);
        this.setPrice(price);
        this.product_id = id++;
    }
}
