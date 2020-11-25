/**
 * Copyright (C), 2018-2020
 * FileName: OutOfOrder
 * Author:   xjl
 * Date:     2020/10/8 16:15
 * Description:
 */

/**
 * 研究是重排序的可能带来的问题   不一定能够直接看到的重排的效果
 * <p>
 * 使用voliate的关键字来实现的禁止重排序的效果
 */

public class OutOfOrder {
    public static int a = 0, b = 0;
    public static int i = 0, j = 0;

    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        while (true) {
            count++;
            a = 0;
            b = 0;
            i = 0;
            j = 0;
            Thread t1 = new Thread(new Runnable() {
                public void run() {
                    a = 1;
                    i = b;
                }
            });

            Thread t2 = new Thread(new Runnable() {
                public void run() {
                    b = 1;
                    j = a;
                }
            });
            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("count=" + count + "次数 i=" + i + ",j=" + j);
            if (i == 0 && j == 0) {
                break;
            }
        }
    }
}
