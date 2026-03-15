package btvn.bt05;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class TicketPool {
    String room;
    List<Ticket> tickets = new ArrayList<>();
    ReentrantLock lock = new ReentrantLock();

    public TicketPool(String room, int capacity) {
        this.room = room;
        for (int i = 1; i <= capacity; i++) {
            tickets.add(new Ticket(room + "-" + String.format("%03d", i)));
        }
    }

    public Ticket holdTicket(boolean vip) {
        lock.lock();
        try {
            for (Ticket t : tickets) {
                if (!t.isHeld) {
                    if (t.hold(vip)) {
                        System.out.println(Thread.currentThread().getName() +
                                ": Đã giữ vé " + t.id + (vip ? " (VIP)" : "") +
                                ". Vui lòng thanh toán trong 5s");
                        return t;
                    }
                }
            }
        } finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName() +
                ": Không còn vé trống ở phòng " + room);
        return null;
    }

    public void sellHeldTicket(Ticket t) {
        if (t != null && t.sell()) {
            System.out.println(Thread.currentThread().getName() +
                    ": Thanh toán thành công vé " + t.id);
        }
    }

    public void releaseExpiredTickets() {
        lock.lock();
        try {
            for (Ticket t : tickets) {
                if (t.isExpired()) {
                    System.out.println("TimeoutManager: Vé " + t.id +
                            " hết hạn giữ, đã trả lại kho");
                    t.release();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
