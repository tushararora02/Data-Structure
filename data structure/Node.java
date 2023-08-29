package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	Integer data;
	Node left;
	Node right;
	
	public Node(Integer data)
	{
		this.data=data;
		this.left=null;
		this.right=null;
	}
	
	public void insert(Integer data) 
	{
		if(this.data!=null) {
			if(data<this.data) 
			{
				
				if(this.left!=null) {
					this.left.insert(data);
				}
				else {
					this.left=new Node(data);
				}
				
			}
			else if(data>this.data) 
			{
				if(this.right!=null) {
					this.right.insert(data);
				}
				else {
					this.right=new Node(data);
				}
				
			}
		}
		else {
			this.data=data;
		}
		
	}
	
	public void delete(Integer data) {
		if(this.data!=null)
		{
			if(data<this.data) {
				if(this.left!=null) {
					
					this.left.delete(data);
				}
			}
			else if(data>this.data)
			{
				if(this.right!=null)
				{
					this.right.delete(data);
				}
			}
			else 
			{
				if(this.right==null) {
					Node temp=this.left;
					if(temp!=null) {
						this.data=temp.data;
						this.left=temp.left;			
					}
					else {
						this.data=null;
					}
				}
				else if(this.left==null) {
					Node temp=this.right;
					if(temp!=null) {
						this.data=temp.data;
						this.right=temp.right;
					}
					else {
						this.data=null;
					}
					
				}
				else {
					
					Node temp=this.right;
					while(temp.left!=null)
					{
					temp=temp.left;
					}
					this.data=temp.data;
					if(this.right!=null) {
						this.right.delete(temp.data);
					
					}
				}
			}
			
		}
		else {
			System.out.println(" cannot delete the node");
		}
		
		
	}
	
	public List<Integer> inorderTraversal(){
		List<Integer> res=new ArrayList<>();
		if(this.data!=null) 
		{
//			12
//		10	   13   10 12 13
			if(this.left!=null) 
			{res=this.left.inorderTraversal();} 
			res.add(this.data);
			if(this.right!=null)
			{res.addAll(this.right.inorderTraversal());}
		}
		return res;
		
	}
	
	
	public List<Integer> preOrderTraversal(){
		
		List<Integer> res=new ArrayList<>();
		if(this.data!=null) {
			res.add(this.data);
			if(this.left!=null)
				res.addAll(this.left.preOrderTraversal());
			if(this.right!=null)
				res.addAll(this.right.preOrderTraversal());
			
		}
		return res;
	}
	public List<Integer> postOrderTraversal(){
		
		List<Integer> res =new ArrayList<>();
		if(this.data!=null) {
			if(this.left!=null)
			res=this.left.postOrderTraversal();
			if(this.right!=null)
			res.addAll(this.right.postOrderTraversal());
			res.add(this.data);
			
		}
		
		
		
		
		return res;
	}
	
	
	public void  printInordertraversal(Node root) {
		
		  if(root.data!=null && root!=null)
		{
			 
		  	   
		if(root.left!=null)
		{	this.printInordertraversal(root.left);  }
		
		 System.out.println(root.data);
		if(root.right!=null)
			{this.printInordertraversal(root.right);}
	     }
	}

	public Integer height() {
		Integer leftnode=0;
		Integer rightnode=0;
		if(this.data==null) {
			return 0;
		}
		if(this.left!=null) {
			leftnode=this.left.height();
			
		}
		if(this.right!=null) {
			rightnode=this.right.height();
		}
		if(leftnode<rightnode) {
			
			return rightnode+1;
		}
		else {
			return leftnode+1;
		}
		
		
	}
	public Boolean checkthetreeisBalanced(Node root) {
		
		Integer diff=0;
		Integer leftnodeheight=0;
		Integer rightnodeheight=0;
		if(root==null) {
			return true;
		}
		if(root.left!=null)
			{leftnodeheight=root.left.height();}
		if(root.right!=null)
			{rightnodeheight=root.right.height();}
		if(leftnodeheight<rightnodeheight)
			{diff=rightnodeheight-leftnodeheight;}
		else
			{diff=leftnodeheight-rightnodeheight;}
		return(diff<=1) && this.checkthetreeisBalanced(root.left) && this.checkthetreeisBalanced(root.right);
	}
	
	
	public static void main(String[] args) 
	{
		Node root=new Node(12);
		root.insert(10);
		root.insert(15);
		root.insert(9);
		root.insert(11);
		root.insert(13);
		
		
		System.out.println("Inorder Traversal"+root.inorderTraversal());
		System.out.println("after delete");
//		root.delete(12);
		System.out.println("Inorder Traversal"+root.inorderTraversal());
		System.out.println("preorder Traversal"+root.preOrderTraversal());
		System.out.println("postorder Traversal"+root.postOrderTraversal());
		root.printInordertraversal(root);
		System.out.println("height of tree:"+root.height());
		System.out.println("check the tree is balanced:"+root.checkthetreeisBalanced(root));
		
		
	}
	

}



