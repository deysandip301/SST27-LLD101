package exercise;


public class EmployeeCSVAdapter implements Employee {
    private final EmployeeCSV employeeCSV;

    public EmployeeCSVAdapter(EmployeeCSV employeeCSV) {
        this.employeeCSV = employeeCSV;
    }
    
    private String[] getTokens() {
        return employeeCSV.tokens();
    }
    
    @Override
    public String getId() {
        return this.getTokens()[0];
    }

    @Override
    public String getFirstName() {
        return this.getTokens()[1];
    }

    @Override
    public String getLastName() {
        return this.getTokens()[2];
    }

    @Override
    public String getEmail() {
        return this.getTokens()[3];
    }

}
