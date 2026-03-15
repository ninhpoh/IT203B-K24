package btvn.bt04;

import java.util.Random;

public class BookingCounter implements Runnable {
    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;
    private int soldCount = 0;
    private Random random = new Random();

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    @Override
    public void run() {
        while (true) {
            TicketPool chosenRoom = random.nextBoolean() ? roomA : roomB;
            Ticket ticket = chosenRoom.sellTicket(counterName);

            if (ticket != null) {
                soldCount++;
                System.out.println(counterName + " bán vé phòng " + chosenRoom.getRoomName());
                System.out.println(counterName + " đã bán vé " + ticket.getTicketId());
            }
        }
    }

    public int getSoldCount() {
        return soldCount;
    }

    public boolean sellCombo() {
        Ticket ticketA = null;
        Ticket ticketB = null;

        synchronized (roomA) {
            synchronized (roomB) {
                ticketA = roomA.sellTicket(counterName);
                ticketB = roomB.sellTicket(counterName);
            }
        }

        if (ticketA != null && ticketB != null) {
            System.out.println(counterName + " bán combo thành công: " +
                    ticketA.getTicketId() + " & " + ticketB.getTicketId());
            soldCount += 2;
            return true;
        } else {
            if (ticketA != null) ticketA.setSold(false);
            if (ticketB != null) ticketB.setSold(false);
            System.out.println(counterName + ": Combo thất bại");
            return false;
        }
    }
}