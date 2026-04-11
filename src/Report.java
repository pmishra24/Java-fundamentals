public abstract class Report {
     String customerName;
     String generatedDate;

     public Report(String customerName, String generatedDate)
     {
         this.customerName = customerName;
         this.generatedDate = generatedDate;
     }

     public void printHeader()
     {
         System.out.println("Report for " + customerName);
         System.out.println("Date created " + generatedDate);
     }

}
