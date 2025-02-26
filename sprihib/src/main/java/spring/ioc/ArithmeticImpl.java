package spring.ioc;

public class ArithmeticImpl implements Arithmetic {
	@Override
	public int add(int a,int b) {
		System.out.println("Add a = "+a+" B = "+b);
		return a+b;
	}
	
	@Override
	public int sub(int a,int b) {
		System.out.println("Sub a = "+a+" B = "+b);

		return a-b;
	}

	@Override
	public int mul(int a,int b) {
		
		System.out.println("Mul a = "+a+" B = "+b);

		return a*b;
	}

	@Override
	public int div(int a,int b) {
		System.out.println("Div a = "+a+" B = "+b);

		return a/b;
	}
}
