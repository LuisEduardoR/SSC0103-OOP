package listaLigada;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaLigadaTest {

	ListaLigada<Par<Integer, Double>> lista;
	
	@Before
	public void setUp() throws Exception {
		
		lista = new ListaLigada<Par<Integer, Double>>();
		
	}

	@After
	public void tearDown() throws Exception {
		
		lista = null;
		
	}

	@Test
	public void testPushBackAndPopBackSingle() {
	
		Par<Integer, Double> p = new Par<Integer, Double>(1, 2.5);
		lista.pushBack(p);
		
		Par<Integer, Double> q = lista.popBack();
		assertEquals(p, q);
		
	}
	
	@Test
	public void testPushFrontAndPopFrontSingle() {
	
		Par<Integer, Double> p = new Par<Integer, Double>(1, 2.5);
		lista.pushFront(p);
		
		Par<Integer, Double> q = lista.popFront();
		assertEquals(p, q);
		
	}
	
	@Test
	public void testPopEmpty() {
	
		
		Par<Integer, Double> q = lista.popBack();
		Par<Integer, Double> s = lista.popFront();
		assertEquals(null, q);
		assertEquals(null, s);
		
	}
	
	@Test
	public void testPushBackAndPopBack() {
	
		Par<Integer, Double> a = new Par<Integer, Double>(1, 2.5);
		Par<Integer, Double> b = new Par<Integer, Double>(2, 3.5);
		Par<Integer, Double> c = new Par<Integer, Double>(3, 4.5);
		Par<Integer, Double> d = new Par<Integer, Double>(4, 5.5);
		lista.pushBack(a);
		lista.pushBack(b);
		lista.pushBack(c);
		lista.pushBack(d);
		
		Par<Integer, Double> x = lista.popBack();
		Par<Integer, Double> y = lista.popBack();
		Par<Integer, Double> z = lista.popBack();
		Par<Integer, Double> w = lista.popBack();
		
		assertEquals(d.getPrimeiro(), x.getPrimeiro());
		assertEquals(c.getPrimeiro(), y.getPrimeiro());
		assertEquals(b.getPrimeiro(), z.getPrimeiro());
		assertEquals(a.getPrimeiro(), w.getPrimeiro());
		
		assertEquals(d.getSegundo(), x.getSegundo());
		assertEquals(c.getSegundo(), y.getSegundo());
		assertEquals(b.getSegundo(), z.getSegundo());
		assertEquals(a.getSegundo(), w.getSegundo());
		
		assertEquals(null, lista.popBack());
		
	}
	
	@Test
	public void testPushFrontAndPopFront() {
	
		Par<Integer, Double> a = new Par<Integer, Double>(1, 2.5);
		Par<Integer, Double> b = new Par<Integer, Double>(2, 3.5);
		Par<Integer, Double> c = new Par<Integer, Double>(3, 4.5);
		Par<Integer, Double> d = new Par<Integer, Double>(4, 5.5);
		lista.pushFront(a);
		lista.pushFront(b);
		lista.pushFront(c);
		lista.pushFront(d);
		
		Par<Integer, Double> x = lista.popFront();
		Par<Integer, Double> y = lista.popFront();
		Par<Integer, Double> z = lista.popFront();
		Par<Integer, Double> w = lista.popFront();
		
		assertEquals(d.getPrimeiro(), x.getPrimeiro());
		assertEquals(c.getPrimeiro(), y.getPrimeiro());
		assertEquals(b.getPrimeiro(), z.getPrimeiro());
		assertEquals(a.getPrimeiro(), w.getPrimeiro());
		
		assertEquals(d.getSegundo(), x.getSegundo());
		assertEquals(c.getSegundo(), y.getSegundo());
		assertEquals(b.getSegundo(), z.getSegundo());
		assertEquals(a.getSegundo(), w.getSegundo());
		
		assertEquals(null, lista.popBack());
		
	}

}
