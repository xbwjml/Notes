package chapter4;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotifyDemo {

    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "waitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "notifyThread");
        notifyThread.start();

    }

    static class Wait implements Runnable{
        @Override
        public void run() {
            //加锁，拥有lock的monitor
            synchronized (lock) {
                //当条件不满足时,继续wait，同时释放了lock的锁
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread()+" flag is true, wait "
                                +new SimpleDateFormat("HH:mm:ss").format(new Date()) );
                        lock.wait();
                    }catch (InterruptedException e){

                    }
                }
                //条件满足时，完成工作
                System.out.println(Thread.currentThread()+" flag is false, running "
                        +new SimpleDateFormat("HH:mm:ss").format(new Date()) );
            }
        }
    }

    static class Notify implements Runnable{
        @Override
        public void run() {
            //加锁,拥有lock的monitor
            synchronized (lock) {
                //获取lock的锁，然后进行通知，通知时不会释放lock的锁
                //直到当前线程释放了lock之后，waitThread才能从wait方法中返回
                System.out.println(Thread.currentThread()+" hold lock, notify "
                        +new SimpleDateFormat("HH:mm:ss").format(new Date()) );
                lock.notifyAll();
                flag = false;
                SleepUtils.sleepSecond(5);
            }

            //再次加锁
            synchronized (lock){
                System.out.println(Thread.currentThread()+" hold lock again, sleep "
                        +new SimpleDateFormat("HH:mm:ss").format(new Date()) );
                SleepUtils.sleepSecond(5);
            }
        }
    }
}
