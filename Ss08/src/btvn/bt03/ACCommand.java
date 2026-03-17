package btvn.bt03;

public class ACCommand implements Command {
    private AC ac;
    int newTemp;

    public ACCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.on();
    }

    @Override
    public void undo() {
        ac.off();
    }
}