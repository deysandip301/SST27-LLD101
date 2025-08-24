public class ReportService {
    private ILogger logger;

    public ReportService(ILogger logger) {
        this.logger = logger;
    }

    void generate(){
        logger.log("Generating daily report...");
        System.out.println("Report contents...");
    }
}