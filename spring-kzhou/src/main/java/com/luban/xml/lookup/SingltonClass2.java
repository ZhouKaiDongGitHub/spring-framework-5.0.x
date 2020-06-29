package com.luban.xml.lookup;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public abstract class SingltonClass2  {



	public void printProtoTypeHashCode(){
		PrototypeClass prototypeClass = getPrototypeClass();
		System.out.println(prototypeClass.hashCode());
	}

	@Lookup("prototypeClass")
	public abstract PrototypeClass getPrototypeClass();



}
