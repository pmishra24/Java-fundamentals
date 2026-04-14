import java.util.*;

class CustomerComparator implements Comparator<Customer> {
    public int compare(Customer c1, Customer c2){
        return c1.getCustomerName().compareTo(c2.getCustomerName());
    }
}

public class DayRevision14 {


    public static void main(String[] args)
    {
        String[] order1 = {"2 router", "1 SNMP"};
        String[] order2 = {"1 router", "1 SNMP"};
        String[] order3 = {"2 router", "1 SNMP", "1 BFD"};
        String[] order4 = {"1 router", "1 SNMP", "1 BFD"};
        String[] order5 = {"1 router", "1 SNMP", "1 BFD", "2BW"};


        Report report1 = new LocationReport(1, "Dublin");
        Report report2 = new LocationReport(2, "Galway");
        Report report3 = new OrderReport(1, new ArrayList<>(List.of(order1)));
        Report report4 = new OrderReport(2, new ArrayList<>(List.of(order2)));
        Report report5 = new ProductReport(1, "Router");
        Report report6 = new ProductReport(2, "SNMP");
        Report report7 = new ProductReport(3, "BFD");
        Report report8 = new ProductReport(4, "BW");
        Report report9 = new OrderReport(3, new ArrayList<>(List.of(order3)));
        Report report11 = new OrderReport(4, new ArrayList<>(List.of(order4)));
        Report report12 = new LocationReport(3, "Waterford");
        Report report10 = new LocationReport(4, "Kilkenny");

        try {
            Report report13 = new LocationReport(0, "Unknown");
            Report report14 = new OrderReport(0, new ArrayList<>(List.of(order5)));
            Report report15 = new ProductReport(0, "Abc");
        }
        catch (InvalidReportException e)
        {
            System.out.println(e.getMessage());
        }


        Customer a = new Customer("A");
        ArrayList<Report> reports = new ArrayList<>();
        reports.add(report1);
        reports.add(report2);
        reports.add(report3);
        reports.add(report4);
        reports.add(report5);
        reports.add(report6);

        a.setReport(reports);

        Customer b = new Customer("B");
        reports = new ArrayList<>();
        reports.add(report7);
        reports.add(report8);
        reports.add(report9);
        reports.add(report10);
        reports.add(report11);
        reports.add(report12);

        b.setReport(reports);

        HashMap<String, Customer> hs = new HashMap<>();
        hs.put(a.getCustomerName(), a);
        hs.put(b.getCustomerName(), b);

        ArrayList<Customer> customers = new ArrayList<>(hs.values());
        customers.sort(new CustomerComparator());

        for(Customer customer: customers){
            System.out.println(customer.getCustomerName());
        }
        String fetchCustomer = "A";
        Customer fetchedCustomer = hs.get(fetchCustomer);

        System.out.println();
        System.out.println("Customer name: " + fetchedCustomer.getCustomerName());
        ArrayList<Report> customerReports = fetchedCustomer.getReport();
        System.out.print("Recently added report: ");
        customerReports.getLast().generate();
        for(Report r: customerReports) {
            r.generate();
        }

    }
}
