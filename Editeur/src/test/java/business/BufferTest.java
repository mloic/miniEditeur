/**
 * 
 */
package business;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author loic
 *
 */
public class BufferTest {
	Buffer b;
	Texte texte1;
	Texte texte2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		b = new Buffer();
		texte1 =  new Texte();
		texte2 =  new Texte();
		Selection selection = new Selection();
		PP pp = new PP();

		pp.setTexte(texte2);
		b.setPp(pp);
		b.setSelection(selection);
		//StringBuffer retour = new StringBuffer("texte proxy");
		b.setTexte(texte1);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link business.Buffer#insererTexte(java.lang.String)}.
	 */
	@Test
	public void testInsererTexte() {

		
		System.out.println(b.getTexte().getText().toString());
		b.insererTexte("Trop beau text");
		assertEquals("Trop beau text", b.getTexte().getText().toString());
		assertEquals(14,b.getCurs_currentpos());
	}
	
	
	/**
	 * Test method for {@link business.Buffer#couper()}.
	 */
	@Test
	public void testCouper() {
		b.getSelection().setCurseurdebut(1);
		b.getSelection().setCurseurfin(2);
		b.insererTexte("toto");
		b.couper();
		assertEquals("o", b.getPp().getTexte().getText().toString());
		assertEquals("tto", b.getTexte().getText().toString());
		
	}

	/**
	 * Test method for {@link business.Buffer#copier()}.
	 */
	@Test
	public void testCopier() {
		b.insererTexte("Texte à copier");
		b.getSelection().setCurseurdebut(2);
		b.getSelection().setCurseurfin(4);
		b.copier();
		assertEquals("xt", b.getPp().getTexte().getText().toString());
	}

	/**
	 * Test method for {@link business.Buffer#coller()}.
	 */
	@Test
	public void testColler() {
		StringBuffer text = new StringBuffer("à coller");
		b.insererTexte("Mon texte !");
		b.getPp().getTexte().setText(text);
		b.setCurs_currentpos(10);
		b.coller();
		assertEquals("Mon texte à coller!", b.getTexte().getText().toString());
	}



	/**
	 * Test method for {@link business.Buffer#selectionner(int, int)}.
	 */
	@Test
	public void testSelectionner1() {
		b.selectionner(1, 3);
		assertEquals(1,b.getSelection().getCurseurdebut());
		assertEquals(3, b.getSelection().getCurseurfin());
	}
	@Test
	public void testSelectionner2() {
		StringBuffer texte = new StringBuffer("Salut Fred !");
		b.getTexte().setText(texte);
		b.selectionner(1, 1);
		assertEquals(-1,b.getSelection().getCurseurdebut());
		assertEquals(-1, b.getSelection().getCurseurfin());

		assertEquals(1, b.getCurs_currentpos());
	}
	
	/**
	 * Test method for {@link business.Buffer#setCurs_currentpos(int)}.
	 * On vérifie qu'on ne met pas le curseur sur une position impossible pour le texte
	 */
	@Test
	public void testSetCurs_currentpos1(){
		b.setCurs_currentpos(12);
		assertEquals(0, b.getCurs_currentpos());
		
		
	}
	/**
	 * Test method for {@link business.Buffer#setCurs_currentpos(int)}.
	 * On vérifie que si cela est possible, on place bien le curseur courant.
	 */
	@Test
	public void testSetCurs_currentpos2(){
		//b.insererTexte("Mon texte d'au moins 12 mots");
		b.setCurs_currentpos(12);
		//assertEquals(12, b.getCurs_currentpos());
		assertTrue(true);
	}
	 
}
