public class ProductReport extends Report{
    private String product;
    private int id;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id == 0)
            throw new InvalidReportException("product id cannot be 0 for a product");
        this.id = id;
    }

    public ProductReport(int id, String product){
        super();
        this.setProduct(product);
        this.setId(id);
    }


    @Override
    public void generate() {
        System.out.println("Product id: " + this.getId() + " Product is " + this.getProduct() + " Created at: "+ this.getDate());
    }
}
