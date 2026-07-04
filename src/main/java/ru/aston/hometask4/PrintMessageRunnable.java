package ru.aston.hometask4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class PrintMessageRunnable implements Runnable {
    private final IPrintMessage printMessage;
    private final int id;
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static int currentId;
    private static int runnableCount;

    public PrintMessageRunnable(int id, IPrintMessage printMessage) {
        this.printMessage = printMessage;
        this.id = id;
    }

    public static void start(String[] messages) {
        runnableCount = messages.length;
        IntStream.range(0, messages.length).forEach(id -> {
            var printMessage = new PrintMessage(messages[id]);
            var printMessageRunnable = new PrintMessageRunnable(id, printMessage);
            var thread = new Thread(printMessageRunnable);
            thread.start();
        });
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            lock.lock();
            try {
                while(currentId != id) {
                    condition.await();
                }
                printMessage.print();
                currentId = id == runnableCount - 1 ? 0 : id + 1;
                condition.signalAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
