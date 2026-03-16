package bt03;

public class PaymentProcessor {
    public void processCOD(CODPayable codPayable, double amount) {
        codPayable.processCOD(amount);
    }

    public void processCard(CardPayable cardPayable, double amount) {
        cardPayable.processCreditCard(amount);
    }

    public void processEWallet(EWalletPayable eWalletPayable, double amount) {
        eWalletPayable.processMomo(amount);
    }
}