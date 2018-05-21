package com.werson.innerclass;

/**
 * @Auther: Administrator
 * @Date: 2018/5/3 20:04
 * @Description:
 */
public class Demo3 {

	public static void main(String[] args) {
		Outer3 outer3 = new Outer3();
		outer3.test();
	}
}

class Outer3{

	public void ttt(Cat cat){
		cat.makeNoise();
	}

	public void test(){
		//匿名内部类  接口实现
		Runnable runnable = () -> System.out.println("running");
		runnable.run();

		Cat cat = new Cat(){
			@Override
			public void makeNoise(){
				System.out.println("子喵");
			}
		};
		cat.makeNoise();

		ttt(new Cat(){
			@Override
			public void makeNoise(){
				System.out.println("参数式喵");
			}
		});
	}
}

class Cat{

	public void makeNoise(){
		System.out.println("喵喵喵。。。");
	}

}