package day2;

import java.util.Iterator;

public class ControlStatements {
	
	
	public void testIfElse(int a) {
				if(a%2==0) {
			System.out.println("Even "+a+" yes");
		}else {
			System.out.println("A is odd "+a);
		}
	}
	
	public void testfor(int [] a) {
		for (int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
	
	
	public void testSwitch(int a) {
		switch (a) {
		case 1: 
			
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
		break;
		default:
			System.out.println("All others");
			
		}
		
		
	}
	
	//important varargs
	
	public int add(String msg,int iv,int ... a) {
		int sum=iv;
		
		for(int i=0;i<a.length;i++){
			sum+=a[i];
		}
		System.out.println(msg+" SUM = "+sum);
		return sum;
	}
	
	
	public static void main(String[] args) {
		ControlStatements cs=new ControlStatements();
		cs.testIfElse(3);
		cs.testIfElse(4);
		cs.testIfElse(0);
		cs.testIfElse(1);
		cs.testfor(new int[] {1,2,3});
		cs.testfor(new int[] {1,2,3,4,5});
		
		cs.testSwitch(1);
		cs.testSwitch(4);
		
		cs.add("sum of ",1,2);
		cs.add("sum of ",1,2,3);
		cs.add("sum of ",12,3,4,5,6);
	}
}
