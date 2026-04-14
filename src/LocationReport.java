import java.time.LocalDateTime;

public class LocationReport extends Report {
    private String location;
    private int id;

    public String getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id == 0)
            throw new InvalidReportException("location id cannot be 0 for a location");
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocationReport(int id, String location){
        super();
        this.setLocation(location);
        this.setId(id);

    }

    public void generate()
    {
        System.out.println("Location id " + this.getId()+ " Location name " + this.getLocation() + " Created at: "+ this.getDate());
    }

}
