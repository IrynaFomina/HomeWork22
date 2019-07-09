package org.hilel.part2;
/*
* 2) Из главного потока А создать и запустить новый поток  В, в котором вызвать Thread.sleep на 10с.
В главном потоке А сгенерировать случайное число N от 1 до 10. Вызвать interrupt у нового потока по истечению N секунд
*  в главном потоке. В потоке В корректно обработать исключение.  */

import java.util.Random;

public class Part2_1 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " started ");

        Thread thread = new Thread(new BThread());
        int random = new Random().nextInt(10);
        thread.start();
        try {
            Thread.sleep(5 * 1000);
            thread.interrupt();
            Thread.sleep(2000);
            System.out.println("isInterrupted: " + thread.isInterrupted());
            System.out.println(thread.getName() + " status " + thread.getState().toString());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread " + Thread.currentThread().getName() + " has been interrupted");

        }
    }
}

class BThread implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started ");
        try {
            Thread.sleep(10 * 1000);
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread " + Thread.currentThread().getName() + " has been interrupted");
            System.out.println(Thread.currentThread().getName() + " isInterrupted: " + Thread.currentThread().isInterrupted());

        }
    }
}
