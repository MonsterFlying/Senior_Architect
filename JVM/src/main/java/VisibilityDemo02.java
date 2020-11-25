/**
 * Copyright (C), 2018-2020
 * FileName: VisibilityDemo01
 * Author:   xjl
 * Date:     2020/10/8 15:25
 * Description: 目标是多线程下的访问的不可见性的现象
 */

/**
 * 在多线程的下的内存不可见的的现象
 * <p>
 * 采用的是加锁的一种方式,或使用的工作内存的数据的失效 这个时候需要重新在主内存中加载的新的数据
 * 或者是的采用的是的 voilate的关键字
 */

public class VisibilityDemo02 {

    public static void main(String[] args) {
        //开启一个线程
        Mythread2 mythread = new Mythread2();
        mythread.start();

        //主线程
//        while (true) {
//            /**
//             * 使用加锁 或使用的工作内存的数据的失效 这个时候需要重新在主内存中加载的新的数据
//             */
//            synchronized (mythread) {
//                if (mythread.isFlag()) {
//                    System.out.println("主线程进入循环的执行");
//                }
//            }
//        }

        //主线程2
        while (true) {
            if (mythread.isFlag()) {
                System.out.println("主线程进入循环的执行");
            }
        }
    }
}

/**
 * @description TODO
 * @param: null
 * @date: 2020/11/25 14:15
 * @return:
 * @author: xjl
 */
class Mythread2 extends Thread {
    /**
     * 成员变量
     */
    private volatile boolean flag = false;

    /**
     * @description TODO
     * @param:
     * @date: 2020/11/25 14:15
     * @return: void
     * @author: xjl
     */
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag=" + flag);
        super.run();
    }

    /**
     * @description TODO
     * @param:
     * @date: 2020/11/25 14:16
     * @return: boolean
     * @author: xjl
     */
    public boolean isFlag() {
        return flag;
    }
}
