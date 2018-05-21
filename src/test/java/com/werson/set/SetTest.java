package com.werson.set;

import org.junit.Test;
import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @since 2018/5/15
 */
public class SetTest {

	@Test
	public void hashSetTest(){
		Set<Book> set = new HashSet<>();
		Book b1 = new Book("简爱",100);
		Book b2 = new Book("平凡世界",100);
		Book b3 = new Book("穆斯林的葬礼",100);
		Book b4 = new Book("简爱",100);
		set.add(b1);
		set.add(b2);
		set.add(b3);
		set.add(b4);
		System.out.println(set);
	}

	@Test
	public void treeSetTest(){
		TreeSet<Book> set = new TreeSet<>();
		Book b1 = new Book("简爱",500);
		Book b2 = new Book("平凡世界",200);
		Book b3 = new Book("穆斯林的葬礼",300);
		Book b4 = new Book("简爱",400);
		set.add(b1);
		set.add(b2);
		set.add(b3);
		set.add(b4);
		System.out.println(set);
	}

	@Test
	public void linkedHashMapTest(){
		Map<String, String> map = new HashMap<>();
		map.put("e","ee");
		map.put("b","bb");
		map.put("a","aa");
		map.put("c","cc");
		map.put("d","dd");
		System.out.println(map);
		for(Map.Entry str : map.entrySet()){
			System.out.println(str);
		}
	}

	@Test
	public void stackTest(){
		Stack<String> stack = new Stack<>();
		stack.add("aa");
		stack.add("bb");
		stack.add("cc");
		stack.add("dd");
		System.out.println(stack.size());
		System.out.println(stack.pop());
	}

}
