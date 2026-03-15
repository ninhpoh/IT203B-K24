package btvn.bt05;

import java.util.Random;

public class BookingCounter extends Thread {
    TicketPool pool;
    boolean vip;

    public BookingCounter(String name, TicketPool pool, boolean vip) {
        super(name);
        this.pool = pool;
        this.vip = vip;
    }

    @Override
    public void run() {
        try {
            Ticket t = pool.holdTicket(vip);
            Thread.sleep(3000); // khách suy nghĩ
            if (new Random().nextBoolean()) { // 50% thanh toán
                pool.sellHeldTicket(t);
            } else {
                System.out.println(getName() + ": Khách không thanh toán vé " +
                        (t != null ? t.id : ""));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}