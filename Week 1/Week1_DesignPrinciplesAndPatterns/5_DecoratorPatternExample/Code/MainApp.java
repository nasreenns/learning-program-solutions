public class MainApp {
    public static void main(String[] args) {
        Notifier baseNotifier = new EmailNotifier();

        Notifier smsNotifier = new SMSNotifierDecorator(baseNotifier);
        Notifier slackAndSMS = new SlackNotifierDecorator(smsNotifier);

        slackAndSMS.send();
    }
}
