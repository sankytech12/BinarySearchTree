package Binary_Tree;

import java.util.Scanner;



public class LCA {
	Scanner sc=new Scanner(System.in);
	public class Node{
		int data;
		Node right;
		Node left;
	}
	private Node root;
	public LCA() {
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
	public Node LcA(int p,int q) {
		return Lca(this.root,p,q);
	}
	private Node Lca(Node root2, int p, int q) {
		// TODO Auto-generated method stub
		if(root2==null) {
			return null;
		}
		if(root2.data==p||root2.data==q) {
			return root2;
		}
		Node left=Lca(root2.left, p, q);
		Node right=Lca(root2.right, p, q);
		if(left!=null&&right!=null) {
			return root2;
		}
		if(left==null) {
			return right;
		}
		else {
			return left;
		}
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
	public static void main(String[] args) {
		LCA ll=new LCA();
		System.out.println(ll.LcA(50, 60).data);
		//ll.Display();
	}
}
