import org.openjdk.jol.info.ClassLayout;

/**
 * Copyright (C), 2018-2020
 * FileName: 指令重排
 * Author:   xjl
 * Date:     2020/10/7 10:33
 * Description:
 */

public class ObjectSize {
    int a = 10;
    int b = 20;
    double c = 30.0;

    public static void main(String[] args) {
        ObjectSize object=new ObjectSize();
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
    }
}
