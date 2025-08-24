public class Demo07 {
    public static void main(String[] args) {
        PrinterMachine printerMachine = new PrinterMachine();
        ScannerMachine scannermachine = new ScannerMachine();
        FaxMachine faxMachine = new FaxMachine();

        printerMachine.print("Hello");
        scannermachine.scan("/tmp/out"); // blows up
        faxMachine.fax("fax document");
    }
}
