import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        ProfileService svc = new ProfileService();
        UserProfile p = svc.createMinimal("u1", "a@b.com");
        System.out.println("Email: " + p.getEmail());
        // try to "modify" -> we get a new instance instead
        UserProfile p2 = p.toBuilder().email("evil@example.com").build();
        System.out.println("Original email: " + p.getEmail());
        System.out.println("New email:      " + p2.getEmail());
        System.out.println("=> In the solution, setters are gone and objects are immutable; use Builder to create modified copies.");
    }
}
