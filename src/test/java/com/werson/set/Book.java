package com.werson.set;

/**
 * @author  Administrator
 * @since  2018/5/15 19:29
 * @version 1.0.0
 */
public class Book implements Comparable {

	private String name;

	private int price;

	Book(String name, int price){
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode()+price;
	}

	@Override
	public String toString() {
		return "Book{" +
				"name='" + name + '\'' +
				", price=" + price +
				'}';
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Book){
			Book book = (Book)obj;
			if(this.name.equals(book.name) && this.price==book.price){
				return true;
			}
			return false;
		}else{
			return false;
		}
	}


	@Override
	public int compareTo(Object o) {
		Book book1 = (Book) o;
		if(this.price > book1.getPrice()){
			return 1;
		}
		if(this.price < book1.getPrice()){
			return -1;
		}
		return this.name.compareTo(book1.getName());
	}
}
