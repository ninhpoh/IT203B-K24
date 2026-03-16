package bt03;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        System.out.println("Loại thanh toán: COD");
        processor.processCOD(new CODPayment(), 500000);

        System.out.println("\nLoại thanh toán: Thẻ tín dụng");
        processor.processCard(new CreditCardPayment(), 1000000);

        System.out.println("\nLoại thanh toán: Ví MoMo");
        processor.processEWallet(new MomoPayment(), 750000);

        System.out.println("\nKiểm tra LSP");
        CardPayable payment = new CreditCardPayment();
        payment.processCreditCard(1000000);

        EWalletPayable eWalletPayment = new MomoPayment();
        eWalletPayment.processMomo(1000000);
        System.out.println("Chương trình vẫn chạy đúng");
    }
}