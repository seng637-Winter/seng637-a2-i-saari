package org.jfree.data.test;

import org.jfree.data.Range;

public class Sandbox {

	
	public static void main(String[] args) {
		Range exampleRange = new Range(-1,1);
		System.out.println(exampleRange.constrain(0));
		System.out.println(exampleRange.constrain(1));
		System.out.println(exampleRange.constrain(2));
	}
}
