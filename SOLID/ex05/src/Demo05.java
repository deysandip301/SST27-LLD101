
public class Demo05 {
    public static void main(String[] args) {
        System.out.println(new Rectangle().areaAfterResize()); // 20
        System.out.println(new Square().areaAfterResize());    // 16 (!) violates expectation
    }
}
