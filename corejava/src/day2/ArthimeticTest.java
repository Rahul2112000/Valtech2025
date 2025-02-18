package day2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArthimeticTest {
	Arthimetic ari=new ArthimecticImple();
	@Test
	void tesDivWithint() {
		assertEquals(2, ari.div(4, 2));
		assertEquals(3, ari.div(7, 2));
	}
	@Test
	void testAdd() {
		// (ans,method,precision)
		assertEquals(5, ari.add(2.3, 2.7),0.0);
	}
	@Test
	void testSub() {
		
	}
	@Test
	void testDivWithDouble() {
		/**
		 * 5./3=1.666666
		 * expect  1.6666+-0.001
		 */
	assertEquals(1.666, ari.div(5.,3),0.001);
	assertEquals(Double.POSITIVE_INFINITY, ari.div(5.0, 0),0.0001);
	}
	@Test
	void testMul() {
		
	}
	
	@Test
	void testDivWithIntDenomIsZero() {
		try {
		ari.div(3, 0);
		fail("Exception is expected");
		}catch(Exception e) {
			
		}
		
	}

}
