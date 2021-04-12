/**
 * Makes a tree node
 * @author ecam2
 * CMSC 204 - Monshi -4/12/2021
 */
public class TreeNode<T> {
	
	protected TreeNode<T> node;
	protected TreeNode<T> left;
	protected TreeNode<T> right;
	protected T data;
	
	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode 
	 * @param dataNode - the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode) {
		this.left = null;
		this.data = dataNode;
		this.right = null;
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * used for making deep copies 
	 * @param node - node to make copy of
	 */
	public TreeNode(TreeNode<T> node) {
		try {
			this.node = node;
			node = (TreeNode<T>) node.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the data within the TreeNode
	 */
	public T getData() {
		return this.data;
	}
}
