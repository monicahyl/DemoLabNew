package com.core.training.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author huangyulu
 * @Date 2026/1/17 14:00
 * @Description
 */
public class MethodMain {

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        /*
        * Class类提供了以下几个方法来获取Method：

        Method getMethod(name, Class...)：获取某个public的Method（包括父类）
        Method getDeclaredMethod(name, Class...)：获取当前类的某个Method（不包括父类）
        Method[] getMethods()：获取所有public的Method（包括父类）
        Method[] getDeclaredMethods()：获取当前类的所有Method（不包括父类）
        *
        *
        * */

        Class<Student> studentClass = Student.class;
        Method[] methods = studentClass.getMethods();
        for (Method method : methods) {
//            System.out.println(method.getName() + " " + method.getReturnType());
        }

        Method method = studentClass.getMethod("getScore", String.class);
        System.out.println(method.getName() + " " + method.getReturnType());

//        Method method1 = studentClass.getMethod("countScore", null); throw exception:java.lang.NoSuchMethodException: com.core.training.reflection.Student.countScore()
        Method method1 = studentClass.getDeclaredMethod("countScore", null);
        System.out.println(method1.getName() + " " + method1.getReturnType());


        /*
        * 一个Method对象包含一个方法的所有信息：

        getName()：返回方法名称，例如："getScore"；
        getReturnType()：返回方法返回值类型，也是一个Class实例，例如：String.class；
        getParameterTypes()：返回方法的参数类型，是一个Class数组，例如：{String.class, int.class}；
        getModifiers()：返回方法的修饰符，它是一个int，不同的bit表示不同的含义。
        *
        * */


        System.out.println(method.getName());
        System.out.println(method.getReturnType());
        System.out.println(method.getParameterTypes().length);
        System.out.println(method.getModifiers());

        // 调用方法 invoke(p1,p2); p1:实例对象，p2:参数列表
        Student student = studentClass.newInstance();
        Object invoke = method.invoke(student, "student");
        System.out.println(invoke);
        //
        Object invoke1 = method.invoke(student, "abc");
        System.out.println(invoke1);


        // 调用静态方法 调用静态方法时，由于无需指定实例对象，
        // 所以invoke方法传入的第一个参数永远为null
        Method staticMethod = studentClass.getMethod("getSchoolNetWork", null);
        Object invoke2 = staticMethod.invoke(null, null);
        System.out.println("invoke2 = " + invoke2);

        // 调用非public方法
        Method countScore = studentClass.getDeclaredMethod("countScore", null);
//        Object invoke3 = countScore.invoke(student, null); // 直接调用：Exception in thread "main" java.lang.IllegalAccessException:
        // Class com.core.training.reflection.MethodMain can not access a member of class com.core.training.reflection.Student with modifiers "private"
        countScore.setAccessible(true);
        Object invoke3 = countScore.invoke(student, null);
        System.out.println("invoke3 = " + invoke3);


        // 多态,父类and子类都定义了hello()，且子类覆盖了hello()
        // 从父类class获取Method，作用于子类的实例，调用哪个方法？
        Class<User> userClass = User.class;
        Method method2 = userClass.getMethod("hello");
        method2.invoke(student);

        // 因此，使用反射调用方法时，仍然遵循多态原则：即总是调用实际类型的覆写方法（如果存在）
    }
}
