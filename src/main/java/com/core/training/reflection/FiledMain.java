package com.core.training.reflection;

import java.lang.reflect.Field;

/**
 * @Author huangyulu
 * @Date 2026/1/17 13:37
 * @Description
 */
public class FiledMain {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        /*
        * 对任意的一个Object实例，只要我们获取了它的Class，就可以获取它的一切信息。

        我们先看看如何通过Class实例获取字段信息。Class类提供了以下几个方法来获取字段：

        Field getField(name)：根据字段名获取某个public的field（包括父类）
        Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
        Field[] getFields()：获取所有public的field（包括父类）
        Field[] getDeclaredFields()：获取当前类的所有field（不包括父类）
        *
        *
        * */

        Class<User> userClass = User.class;
        Field[] fields = userClass.getFields();
        for (Field field : fields) {
            System.out.println("fields: " + field.getName());
        }

        Field[] declaredFields = userClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("declaredFields: " + field.getName());
        }

//        Field name = userClass.getField("name"); // throw exception: java.lang.NoSuchFieldException: name
        Field nameDeclared = userClass.getDeclaredField("name");
        /*
        * 一个Field对象包含了一个字段的所有信息：

        getName()：返回字段名称，例如，"name"；
        getType()：返回字段类型，也是一个Class实例，例如，String.class；
        getModifiers()：返回字段的修饰符，它是一个int，不同的bit表示不同的含义。
        *
        * */
        System.out.println("getName: " + nameDeclared.getName());
        System.out.println("getType: " + nameDeclared.getType());
        System.out.println("getModifiers: " + nameDeclared.getModifiers());


        // 获取字段值
        User zhangsan = new User("zhangsan", 12);
        User lisi = new User("lisiTest", 22);
        Class<? extends User> zhangsanClass = zhangsan.getClass();
        // zhangsan.getClass() => Class<User> userClass1 = User.class;
        Field name = zhangsanClass.getDeclaredField("name");
        name.setAccessible(true); // 私有属性访问，设置访问权限
        System.out.println(name.get(zhangsan));
        System.out.println(name.get(lisi));
        // 可以拿到两个对象的值，验证了Class在JVM里面只有一个实例


        // 设置值
        System.out.println("lisi.getName() before = " + lisi.getName());
        name.set(lisi, "listTest2");
        System.out.println(name.get(zhangsan));
        System.out.println(name.get(lisi));
        System.out.println("lisi.getName() after = " + lisi.getName());


    }
}
