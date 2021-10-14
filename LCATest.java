import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {
	
	
	@Test
    public void testConstructor()
    {
      new LCA();
    }
	
	@Test
	public void test() {
		LCA tree = new LCA();
		
		assertEquals("Test case for empty binary search tree", -1, tree.findLCA(1,2));
		
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.right.left = new Node(8);
        tree.root.right.right.right = new Node(9);
        
        assertEquals("The lowest common ancestor of 10 and 4 does not exist", -1, tree.findLCA(10,4));
        assertEquals("The lowest common ancestor of 2 and 11 does not exist", -1, tree.findLCA(2,11));
        assertEquals("The lowest common ancestor of 4 and 5 in this binary search tree is 2", 2, tree.findLCA(4,5));
        assertEquals("The lowest common ancestor of 6 and 7 in this binary search tree is 2", 7, tree.findLCA(8,9));
	}

}
