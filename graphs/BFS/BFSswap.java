public class MyTree{
	TreeNode root;
	public boolean swapSubTrees(TreeNode n1, TreeNode n2){
		if(n1 == root || n2==root)
			return false;
		
		/*search for parents*/
		LinkedList<TreeNode> Q = new LinkedList<TreeNode>();
		TreeNode p1=null, p2=null, curr=root;
		if(curr!=null)
			Q.add(curr);
		else
			return false;
		while(! Q.isEmpty()){
			cur = Q.remove();
			if(cur.left == n1 || cur.right == n1)
				p1=cur;
			if(cur.left == n2 || cur.right == n2)
				p2=cur;

			if(p1 == null || p2 == null){
				if(cur.left!=null)
					Q.add(cur.left);
				if(cur.right!=null)
					Q.add(cur.right);
			}
			else
				break;
		}
		if(p1==null || p2==null)
			return false;
		else{
			if(p1.left == n1)
				p1.left = n2;
			else
				p1.right = n2;

			if(p2.left == n2)
				p2.left = n1;
			else
				p2.right = n1;
		}
       }

	public class TreeNode<K,V>{
		K key;
		V val;
		TreeNode left;
		TreeNode right;
		/* Assume appropriate constructors and insert fns exist*/
        }
}