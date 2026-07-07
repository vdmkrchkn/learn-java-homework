package ru.aston.hometask4;

public class PrintAlternatelyApp {
    private static final int threadsCount = 2;
    public static void main(String[] args) throws InterruptedException {
        if (args.length < threadsCount) {
            System.out.println("Передайте, пожалуйста, хотя бы пару параметров и попробуйте ещё раз!");
        } else {
            PrintMessageRunnable.start(args);
            Thread.currentThread().join();
        }
    }
}
