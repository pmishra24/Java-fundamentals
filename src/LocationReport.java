public class LocationReport extends Report implements Reportable {
    String location;
    public LocationReport(String customerName, String generatedDate, String location){
        super(customerName, generatedDate);
        this.location = location;
    }

    public void generate()
    {
        this.printHeader();
        System.out.println("Location name " + location);
    }

}
