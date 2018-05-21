package com.werson.innerclass;

/**
 * @Auther: Administrator
 * @Date: 2018/5/3 19:58
 * @Description: 内部类
 */
public class Demo2 {
	public static void main(String[] args) {
		Outer2 outer2 = new Outer2();
		Outer2.InnerClass in = outer2.new InnerClass();
		in.test();
	}
}

class Outer2{

	private String a = "hello world";

	public class InnerClass{
		public void test(){
			System.out.println(a);
		}
	}

}