package com.example.demo.service.thread;

/**
 * @author gaonan1
 * @date 2020/12/26 13:59
 **/
public class TestSyncLockImplWithWaits {

    private static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        int N = 10;
        Thread[] threads = new Thread[N];
        Thread[] threadsForWaits = new Thread[N];
        for(int i = 0; i < N; ++i){
            threads[i] = new Thread(new Runnable(){
                @Override
                public void run() {
                    synchronized(lock){
                        System.out.println(Thread.currentThread().getName() + " nowait get lock");
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }

            });
        }
        for(int i = 0; i < N; ++i){
            threadsForWaits[i] = new Thread(new Runnable(){
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    synchronized(lock){
                        System.out.println(Thread.currentThread().getName() + " wait first get lock");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                        System.out.println(Thread.currentThread().getName() + " wait second get lock");
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }

            });
        }

        for(int i = 0; i < N; ++i){
            threadsForWaits[i].start();
            Thread.sleep(200);
        }
        synchronized(lock){
            for(int i = 0; i < N; ++i){
                threads[i].start();
                Thread.sleep(200);
            }
            for(int i = 0; i < 4 ; ++i){
                lock.notify();
            }
            Thread.sleep(200);
        }


        for(int i = 0; i < N; ++i) {
            threads[i].join();
        }

        for(int i = 0; i < N; ++i) {
            threadsForWaits[i].join();
        }

    }
}
