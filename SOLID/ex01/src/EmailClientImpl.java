public class EmailClientImpl implements IEmailClient {
    public void sendEmail(String to, String body) {
        System.out.println("[EMAIL to=" + to + "] " + body);
    }
}