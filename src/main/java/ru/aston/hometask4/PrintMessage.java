package ru.aston.hometask4;

public class PrintMessage implements IPrintMessage {
    private final String message;

    public PrintMessage(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(message);
    }
}
