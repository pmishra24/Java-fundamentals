import java.util.*;

public class Main
{
    public static void main (String[] args)
    {
        Reportable report = new LocationReport("Prashant Mishra",
                            "01-01-2024", "Dublin");
        report.generate();

        List<Reportable> reports = new ArrayList<>();
        reports.add(new LocationReport("Prashant",
            "01-01-2025", "Lucan"));
        reports.add(new OrderReport("Abhi Mishra", "01-02-2026",
                Arrays.asList("Cisco","Huewai","ISR4431")));

        for(Reportable report1 : reports)
            report1.generate();

    }
}