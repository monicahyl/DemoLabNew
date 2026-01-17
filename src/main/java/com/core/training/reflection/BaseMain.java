package com.core.training.reflection;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author huangyulu
 * @Date 2026/1/17 11:46
 * @Description
 */
public class BaseMain {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        /*
        * 什么是反射？
          反射就是Reflection，Java的反射是指程序在运行期可以拿到一个对象的所有信息。
          解决了在运行期，对某个实例一无所知的情况下，如何调用其方法。
        *
        * 1. 除了基本数据类型，其他类型，包括interface都是属于class,也就是说，
        * 他们都是可以在运行期通过反射获取信息的
        * */




        /*
         *
         * 如何获取一个class的Class实例？有三个方法：
         * 1）类名.class
         * 2) Class.forName("全类名");
         * 3) 对象.getClass();
         *
         * */

        Class<String> stringClass = String.class;
        System.out.println(stringClass);

        Class<?> aClass = Class.forName("java.lang.String");
        System.out.println(aClass);

        Integer num = new Integer(10);
        Class<? extends Integer> iClass = num.getClass();
        System.out.println(iClass);


        // Class实例，在JVM中是唯一的
        /*
        * 一个Class实例包含了该class的所有完整信息：

            ┌───────────────────────────┐
            │      Class Instance       │────▶ String
            ├───────────────────────────┤
            │name = "java.lang.String"  │
            ├───────────────────────────┤
            │package = "java.lang"      │
            ├───────────────────────────┤
            │super = "java.lang.Object" │
            ├───────────────────────────┤
            │interface = CharSequence...│
            ├───────────────────────────┤
            │field = value[],hash,...   │
            ├───────────────────────────┤
            │method = indexOf()...      │
            └───────────────────────────┘
        *
        *由于JVM为每个加载的class创建了对应的Class实例，并在实例中保存了该class的所有信息，
        * 包括类名、包名、父类、实现的接口、所有方法、字段等，
        * 因此，如果获取了某个Class实例，我们就可以通过这个Class实例获取到该实例对应的class的所有信息。
        * 这种通过Class实例获取class信息的方法称为反射（Reflection）。

        * */
        System.out.println(stringClass == aClass);

        Class<User> userClass = User.class;
        System.out.println(userClass);

        User user1 = new User();
        User user2 = new User();
        Class<? extends User> aClass1 = user1.getClass();
        Class<? extends User> aClass2 = user2.getClass();

        System.out.println(aClass1 == aClass2);

        Class<Integer> integerClass = int.class;
        System.out.println(integerClass);

        // print base class info
        System.out.println("Class name:" + userClass.getName());
        System.out.println("Simple name:" + userClass.getSimpleName());
        System.out.println("Package name:" + userClass.getPackage().getName());
        System.out.println("is interface:" + userClass.isInterface());
        System.out.println("is enum:" + userClass.isEnum());
        System.out.println("is array:" + userClass.isArray());
        System.out.println("is primitive:" + userClass.isPrimitive());

        /*
        *
        * 下面代码相当于new User()。
        * 通过Class.newInstance()可以创建类实例，它的局限是：
        * 只能调用public的无参数构造方法。带参数的构造方法，或者非public的构造方法都无法通过Class.newInstance()被调用。
         * */
        User user = userClass.newInstance();



    }
}
