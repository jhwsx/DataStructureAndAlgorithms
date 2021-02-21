package com.data.structure.algorithms.d5_hashmap;

public class ThreadLocalDemo {
    private static final ThreadLocal<Boolean> booleanThreadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
       new Thread(new Runnable() {
           @Override
           public void run() {
               booleanThreadLocal.set(false);
               System.out.println("threadName=" + Thread.currentThread().getName()
                       + ", booleanValue=" + booleanThreadLocal.get());
           }
       }, "Thread1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                booleanThreadLocal.set(true);
                System.out.println("threadName=" + Thread.currentThread().getName()
                        + ", booleanValue=" + booleanThreadLocal.get());
            }
        }, "Thread2").start();

        System.out.println("threadName=" + Thread.currentThread().getName()
                + ", booleanValue=" + booleanThreadLocal.get());
    }


}
