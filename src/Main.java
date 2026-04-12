import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
    public static void main (String[] args)
    {
        Reportable report = new LocationReport("Prashant Mishra",
                            "01-01-2024", "Dublin");
        report.generate();
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Sleep interrupted" + e.getMessage());
        }

        LocationReport lr =  new LocationReport();
        try{
            lr.loadFromFile("report.txt");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found " + e.getMessage());
        }
        finally{
            System.out.println("This always runs");
        }
        try {
            lr.setCustomerName(null);
        }
        catch (InvalidReportException e){
            System.out.println("Error in setting customer name "+ e.getMessage());
        }

        List<Reportable> reports = new ArrayList<>();
        reports.add(new LocationReport("Prashant",
            "01-01-2025", "Lucan"));
        reports.add(new OrderReport("Abhi Mishra", "01-02-2026",
                Arrays.asList("Cisco","Huewai","ISR4431")));

        for(Reportable report1 : reports)
        {
            if(report1 instanceof LocationReport lrr)
                System.out.println("Location "+lrr.location );
            if(report1 instanceof OrderReport or)
                System.out.println("Order Count"+or.getOrders().size());

            report1.generate();
        }
    }
}