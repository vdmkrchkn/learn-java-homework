package ru.aston.hometask4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {
    private static final Lock lock1 = new ReentrantLock(true);
    private static final Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) throws InterruptedException {
        Runnable process1 = () -> {
            lock1.lock();
            System.out.println("lock1 acquired. Waiting to acquire lock2");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock2.lock();
            System.out.println("lock2 acquired.");
            lock1.unlock();
            lock2.unlock();
        };

        new Thread(process1).start();

        Runnable process2 = () -> {
            lock2.lock();
            System.out.println("lock2 acquired. Waiting to acquire lock1");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock1.lock();
            System.out.println("lock1 acquired.");
            lock1.unlock();
            lock2.unlock();
        };

        new Thread(process2).start();
        Thread.currentThread().join();
    }
}
