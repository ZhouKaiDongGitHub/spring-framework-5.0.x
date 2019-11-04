package com.luban.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 第一种方式获取Class对象
 * Student stu1=new Student();
 * Class stuClass=stu1.getClass();
 *  第二种方式获取Class对象
 *  Class stuClass2=Student.class;
 *  System.out.println(stuClass == stuClass2);
 *  第三种方式获取Class对象
 *  Class clazz = Class.forName("com.luban.reflect.User");
 */
public class ReflectTest {
	public static void main(String[] args) {
		try {
			/**
			 *  第三种方式获取Class对象
			 */
			Class clazz = Class.forName("com.luban.reflect.User");
			//1.调用set方法赋值 2.直接属性赋值
			User user = (User) clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field:fields) {
				field.setAccessible(true);
				if(field.getName().equals("name")){
					field.set(user,"kzhou");
				}else if(field.getName().equals("passward")){
					field.set(user,"11111");
				}
			}
			System.out.println(user.toString());
			Class clazz1 = Class.forName("com.luban.reflect.Student");
			Student student = (Student) clazz1.newInstance();
			Method[] methods = clazz1.getDeclaredMethods();
			for (Method m :methods) {
				if(m.getName().equals("setStudentId")){
					m.invoke(student,1);
				}else if(m.getName().equals("setUser")){
					m.invoke(student,user);
				}
			}
			System.out.println(student.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
