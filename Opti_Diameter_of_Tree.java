package Binary_Tree;

import Binary_Tree.Diameter_of_tree.TreeNode;

public class Opti_Diameter_of_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public class Diapair {
		int d=0;
		int ht=-1;
	}
	class Solution {
		   public int diameterOfBinaryTree(TreeNode root) {
			   return diameter(root).d;
		   }
		   public Diapair diameter(TreeNode root) {
			   	if(root==null) {
			   		return new Diapair();
			   	}
			   	
			   	Diapair ldp=diameter(root.left);
			   	Diapair rdp=diameter(root.right);
			   	Diapair sdp=new Diapair();
			   	sdp.ht=Math.max(ldp.ht, rdp.ht)+1;
			   	int dia=ldp.ht+rdp.ht+2;
			   	sdp.d=Math.max(dia, Math.max(ldp.d, rdp.d));
			   	return sdp;
		   }
	}
}
