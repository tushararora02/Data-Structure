package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class Nodes {
	
	Nodes right;
	Nodes left;
	Integer data;

	Nodes(Integer data){
		this.data=data;
		this.right=null;
		this.left=null;
		
	}
	
	public void insert(Integer data)
	{
		if(this.data!=null) {
			if(data<this.data) 
			{
				if(this.left!=null)
				{
					this.left.insert(data);
					
				}
				else {
					
					this.left= new Nodes(data);
				}
				
			}
			else if(data>this.data)
			{
				
				if(this.right!=null)
				{
					this.right.insert(data);
					
				}
				else {
					this.right=new Nodes(data);
				}
				
			}
			
		}
		else {
			this.data=data;
		}
		
	}
	
	public void delete(Integer data)
	{
		if(data!=null)
		{
			if(this.data==null)
			{
				System.out.println("cannot delete null value");
				
			}
			else if(data<this.data) 
			{
				if(this.left!=null)
				{
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
				
				if(this.right==null)
				{
				   Nodes temp=this.left;
				   if(temp!=null)
				   {
					   this.data=temp.data;
					   this.left=temp.left;
					   
				   }
				   else {
					   
					   this.data=null;
				   }
				 }
				if(this.left==null) {
					Nodes temp=this.right;
					if(temp!=null)
					{
						this.data=temp.data;
						this.right=temp.right;
						
					}
					else {
						this.data=null;
					}
				}
				else 
				{
					Nodes temp=this.right;
					while(temp.left!=null)
					{
						temp=temp.left;
					}
					
					if(this.right!=null)
					{
						
						this.data=temp.data;
						this.right.delete(temp.data);
					}
					
					
				}
				
				
			}
			
		}
		else {
			
			
			System.out.println("cannot delete null value");
		}
	}
	
	public List<Integer> inorderTraversal()
	{
		List<Integer> res=new ArrayList<Integer>();
		if(this.data!=null)
		{
			if(this.left!=null) { res=this.left.inorderTraversal();}
			res.add(this.data);
			if(this.right!=null) { res.addAll(this.right.inorderTraversal());}
		}
		return res;
	
	}
	
	public Integer height(Nodes root) {
	
		Integer result=0;
		if(root==null)
		{ 
			return 0; 
		}
		
		Integer leftheight=this.height(root.left);
		Integer rightheight=this.height(root.right);
		if(leftheight<rightheight) 
		{
			
			result=rightheight+1;
		}
		if(rightheight<=leftheight)
		{
			result=leftheight+1;
		}
		return result;
	}
	
	
	public Boolean isBalanced(Nodes root) 
	{
		if(root==null) {
			return true;
		}
		Integer leftheight=this.height(root.left);
		Integer rightheight=this.height(root.right);
		
		Integer diff=Math.abs(leftheight-rightheight);
		
		return (diff<=1)&& this.isBalanced(root.left) && this.isBalanced(root.left);
		
	}
	
	
	
	
	public static void main(String[] args) 
	{
		Nodes root=new Nodes(12);
		root.insert(10);
		root.insert(15);
		root.insert(9);
		root.insert(11);
		root.insert(13);
		root.insert(16);
		System.out.println("Inorder Traversal"+root.inorderTraversal());
		System.out.println("after delete");
		root.delete(12);
		
		
		System.out.println("Inorder Traversal"+root.inorderTraversal());
		System.out.println("height:"+root.height(root));
		
		System.out.println("check the tree is balanced:"+root.isBalanced(root));
	}
	
	
	
	
	

}
