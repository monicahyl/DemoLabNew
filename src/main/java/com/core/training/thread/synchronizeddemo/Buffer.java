package com.core.training.thread.synchronizeddemo;

/**
 * @Author huangyulu
 * @Date 2025/12/27 10:24
 * @Description 单缓冲区的生产者/消费者
 */
public class Buffer {

    // 单缓冲区，只放一个数据
    private int data;

    // 标识
    private boolean hasData = false;

    /**
     * 生产者，生产数据
     * @param value
     */
    public synchronized void produce(int value) throws InterruptedException {
        System.out.println("Buffer.produce start");
        while (hasData) {
            System.out.println("produce wait");
            wait(); // 生产者，缓冲区满了，不生产，等待
        }

        System.out.println("Buffer.produce produce");
        data = value;
        hasData = true;
        notifyAll(); // 生产者，缓冲区没满，生产数据，状态更新为true，唤醒所有线程，生产数据

    }

    public synchronized int consume() throws InterruptedException {
        System.out.println("Buffer.consume start");
        while (!hasData) {
            System.out.println("consume wait");
            wait(); // 消费者，缓冲区没有数据，等待,wait方法可以让当前线程释放当前对象的锁，进入WAITING，等待别人通知
        }

        System.out.println("Buffer.consume consume");
        int value = data;
        hasData = false;
        notifyAll();
        return value; // 缓冲区有数据，消费者消费，状态更新为false，唤醒所有在这个对象上Wait的线程，让他们重新竞争锁，并重新判断条件
    }

    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer();

        Thread produce = new Thread(() -> {
            try {
                System.out.println("produce thread start");
                Thread.sleep(3000);
                buffer.produce(10);
                System.out.println("produce thread end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consume = new Thread(() -> {
            try {
                System.out.println("consume thread start");
                int data = buffer.consume();
                System.out.println("consume thread end and data=" + data);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        produce.start();
        consume.start();

        produce.join();
        consume.join();


//        buffer.notify(); 抛异常，java.lang.IllegalMonitorStateException

    }


}
