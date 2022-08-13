package Binary_Tree;

public class Validate_BST {
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
		 
		public class BstPair{
		    boolean isbst=true;
		    Long max=Long.MIN_VALUE;
		    Long min=Long.MAX_VALUE;
		}
		class Solution {
		    public boolean isValidBST(TreeNode root) {
		        return validate(root).isbst;
		    }
		    public BstPair validate(TreeNode root) {
		    	if(root==null) {
		    		return new BstPair();
		    	}
		    	BstPair lbp=validate(root.left);
		    	BstPair rbp=validate(root.right);
		    	BstPair sbp=new BstPair();
		    	if(lbp.isbst==true &&rbp.isbst==true && lbp.max<root.val&&rbp.min>root.val) {
		    		sbp.isbst=true;
		    		sbp.max=Math.max(rbp.max,root.val);
		    		sbp.min=Math.min(lbp.min,root.val);
		    		return sbp;
		    	}
		    	sbp.isbst=false;
		    	sbp.max=Math.max( rbp.max,Math.max(lbp.max,root.val));
		    	sbp.min=Math.min(rbp.min,Math.min(lbp.min, root.val));
		    	return sbp;
		    }
		}
}
