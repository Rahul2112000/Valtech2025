package day5;

import static org.junit.jupiter.api.Assertions.*;

import java.security.PublicKey;
import java.util.*;

import org.junit.jupiter.api.Test;

class EnhancedUtilsTest {
	
	@Test
	public void testMap() {
		Map<String,Integer> nums=Map.of("One",1,"Two",2,"Three",3,"Four",4);
		System.out.println(nums.getClass().getName());
		
		
	}
	
	@Test
	public void testList() {
		List<Integer> nums=List.of(1,2,3,4); //imutable
		System.out.println(nums.getClass().getName());
		
		try {
			nums.add(5);
			fail("Immutable list expected");
			
		} catch (Exception e) {
			
			//e.printStackTrace();
			
			
		}
		List<Integer> nums1=new ArrayList<Integer>();
		nums1.addAll(nums);
		nums1.add(5);
	}
	
	@Test
	public void testMapConventional() {
		
		
		
		Map<String , Integer> nums=new HashMap<String,Integer>();
		nums.put("One", 1);
		nums.put("Two", 2);
		nums.put("Three", 3);
	}

	@Test
	void testListConventional() {
		List<Integer> nums=new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		
		System.out.println(nums);
		
		List<Integer> nums1=Arrays.asList(1,2,3);
		
		assertEquals(nums, nums1);
		
		
		
	}

}
