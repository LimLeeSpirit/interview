package com.lzz.learn.javaDetail.thread;

/**
 * @author LimLee
 * @data 2020-09-17
 **/
public class DeadLock{
    private final Object mutex_read = new Object();
    private final Object mutex_write = new Object();

    public void read() {
        synchronized(mutex_read) {
            System.out.println("in read.....");
            // 打印
            synchronized(mutex_write) {
                // 打印
                System.out.println("in write......");
            }
        }
    }

    public void write() {
        synchronized(mutex_write) {
            System.out.println("in w write.....");
            // 打印
            synchronized(mutex_read){
                // 打印
                System.out.println("in w read......");
            }
        }
    }

    public static void main(String[] args) {
        DeadLock dl = new DeadLock();
        for (int i = 0; i < 20; i ++) {
//            new Thread() {
//                @Override
//                public void run() {
//                    super.run();
//                    dl.read();
//                }
//            }.start();
            new Thread(()-> dl.read()).start();
            new Thread(()-> dl.write()).start();
        }
    }
}
