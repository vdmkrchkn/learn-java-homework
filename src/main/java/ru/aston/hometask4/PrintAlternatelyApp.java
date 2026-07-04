package ru.aston.hometask4;

public class PrintAlternatelyApp {
    public static void main(String[] args) throws InterruptedException {
        if (args.length < 2) {
            System.out.println("Передайте, пожалуйста, хотя бы пару параметров и попробуйте ещё раз!");
        } else {
            PrintMessageRunnable.start(args);
            Thread.currentThread().join();
        }
    }
}
