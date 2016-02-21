package devEx1;

import java.util.*;
import java.util.Map.Entry;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode (int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	public TreeNode (TreeNode n) {
		this.data = n.data;
		this.left = n.left;
		this.right = n.right;
	}
}

class QItem {
	TreeNode node;
	int hd;
	
	public QItem(TreeNode n, int h) {
		node = n;
		hd = h;
	}
}
class BinTree {
	TreeNode root;
	int maxLevel = 0;
	public BinTree(){root = null;}
	public BinTree(TreeNode n ){root = n;}

	public void printTopView() {
		
	}
	public void printLevelOrder() {
		Queue<TreeNode> Q = new LinkedList<TreeNode>();
		
		Q.add(new TreeNode(root));
		while (!Q.isEmpty()){
			TreeNode curr = Q.remove();
			System.out.print(curr.data + "   ");
			
			if (curr.left != null)
				Q.add(new TreeNode(curr.left));
			if (curr.right != null)
				Q.add(new TreeNode(curr.right));
			
		}
	}
	public void bottomView() {
		if (root == null)
			return;
		
		Map<Integer, Integer> map = new TreeMap<>();
		
		Queue<QItem> Q = new LinkedList<QItem>();
		
		Q.add(new QItem(root,0));
		while (!Q.isEmpty()){
			QItem curr = Q.remove();
			
			int hd = curr.hd;
			
			map.put(hd, curr.node.data);
			if (curr.node.left != null)
				Q.add(new QItem(curr.node.left,hd-1));
			if (curr.node.right != null)
				Q.add(new QItem(curr.node.right,hd+1));
			
		}
		Set<Entry<Integer,Integer>> set = map.entrySet();
		Iterator<Entry<Integer,Integer>> it = set.iterator();
		
		while(it.hasNext()){
			Map.Entry<Integer, Integer> me = it.next();
			System.out.print(me.getValue()+" ");
		}
	}
	
	public void topView() {
		if (root == null)
			return;
		
		HashSet<Integer> hs = new HashSet<Integer>();
		
		Queue<QItem> Q = new LinkedList<QItem>();
		
		Q.add(new QItem(root,0));
		while (!Q.isEmpty()){
			QItem curr = Q.remove();
			
			int hd = curr.hd;
			
			if (!hs.contains(hd)) {
				System.out.print(curr.node.data + "   ");
				hs.add(hd);
			}
			if (curr.node.left != null)
				Q.add(new QItem(curr.node.left,hd-1));
			if (curr.node.right != null)
				Q.add(new QItem(curr.node.right,hd+1));
			
		}
	}
	
	public void printRightView(TreeNode root, int level) {
		
		if (root == null)
			return;
		if (level > maxLevel) {
			System.out.print(root.data + "  ");
			maxLevel=level;
		}
		printRightView(root.right,level+1);
		printRightView(root.left,level+1);
		
	
	}
	public boolean isMirror(TreeNode node1, TreeNode node2) {
		if ((node1 == null) && (node2 == null))
			return true;
		if (node1!= null && node2 != null && (node1.data == node2.data )){
				System.out.print(node1.data);
				System.out.print("    ");
				System.out.println(node2.data);
				return isMirror(node1.left,node2.right) && isMirror(node1.right,node2.left);
		} 
			
		return false;
		
	}
	public void isMirrorTree(TreeNode root) {
		System.out.println("\nData of root is" + root.data + "  :  " + root.left.data + " :  " +root.right.data);
		if (isMirror(root,root) == true) {
        	System.out.println("\nTree is Mirror View of Binary Tree");
        } else {
        	System.out.println("\nTree is Not Mirror View of Binary Tree");
        }
        
	}
	public void printLeftView(TreeNode root, int level) {
		
		if (root == null)
			return;
		if (level > maxLevel) {
			System.out.print(root.data + "  ");
			maxLevel=level;
		}
		printLeftView(root.left,level+1);
		printLeftView(root.right,level+1);
		
	
	}
	public boolean isPalin(TreeNode root1, TreeNode root2){
		if (root1 == null && root2 == null)
			return true;
		if((root1.left != null) && (root2.right != null)) {
				isPalin(root1.left,root2.right);
		} else if(root1.left != null){
				isPalin(root1.left,null);
		} else {
				isPalin(null, root2.right);
		}
					
		if(root1.data != root2.data)
			return false;
		if (root1.right != null || root2.left != null){
				isPalin(root1.right,root2.left);
			} else if(root1.right != null){
				isPalin(root1.right,null);
			} else {
				isPalin(null, root2.left);
			}
				
		return true;

	}
	public void isPalindrome(TreeNode root) {
		if (isPalin(root,root) == true) {
        	System.out.println("\nTree is Palindrome");
        } else {
        	System.out.println("\nTree is Not Palindrome");
        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(14);
        root.left.right.left = new TreeNode(25);
        root.left.right.left.left = new TreeNode(225);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        BinTree t = new BinTree(root);
        System.out.println("Following are nodes in Level Order traversal of Binary Tree");
        t.printLevelOrder();
        System.out.println("\nFollowing are nodes in Left view of Binary Tree");
        t.maxLevel = 0;
        t.printLeftView(root, 1);
        System.out.println("\nFollowing are nodes in Right view of Binary Tree");
        t.maxLevel = 0;
        t.printRightView(root, 1);
        System.out.println("\nFollowing are nodes in Top view of Binary Tree");
        t.topView();
        System.out.println("\nFollowing are nodes in Bottom view of Binary Tree");
        t.bottomView();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        BinTree t1 = new BinTree(root1);
        t1.isMirrorTree(root1);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.right.left = new TreeNode(4);
        BinTree t2 = new BinTree(root2);
        t2.isPalindrome(t2.root);
        
        

	}

}
