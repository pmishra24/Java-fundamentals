public abstract class Report {
     private String customerName;
     private String generatedDate;
     static int reportCounter = 0;
     private int reportId;

    public void setCustomerName(String customerName) {
        if(customerName == null || customerName.isEmpty())
            throw new IllegalArgumentException("Customer Name cannot be null");
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setGeneratedDate(String generatedDate) {
        this.generatedDate = generatedDate;
    }

    public String getGeneratedDate() {
        return generatedDate;
    }

    public int getReportId() {
        return reportId;
    }

    public Report(String customerName, String generatedDate)
     {
         this.customerName = customerName;
         this.generatedDate = generatedDate;
         this.reportId = ++reportCounter;
     }

     public void printHeader()
     {
         System.out.println("Report for " + customerName);
         System.out.println("Date created " + generatedDate);
         System.out.println("Report Id " + reportId);
     }

}
