package exercise;
import java.util.Set;

public class EmployeeLDAPAdapter implements Employee {
    private final EmployeeLDAP employeeLDAP;
    
    public EmployeeLDAPAdapter(EmployeeLDAP employeeLDAP) {
        this.employeeLDAP = employeeLDAP;
    }

    @Override
    public String getId() {
        Set<String> keys = this.employeeLDAP.attrKeys();
        if (keys.contains("uid"))
            return this.employeeLDAP.get("uid");
        throw new RuntimeException("There is not key with id");
    }

    @Override
    public String getFirstName() {
        Set<String> keys = this.employeeLDAP.attrKeys();
        if (keys.contains("givenName"))
            return this.employeeLDAP.get("givenName");
        throw new RuntimeException("There is not name present.");
    }

    @Override
    public String getLastName() {
        Set<String> keys = this.employeeLDAP.attrKeys();
        if (keys.contains("sn"))
            return this.employeeLDAP.get("sn");
        throw new RuntimeException("There is not surname given.");
    }

    @Override
    public String getEmail() {
        Set<String> keys = this.employeeLDAP.attrKeys();
        if (keys.contains("mail"))
            return this.employeeLDAP.get("mail");
        throw new RuntimeException("There is not mail given.");
    }
    
}
