package com.werson.set;

import java.util.Comparator;

/**
 * 书本对象比较
 * @author Administrator
 * @version 1.0.0
 * @since 2018/5/16
 */
public class BookComparable implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		Book book1 = (Book) o1;
		Book book2 = (Book) o2;
		if(book1.getPrice() > book2.getPrice()){
			return 1;
		}
		if(book1.getPrice() < book2.getPrice()){
			return -1;
		}
		return book1.getName().compareTo(book2.getName());
	}
}
