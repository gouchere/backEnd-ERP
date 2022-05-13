package com.erp.lymytz.api.repository.jdbc;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import javax.persistence.Entity;

public class IntrospectEntity<T extends Serializable> {

	public IntrospectEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public void introspect(T entity) {
		System.err.println("-"+entity.getClass().getSimpleName());
		for(Field f:entity.getClass().getDeclaredFields()) {
			if(f.getType().equals(entity.getClass())) {
				//effectuer un chargement simplifié de ses propriétés
			}else {
				if(hasEntityAnnotation(f)) {
					introspect(giveInstance(f));
				}else {
					System.err.println(" ---"+f.getName());
				}
			}
		}
	}
	
	private boolean hasEntityAnnotation(Field f) {
		Annotation a = f.getType().getAnnotation(Entity.class);
		if (a != null) {
			return true;
		} else {
			return false;
		}
	}
	
	
	private T giveInstance(Field f) {
		T o = null;
		try {
			Class c = Class.forName(f.getType().getName());
			Constructor[] ctors = c.getDeclaredConstructors();
			Constructor ctor = null;
			for (int i = 0; i < ctors.length; i++) {
				ctor = ctors[i];
				ctor.setAccessible(true);
				if (ctor.getGenericParameterTypes().length == 0)
					break;
			}
			ctor.setAccessible(true);
			o = (T) ctor.newInstance();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
}
