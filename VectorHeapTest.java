/**
*VectorHeapTest, JUnit de los metodos add y remove de la clase VectorHeap
*@version: 1.0
*@author: Andrea Maybell Pena 15127 // Steven Rubio, 15044 
*@since 2016-09-29
*/

import static org.junit.Assert.*;

import org.junit.Test;

public class VectorHeapTest {

	VectorHeap<Integer> vector= new VectorHeap<Integer>();
	
	//Test metodo add(E)
	@Test
	public void addTest() {
		//prueba de que añade un valor
		vector.add(3);
		int a= vector.getFirst();
		assertEquals(a,3);
		
		//prueba de que añade varios valores en el orden correcto
		vector.add(5);
		vector.add(0);
		vector.add(2);
		int b= vector.getFirst();
		int c= vector.getData().get(1);
		int d= vector.getData().get(2);
		int e= vector.getData().get(3);
		assertEquals(b,5);
		assertEquals(c,3);
		assertEquals(d,2);
		assertEquals(e,0);
	}
	
	//Test metodo remove()
	public void removeTest()
	{
		//remueve el primero y todos los elementos se corren
		vector.remove();
		int f=vector.getFirst();
		assertEquals(f,3);
		
		vector.remove();
		int g= vector.getFirst();
		assertEquals(g,2);
		
		vector.remove();
		int h= vector.getFirst();
		assertEquals(h,0);
	}

}
