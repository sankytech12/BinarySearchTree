package Binary_Tree;

public class Construct_BT_Pre_In {
	
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	 
	class Solution {
	   
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        return Create(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
	    }

		private TreeNode Create(int[] preorder, int plo, int phi, int[] inorder, int ilo, int ihi) {
			// TODO Auto-generated method stub
			if(plo>phi||ilo>ihi) {
				return null;
			}
			
			TreeNode nn=new TreeNode(preorder[plo]);
			int i=Search(inorder,ilo,ihi,preorder[plo]);
			int netel=i-ilo;
			nn.left=Create(preorder, plo+1, plo+netel, inorder, ilo, i-1);
			nn.right=Create(preorder, plo+netel+1, phi, inorder, i+1, ihi);
			return nn;
		}

		private int Search(int[] inorder, int ilo, int ihi, int i) {
			// TODO Auto-generated method stub
			for (int j = ilo; j <=ihi; j++) {
				if(inorder[j]==i) {
					return j;
				}
			}
			return -1;
		}
		
	}
}
