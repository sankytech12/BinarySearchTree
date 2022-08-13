package Binary_Tree;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {
	Scanner sc=new Scanner(System.in);
	public class Node{
		int data;
		Node right;
		Node left;
	}
	private Node root;
	public BinaryTree() {
		// TODO Auto-generated constructor stub
		this.root=createCycle();
	}
	private Node createCycle() {
		// TODO Auto-generated method stub
		int item=sc.nextInt();
		Node nn=new Node();
		nn.data=item;
		boolean hlc=sc.nextBoolean();
		if(hlc==true) {
			nn.left=createCycle();
		}
		boolean hrc=sc.nextBoolean();
		if(hrc==true) {
			nn.right=createCycle();
		}
		return nn;
	}
	
	public void Display() {
		display(this.root);
	}
	private void display(Node nn) {
		// TODO Auto-generated method stub
		if(nn==null) {
			return;
		}
		String str="";
		str=str+nn.data;
		str="<---"+str+"--->";
		if(nn.left!=null) {
			str=nn.left.data+str;
		}
		else {
			str="."+str;
		}
		if(nn.right!=null) {
			str=str+nn.right.data;
		}
		else {
			str=str+".";
		}
		System.out.println(str);
		display(nn.left);
		display(nn.right);
	}
	
	public int max() {
		return max(this.root);
	}
	private int max(Node nn) {
		if(nn==null) {
			return Integer.MIN_VALUE;
		}
		int lm=max(nn.left);
		int lr=max(nn.right);
		return Math.max(lm,Math.max(lr, nn.data));
	}
	public boolean find(int item) {
		return find(this.root,item);
	}
	private boolean find(Node nn,int item) {
		if(nn==null) {
			return false;
		}
		if(nn.data==item) {
			return true;
		}
		return find(nn.left,item)||find(nn.right, item);
	}
	public int ht() {
		return ht(this.root);
	}
	private int ht(Node nn) {
		if(nn==null) {
			return -1;
		}
		int lt=ht(nn.left);
		int rt=ht(nn.right);
		return Math.max(lt, rt)+1;
	}
	public void preOrder() {
		preOrder(this.root);
		System.out.println();
	}
	private void preOrder(Node nn) {
		// TODO Auto-generated method stub
		if(nn==null) {
			return;
		}
		System.out.print(nn.data+" ");
		preOrder(nn.left);
		preOrder(nn.right);
	}
	public void postOrder() {
		postOrder(this.root);
		System.out.println();
	}
	private void postOrder(Node nn) {
		// TODO Auto-generated method stub
		if(nn==null) {
			return;
		}
		postOrder(nn.left);
		postOrder(nn.right);
		System.out.print(nn.data+" ");
		
	}
	public void inOrder() {
		inOrder(this.root);
		System.out.println();
	}
	private void inOrder(Node nn) {
		// TODO Auto-generated method stub
		if(nn==null) {
			return;
		}
		inOrder(nn.left);
		System.out.print(nn.data+" ");
		inOrder(nn.right);
	}
	public void levelOrder() {
		levelOrder(this.root);
	}
	private void levelOrder(Node nn) {
		// TODO Auto-generated method stub
		LinkedList<Node> qq=new LinkedList<BinaryTree.Node>();
		qq.add(nn);
		while(!qq.isEmpty()) {
			Node rv=qq.remove();
			System.out.print(rv.data+" ");
			if(rv.left!=null) {
				qq.add(rv.left);
			}
			if(rv.right!=null) {
				qq.add(rv.right);
			}
		}
		System.out.println();
		
	}
}
