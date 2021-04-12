import java.util.ArrayList;

/**
 * Makes a tree for morse code decipher 
 * @author ecam2
 * CMSC 204 - Monshi -4/12/2021
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{

	TreeNode<String> root = null;
	TreeNode<String> temp;
	ArrayList<String> arr = new ArrayList<String>();
	
	
	public MorseCodeTree() {
		buildTree();
	}
	
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;	
	}

	
	/**
	 * Adds element to the correct position in the tree 
	 * This method will call the recursive method addNode 
	 * @param code - the code for the new node to be added
	 * @param result -  the letter for the corresponding code
	 */
	@Override
	public MorseCodeTree insert(String code, String result) {
		if(root == null)
			setRoot(new TreeNode<String>(""));
		
		addNode(root, code, result);

		return  null;
	}
	
	

	@Override
	/**
	 * This is a recursive method that adds element to the correct position in the tree based on the code.
	 *  A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. 
	 *  
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code -  the code for this particular recursive instance of addNode
	 * @param result - the data of the new TreeNode to be added
	 */
	public void addNode(TreeNode<String> root, String code, String letter) 
	{
		if(code.length() == 1)
		{
			temp = new TreeNode<String>("");
			temp.data = letter;
			
			if(code.charAt(0) == '.') 	
				root.left = temp;
			else if(code.charAt(0) == '-') 		
				root.right = temp;	
		}
		else
		{
			if(code.charAt(0) == '.') 
				root = root.left;
			else if(code.charAt(0) == '-') 
				root = root.right;

			code = code.substring(1);
			addNode(root, code, letter);
		}
	}

	
	/**
	 * Fetch the data in the tree based on the code 
	 * This method will call the recursive method fetchNode 
	 * 
	 * @param code - the code that describes the traversals to retrieve the string (letter) 
	 * @return  the string (letter) that corresponds to the code
	 */
	@Override
	public String fetch(String code) {				
		String letter = fetchNode(root, code);
		return letter;
	}

	/**
	 * This is a recursive method that fetches the data of the TreeNode that corresponds with the code.
	 *  A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. 
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		while(code.length() != 0) 
		{
			if(code.charAt(0) == '.')
				root = root.left;
			else if(code.charAt(0) == '-') 
				root = root.right;
			
			code = code.substring(1);
			fetchNode(root, code);
		}
		
		return root.data;
	}

	@Override
	/**
	 * This operation is not supported in the MorseCodeTree 
	 */
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		return null;
	}

	@Override
	/**
	 * This operation is not supported in the MorseCodeTree 
	 */
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		return null;
	}

	@Override
	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code. 
	 */
	public void buildTree() {
		insert(".", "e");
		insert("-", "t");
		
		insert("..", "i");
		insert(".-","a");
		
		insert("-.","n");
		insert("--","m");
		
		insert("...","s");
		insert("..-","u");
		insert(".-.","r");
		insert(".--","w");

		insert("-..","d");
		insert("-.-","k");
		insert("--.","g");
		insert("---","o");
		
		insert("....","h");
		insert("...-","v");
		insert("..-.","f");
		insert(".-..","l");
		insert(".--.","p");
		insert(".---","j");
		insert("-...","b");
		insert("-..-","x");
		insert("-.-.","c");
		insert("-.--","y");
		insert("--..","z");
		insert("--.-","q");
	}
	
	
	

	@Override
	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly.
	 * @return an ArrayList of the items in the linkedTree
	 */
	public ArrayList<String> toArrayList() {
		LNRoutputTraversal(root, arr);
		
		return arr;
	}

	
	
	@Override
	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder) 
	 * @param root - root of the tree
	 * @param list - the ArrayList that will hold the contents of the tree in LNR order
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root == null) {
		      return;
		    }
		
		LNRoutputTraversal(root.left, arr);
		arr.add(root.data + " ");
		LNRoutputTraversal(root.right, arr);
	}

}
