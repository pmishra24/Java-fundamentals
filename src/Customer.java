import java.util.ArrayList;

public class Customer {
    private ArrayList<Report> report;
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        if(customerName == null || customerName.isEmpty())
            throw new InvalidReportException("Customer name cannot be null");

        this.customerName = customerName;
    }

    public ArrayList<Report> getReport() {
        return report;
    }

    public void setReport(ArrayList<Report> report) {
        this.report = report;
    }

    public Customer(String customerName)
    {
        this.setCustomerName(customerName);
    }
}
