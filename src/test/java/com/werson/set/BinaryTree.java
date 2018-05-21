package com.werson.set;

/**
 * 二叉树
 * @author Administrator
 * @version 1.0.0
 * @since 2018/5/17
 */
public class BinaryTree {

	private Node root;//根节点

	BinaryTree(){
		root = null;
	}

	BinaryTree(int value){
		root = new Node(0, value);
	}

	public Node getRootNode(){
		return root;
	}

	public void insertNode(int value) {
		Node node = new Node(0, value);
		if(root == null){
			root = node;
		}else{
			traverse(node, root);
		}
	}

	private void traverse(Node node, Node root){
		if(node.getValue() < root.getValue()){
			Node leftNode  = root.getLeftNode();
			if(leftNode == null){
				root.setLeftNode(node);
			}else{
				traverse(node, leftNode);
			}
		}else{
			Node rightNode = root.getRightNode();
			if(rightNode == null){
				root.setRightNode(node);
			}else{
				traverse(node, rightNode);
			}
		}
	}

	public void printTree(){
		traverseTree(root);
	}

	private void traverseTree(Node node){
		if(node != null){
			traverseTree(node.getLeftNode());
			System.out.println(node.getValue());
			traverseTree(node.getRightNode());
		}
	}

	public Node find(int num){
		Node node = root;
		while (true){
			if(node.getValue() == num){
				return node;
			}else if(node.getValue() < num){
				node = node.getRightNode();
				if(node == null){
					return null;
				}
			}else{
				node = node.getLeftNode();
				if(node == null){
					return null;
				}
			}
		}
	}


}
