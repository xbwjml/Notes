package chapter9;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadLocalRandom;

public class Test212 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(10);
        Thread t1 = new Thread(new Producer(queue));
        Thread t2 = new Thread(new Consumer(queue));
        t1.start();
        Thread.sleep(1000);
        t2.start();
    }
}

class Producer implements Runnable{
    BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void produce(){
        try {
            int i = ThreadLocalRandom.current().nextInt(100);
            queue.put(i);
            System.out.println("往队列中加入了 : "+i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true)
            produce();
    }
}

class Consumer implements Runnable{
    BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void consume(){
        try {
            Thread.sleep(1000);
            Integer i = queue.take();
            System.out.println("                        从队列中取出了 : "+i);
        }catch (InterruptedException e){

        }
    }

    @Override
    public void run() {
        while (!queue.isEmpty())
            consume();
    }
}
