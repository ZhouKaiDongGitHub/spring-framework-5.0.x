package com.luban.xml.test;

import com.luban.xml.lookup.SingltonClass;
import com.luban.xml.lookup.SingltonClass2;
import com.luban.xml.service.IndexServiceImpl1;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");

		/*IndexServiceImpl1 indexServiceImpl1 = (IndexServiceImpl1) context.getBean("indexServiceImpl1");
		indexServiceImpl1.delete();
		indexServiceImpl1.query();*/

		//protoType inject to singlton
		SingltonClass singltonClass = (SingltonClass)context.getBean("singlton");
		System.out.println(singltonClass.hashCode());
		singltonClass.printProtoTypeHashCode();
		SingltonClass singltonClass2 = (SingltonClass)context.getBean("singlton");
		System.out.println(singltonClass2.hashCode());
		singltonClass2.printProtoTypeHashCode();
		SingltonClass singltonClass3 = (SingltonClass)context.getBean("singlton");
		System.out.println(singltonClass3.hashCode());
		singltonClass3.printProtoTypeHashCode();

		SingltonClass2 singltonClass21 = (SingltonClass2)context.getBean("singlton2");
		System.out.println(singltonClass21.hashCode());
		singltonClass21.printProtoTypeHashCode();
		SingltonClass2 singltonClass22 = (SingltonClass2)context.getBean("singlton2");
		System.out.println(singltonClass22.hashCode());
		singltonClass22.printProtoTypeHashCode();
		SingltonClass2 singltonClass32 = (SingltonClass2)context.getBean("singlton2");
		System.out.println(singltonClass32.hashCode());
		singltonClass32.printProtoTypeHashCode();
	}
}
