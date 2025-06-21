public class MainApp {
    public static void main(String[] args) {
        PaymentProcessor gpayProcessor = new GPayAdapter(new GPay());
        PaymentProcessor phonePeProcessor = new PhonePeAdapter(new PhonePe());

        gpayProcessor.processPayment(1000);
        phonePeProcessor.processPayment(2500);
    }
}
