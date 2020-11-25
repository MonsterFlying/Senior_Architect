/**
 * Copyright (C), 2018-2020
 * FileName: voilatedemo03
 * Author:   xjl
 * Date:     2020/10/8 15:48
 * Description: voilate的不保证原子操作
 *
 *
 * count++不是的原子的操作：
 * 1 从主存中读取的到工作内存中
 * 2 对工作内存的数据的进行++操作
 * 3 将工作的数据写回到的主内存
 *
 * 在多线程的下 要保证数据的安全性问题使用的vollate 不安全 还是需要使用的锁的机制
 */

public class VoilateDemo03 {
    public static void main(String[] args) {
        //创建一个线程对象
        Runnable taget = new ThreadTarget();

        for (int i = 1; i <= 100; i++) {
            new Thread(taget, "第" + i + "线程").start();
        }
    }
}

class ThreadTarget implements Runnable {
    //定义一个共享变量
    private volatile int count = 0;

    public void run() {
        for (int i = 1; i <= 10000; i++) {
            count++;
            System.out.println(Thread.currentThread().getName() + "count=>>>>>>>>>>" + count);
        }
    }
}
