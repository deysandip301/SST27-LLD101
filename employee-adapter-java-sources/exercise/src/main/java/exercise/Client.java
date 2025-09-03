package exercise;

import java.util.*;

public class Client {
  public static void main(String[] args) {
    // Sample legacy data from three sources
    List<Employee> csvRows = List.of(
      new EmployeeCSVAdapter(new EmployeeCSV("101,John,Doe,john.doe@acme.com")),
      new EmployeeCSVAdapter(new EmployeeCSV("102,Sarah,Lee,sarah.lee@acme.com"))
    );

    List<Employee> dbRows = List.of(
      new EmployeeDBAdapter(new EmployeeDB(201, "Ravi", "Kumar", "ravi.kumar@contoso.com")),
      new EmployeeDBAdapter(new EmployeeDB(202, "Anita", "Sharma", "anita.sharma@contoso.com"))
    );

    List<Employee> ldapRows = List.of(
      new EmployeeLDAPAdapter(new EmployeeLDAP(Map.of("uid","301","givenName","Wei","sn","Zhang","mail","wei.zhang@example.org"))),
      new EmployeeLDAPAdapter(new EmployeeLDAP(Map.of("uid","302","givenName","Elena","sn","Garcia","mail","elena.garcia@example.org")))
    );

    // TODO: Wrap each legacy object with the right adapter and collect into one list
    List<Employee> all = new ArrayList<>();
    all.addAll(csvRows);
    all.addAll(dbRows);
    all.addAll(ldapRows);


    EmployeePrinter.print(all);
  }
}
