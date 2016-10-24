package com.enmu;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.TypeVariable;

/**
 * Created by tancw on 2016/10/10.
 */
public enum JavaV {
	JAVA8() {
		@Override
		void print(String msg) {
			System.out.println("8: " + msg);
		}
	},
	JAVA7() {
		@Override
		void print(String msg) {
			System.out.println("7: "+ msg);
		}
	};

	static final JavaV CURRENT;
	static {
		if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
			CURRENT = JAVA8;
		} else {
			CURRENT = JAVA7;
		}
	}

	abstract void print(String msg);
}
