package com.werson.generic;

/**
 * @Auther: Administrator
 * @Date: 2018/5/3 20:20
 * @Description:
 */
public class MyStudent<T> {

	private T grade;

	public T getGrade() {
		return grade;
	}

	public void setGrade(T grade) {
		this.grade = grade;
	}

}