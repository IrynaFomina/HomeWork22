package org.hilel.part2;
/*
* 2) Из главного потока А создать и запустить новый поток  В, в котором вызвать Thread.sleep на 10с.
В главном потоке А сгенерировать случайное число N от 1 до 10. Вызвать interrupt у нового потока по истечению N секунд
*  в главном потоке. В потоке В корректно обработать исключение.  */

import java.util.Random;

public class Part2 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " started ");
        Thread thread = new BThread();
        int random = new Random().nextInt(10);
        thread.start();
        try {
            Thread.sleep(random * 1000);
            thread.interrupt();
            thread.join();
            System.out.println(thread.getName() + " status " + thread.getState().toString());
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " has been interrupted");
        }
    }
}

class BThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started ");
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
//            currentThread().isInterrupted();
            System.out.println("Thread " + Thread.currentThread().getName() + " has been interrupted");
        }
    }
}
