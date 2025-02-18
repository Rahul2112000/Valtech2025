package day2;

import javax.management.RuntimeErrorException;

public class ExceptionExample {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Authentictor auth=new Authentictor();
		
		try {
			long code =auth.authenticate("scott", "tiger");
			System.out.println("Auth code= "+ code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			System.out.println("I always be executed....");
		}

	}

}
