package com.xiaohe.reflect;

import com.xiaohe.User;
import com.xiaohe.reflect.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassAPI {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello World!");
        //1. Class.forName("com.xiaohe.User")
        // Class clazz = Class.forName("com.xiaohe.User");
        // System.out.println(clazz.getPackage());
        // System.out.println(clazz.getName());
        // System.out.println(clazz.getSimpleName());
        // System.out.println(clazz.getCanonicalName());
        // //2. User.class
        // Class<User> userClass = User.class;
        // System.out.println(userClass.getPackage());
        // System.out.println(userClass.getName());
        // System.out.println(userClass.getSimpleName());
        // System.out.println(userClass.getCanonicalName());
        Class clazz = Class.forName("com.xiaohe.reflect.Student");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println(field.getModifiers());
        }
        System.out.println("=======================");
        Field address = clazz.getDeclaredField("birthday");
        // address.setAccessible(true);
        System.out.println(address);
        Object o = clazz.newInstance();
        address.set(o, "2020-01-01");
        System.out.println(((Student) o).getBirthday());

        System.out.println("=======================");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(method.getModifiers());
        }

        System.out.println("=======================");
        Method add = clazz.getDeclaredMethod("add", int.class, int.class);
        Object o1 = clazz.newInstance();
        add.invoke(o1, 1, 2);

        System.out.println("=======================");
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }
        System.out.println("=======================");
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getName());
        }
    }
}
