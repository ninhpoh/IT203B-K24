package btvn.bt03;

public class AC {
    private int temp = 25;
    private int newTemp;
    private int oldTemp;

    public AC(int temp, int newTemp, int oldTemp) {
        this.temp = temp;
        this.newTemp = newTemp;
        this.oldTemp = oldTemp;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getNewTemp() {
        return newTemp;
    }

    public void setNewTemp(int newTemp) {
        this.newTemp = newTemp;
    }

    public int getOldTemp() {
        return oldTemp;
    }

    public void setOldTemp(int oldTemp) {
        this.oldTemp = oldTemp;
    }

    public void changeTemp(int newTemp){
        this.oldTemp = this.newTemp;
        temp = newTemp;
        this.newTemp = newTemp;
    }
}