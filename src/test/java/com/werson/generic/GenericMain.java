package com.werson.generic;

import java.util.Arrays;

/**
 * @Auther: Administrator
 * @Date: 2018/5/3 20:22
 * @Description:
 */
public class GenericMain {

	public static void main(String[] args) {
		/*MyStudent<String> student = new MyStudent<>();
		student.setGrade("优秀");
		String grade = student.getGrade();
		System.out.println(grade);

		MyStudent<Integer> student1 = new MyStudent<>();
		student1.setGrade(100);
		Integer grade1 = student1.getGrade();
		System.out.println(grade1);*/
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("running");
			}
		};
		getGrade(runnable);

		System.out.println(getObject(1));
		System.out.println(getObject("hello"));

	}

	private static  <T extends Runnable> void  getGrade(T... t){
		Arrays.stream(t).forEach(Runnable::run);
	}

	private static  <T> T getObject(T t){
		return t;
	}


}
