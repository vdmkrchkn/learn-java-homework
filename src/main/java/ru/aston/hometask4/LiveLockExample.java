package ru.aston.hometask4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLockExample {
    private static final Lock lock1 = new ReentrantLock(true);
    private static final Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        Runnable process1 = () -> {
            while(true) {
                try {
                    lock1.tryLock(1000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("lock1 acquired. Waiting to acquire lock2");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (lock2.tryLock()) {
                    System.out.println("lock2 acquired");
                } else {
                    System.out.println("cannot acquired lock2, unlocking lock1");
                    lock1.unlock();
                    continue;
                }
                break;
            }

            lock1.unlock();
            lock2.unlock();
        };

        new Thread(process1).start();

        Runnable process2 = () -> {
            while(true) {
                try {
                    lock2.tryLock(1000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("lock2 acquired. Waiting to acquire lock1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (lock1.tryLock()) {
                    System.out.println("lock1 acquired");
                } else {
                    System.out.println("cannot acquired lock1, unlocking lock2");
                    lock2.unlock();
                    continue;
                }
                break;
            }

            lock1.unlock();
            lock2.unlock();
        };

        new Thread(process2).start();
    }
}
