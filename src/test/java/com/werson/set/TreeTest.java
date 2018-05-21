package com.werson.set;

import org.junit.Test;

/**
 * @author Administrator
 * @version 1.0.0
 * @since 2018/5/17
 */
public class TreeTest {

	@Test
	public void treeTest(){
		BinaryTree tree = new BinaryTree();
		tree.insertNode(5);
		tree.insertNode(3);
		tree.insertNode(31);
		tree.insertNode(33);
		tree.insertNode(6);
		tree.insertNode(4);
		tree.insertNode(1);
		tree.insertNode(9);
		tree.insertNode(10);
		tree.insertNode(5);
		tree.printTree();

		System.out.println(tree.find(33).getValue());
	}




}
