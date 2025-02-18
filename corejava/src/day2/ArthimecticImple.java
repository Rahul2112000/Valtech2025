package day2;



public class ArthimecticImple implements Arthimetic {

	@Override
	public double add(double a,double b) {
		// TODO Auto-generated method stub
		return a+b;

	}

	@Override
	public double sub(double a,double b) {
		// TODO Auto-generated method stub
		return a-b;

	}

	@Override
	public double mult(double a,double b) {
		// TODO Auto-generated method stub
		return a*b;

	}

	@Override
	public double div(double a,double b) {
		// TODO Auto-generated method stub
		return a/b;

	}
	
	public int div(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}
	public static void main(String[] args) {
		Arthimetic ari=new ArthimecticImple();
		System.out.println(ari.add(10, 20));
		System.out.println(ari.sub(10, 20));
		System.out.println(ari.mult(10, 20));
		System.out.println(ari.div(100, 20));
		
	}


	

}
