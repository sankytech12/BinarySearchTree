package Binary_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class RoottoLeaf {
	Scanner sc=new Scanner(System.in);
	
		public class Node{
			int data;
			Node right;
			Node left;
		}
		private Node root;
		public RoottoLeaf() {
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
		public void root2leaf(int target) {
			rtl(this.root,target,"");
		}
			private void rtl(Node root,int t,String ans) {
			// TODO Auto-generated method stub
			if(root==null) {
				return;
			}
			if(root.left==null&&root.right==null&&t-root.data==0) {
				System.out.println(ans+root.data);
			}
			rtl(root.left, t-root.data, ans+root.data+" ");
			rtl(root.right, t-root.data, ans+root.data+" ");
		}
			public static void main(String[] args) {
				RoottoLeaf bt=new RoottoLeaf();
				Scanner sc=new Scanner(System.in);
				int sum=sc.nextInt();
				bt.root2leaf(sum);
			}
		

}
