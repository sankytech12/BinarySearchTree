package Binary_Tree;

public class Balance_Binary_tree {
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
	public class BalancedPair{
		boolean isbal=true;
		int ht=-1;
	}
	class Solution {
	    public boolean isBalanced(TreeNode root) {
	        return isbalance(root).isbal;
	    }

		private BalancedPair isbalance(TreeNode root) {
			// TODO Auto-generated method stub
			if(root==null) {
				return new BalancedPair();
			}
			BalancedPair lbp=isbalance(root.left);
			BalancedPair rbp=isbalance(root.right);
			BalancedPair sbp=new BalancedPair();
			sbp.ht=Math.max(lbp.ht, rbp.ht)+1;
			int bf=Math.abs(lbp.ht-rbp.ht);
			sbp.isbal=lbp.isbal&&rbp.isbal&&bf<=1;
			return sbp;
		}
	}
}
