package exercise;

public class EmployeeDBAdapter implements Employee {
    private final EmployeeDB employeeDB;

    public EmployeeDBAdapter(EmployeeDB employeeDB) {
        this.employeeDB = employeeDB;
    }

    @Override
    public String getId() {
        return String.valueOf(this.employeeDB.getId());
    }

    @Override
    public String getFirstName() {
        return this.employeeDB.getFirstName();
    }

    @Override
    public String getLastName() {
        return this.employeeDB.getSurname();
    }

    @Override
    public String getEmail() {
        return this.employeeDB.getEmailAddress();
    }
    
}
