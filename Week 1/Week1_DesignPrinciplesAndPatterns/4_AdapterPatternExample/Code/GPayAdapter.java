public class GPayAdapter implements PaymentProcessor {
    private GPay gpay;

    public GPayAdapter(GPay gpay) {
        this.gpay = gpay;
    }

    public void processPayment(double amount) {
        gpay.payWithGPay(amount);
    }
}
