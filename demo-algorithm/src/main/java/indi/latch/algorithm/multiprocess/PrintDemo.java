package indi.latch.algorithm.multiprocess;

import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Title: PrintDemo
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2023/3/6
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
public class PrintDemo {

    private static volatile int flag = 1;

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        PrintDemo printDemo = new PrintDemo();
        printDemo.lockPrint();
    }

    private void volatilePrint() {
        Thread threadA = new Thread(() -> {
            int i = 0;
            while (i < 26) {
                if (1 == flag) {
                    System.out.print(i);
                    i++;
                    flag = 0;
                }
            }
        });

        Thread threadB = new Thread(() -> {
            char c = 'a';
            while (c <= 'z') {
                if (0 == flag) {
                    System.out.print(c);
                    flag = 1;
                    c++;
                }
            }
        });

        threadA.start();
        threadB.start();
    }

    private void lockPrint() {
        Thread threadA = new Thread(() -> {
            int i = 0;
            while (i < 26) {
                try {
                    lock.tryLock();
                    System.out.print(i);
                    i++;
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            char c = 'a';
            while (c <= 'z') {
                try {
                    lock.tryLock();
                    System.out.println(c);
                    c++;
                } finally {
                    lock.unlock();
                }
            }
        });

        threadA.start();
        threadB.start();
    }

    private void threadJoinPrint() {
        Thread threadA = new Thread(() -> {
            Thread threadB;
            int i = 0;
            while (i < 26) {
                System.out.print(i);
                i++;
            }
        });

        Thread threadB = new Thread(() -> {
            char c = 'a';
            while (c <= 'z') {
                if (0 == flag) {
                    System.out.print(c);
                    flag = 1;
                    c++;
                }
            }
        });
    }


    private static class ThreadRunnableA implements Runnable {

        private Thread thread;

        public ThreadRunnableA(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            if (Objects.isNull(thread)) {
                System.out.println();
            }
        }
    }
}