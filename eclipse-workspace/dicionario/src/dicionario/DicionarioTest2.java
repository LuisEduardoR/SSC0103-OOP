package dicionario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DicionarioTest2 {

	private Dicionario<Integer, String> dict;
	
	@Before
	public void setUp() throws Exception {
		
		dict = new Dicionario<Integer, String>(5);
		
	}

	@Test
	public void testGetSize() {
		
		assertEquals(dict.getSize(), 5);
		
	}

	@Test
	public void testGetLength() {
		
		int t[] = new int[6];
		int r[] = {0,1,1,2,5,5};
		
		t[0] = dict.getLength();
		dict.add(1, "a");
		
		t[1] = dict.getLength();
		
		dict.add(1, "a");
		t[2] = dict.getLength();
		
		dict.add(2, "a");
		t[3] = dict.getLength();
		
		dict.add(3, "b");
		dict.add(4, "c");
		dict.add(5, "d");
		t[4] = dict.getLength();
		
		dict.add(30, "z");
		t[5] = dict.getLength();
		
		assertArrayEquals(r, t);
		
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testContains() {
		fail("Not yet implemented");
	}

	@Test
	public void testContainsValue() {
		fail("Not yet implemented");
	}

}
