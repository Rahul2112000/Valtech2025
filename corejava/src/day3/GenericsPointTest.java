package day3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GenericsPointTest {
	
	@Test
	void testString() {
		GenericsPoint p=new GenericsPoint<String>();
		p.setX("3");
		p.setY("4");
		System.out.println(p);
		
	}

	@Test
	void testInt() {
		GenericsPoint<Integer> p=new GenericsPoint<Integer>();
		p.setX(3);
		p.setY(4);
		System.out.println(p);
		
	}
	
	@Test
	void testDouble() {
		GenericsPoint p=new GenericsPoint<Double>();
		p.setX(3D);
		p.setY(4D);
		System.out.println(p);
		
	}
	
}
