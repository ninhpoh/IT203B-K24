package btvn.bt05;

public class Ticket {
    String id;
    boolean isHeld = false;
    long holdExpiryTime = 0;
    boolean isVIP = false;

    public Ticket(String id) {
        this.id = id;
    }

    public synchronized boolean hold(boolean vip) {
        if (!isHeld) {
            isHeld = true;
            isVIP = vip;
            holdExpiryTime = System.currentTimeMillis() + 5000;
            return true;
        }
        return false;
    }

    public synchronized boolean sell() {
        if (isHeld) {
            isHeld = false;
            isVIP = false;
            holdExpiryTime = 0;
            return true;
        }
        return false;
    }

    public synchronized boolean isExpired() {
        return isHeld && System.currentTimeMillis() > holdExpiryTime;
    }

    public synchronized void release() {
        isHeld = false;
        isVIP = false;
        holdExpiryTime = 0;
    }
}
