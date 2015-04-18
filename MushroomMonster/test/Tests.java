import static org.junit.Assert.*;

import org.junit.Test;


public class Tests {

	@Test
	public void t1_min(){
		MushroomSequence ms = new MushroomSequence(new int []{10,5,15,5});
		assertEquals(15, ms.minEaten());		
	}
	
	@Test
	public void t1_max(){
		MushroomSequence ms = new MushroomSequence(new int []{10,5,15,5});
		assertEquals(25, ms.maxEaten());		
	}
	
}
