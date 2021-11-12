import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class DAGLCATest {

	@Test
	public void test() {
		DAGLCA a = new DAGLCA(6);
		a.addEdge(0, 1);
		a.addEdge(0, 2);
		a.addEdge(0, 3);
		a.addEdge(1, 3);
		a.addEdge(1, 4);
		a.addEdge(2, 5);
		a.addEdge(3, 5);

		assertEquals(0, a.findLCA(0, 4, 2), "The LCA of 4 and 2 is 0" );
		assertEquals(1, a.findLCA(0, 4, 5), "The LCA of 4 and 5 is 1" );
		
		DAGLCA b = new DAGLCA(6);
		b.addEdge(0, 1);
		b.addEdge(1, 2);
		b.addEdge(1, 3);
		b.addEdge(3, 5);
		b.addEdge(2, 4);

		assertEquals(1, b.findLCA(0, 4, 5), "The LCA of 4 and 2 is 1" );
		assertEquals(-1, b.findLCA(0, 6, 5), "The LCA of 6 and 5 doesn't exist" );
	}

}
