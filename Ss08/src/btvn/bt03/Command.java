package btvn.bt03;

public interface Command {
    void execute();

    void undo();
}