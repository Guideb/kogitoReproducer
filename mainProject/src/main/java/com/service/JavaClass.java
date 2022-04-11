package com.service;


import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;

import com.model.Object1;
import com.model.Object2;

@ApplicationScoped
public class JavaClass {
	public static ArrayList<Object2> giveMeTheList(Object1 object1) {
		return object1.getAttribute1();
	}
}
