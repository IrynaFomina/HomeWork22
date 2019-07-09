package org.hillel.part1;

/*1) из главного потока запустить новый поток, задать ему имя, в новом потоке с интервалом 5 секунд вывести
цифры 1 ... 5. После окончания нового потока в главном потоке вывести информацию, что поток был завершен. Для
синхронизации потоков использовать join*/

public class Part1 {
    public static void main(String[] args) {
        try {
            Thread thread = new SecondThread();
            thread.setName("ThreadName");
            thread.start();
            thread.join();
            System.out.println(thread.getName() + " thread finished");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread "+ Thread.currentThread().getName()+ " has been interrupted");
        }
    }
}

class SecondThread extends Thread{
    @Override
    public void run() {
        try {
            int count = 5;
            int sleepInterval = 1 * 1000;
            for (int i = 1; !(i > count); i++) {
                System.out.println(i);
                sleep(sleepInterval);
            }
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Thread "+ getName()+ " has been interrupted");
        }
    }
}
