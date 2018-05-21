package com.werson.set;

/**
 * @author Administrator
 * @version 1.0.0
 * @since 2018/5/17
 */
public class Node {

	private int id;
	private int value;
	private Node leftNode;
	private Node rightNode;

	Node(int id, int value){
		this.id = id;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

	public void insertLeftNode(int id, int value){
		Node node = new Node(id, value);
		this.setLeftNode(node);
	}

	public void insertRightNode(int id, int value){
		Node node = new Node(id,value);
		this.setRightNode(node);
	}

}
