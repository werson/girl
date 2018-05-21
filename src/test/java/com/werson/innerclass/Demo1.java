package com.werson.innerclass;

/**
 * @Auther: Administrator
 * @Date: 2018/5/3 19:10
 * @Description: 静态内部类，
 */
public class Demo1 {

	public static void main(String[] args) {
		Outer01.InnerClass in = new Outer01.InnerClass();
		in.test();
	}

}

class Outer01{

	private static String a = "100";

	public void test(){
		System.out.println(a);
	}

	static class InnerClass{
		void test(){
			System.out.println(a);
		}
	}

}