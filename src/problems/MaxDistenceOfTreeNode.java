package problems;



public class MaxDistenceOfTreeNode {
	
	public class TreeNode {
		public TreeNode lChild;		// lift child
		public TreeNode rChilde;	// right child
		
		public int nMaxLeft;		// max distence of left tree;
		public int nMaxRight;		// max distence of right tree;
		
		char chValue;				// the value of the node
	
	}
	
	public int maxDistence = 0;
	
	public void getMaxDistence(TreeNode root){
		if (root == null) {
			return;
		}
		
		if (root.lChild == null) {
			root.nMaxLeft = 0;
		}else {
			getMaxDistence(root.lChild);
		}
		
		
		
		if (root.rChilde == null) {
			root.nMaxRight = 0;
		}else {
			getMaxDistence(root.rChilde);
		}
		
		if (root.lChild != null) {
			if (root.lChild.nMaxLeft > root.lChild.nMaxRight) {
				root.nMaxLeft = root.lChild.nMaxLeft;
			}else {
				root.nMaxLeft = root.lChild.nMaxRight;
			}
		}
		if (root.rChilde != null) {
			if (root.rChilde.nMaxLeft > root.rChilde.nMaxRight) {
				root.nMaxRight = root.rChilde.nMaxLeft;
			}else {
				root.nMaxRight = root.rChilde.nMaxRight;
			}
		}
		
		//update the max distence
		if (root.nMaxLeft + root.nMaxRight > maxDistence ) {
			maxDistence = root.nMaxLeft + root.nMaxRight;
		}
		 
		return ;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
