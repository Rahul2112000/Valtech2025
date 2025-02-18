package day3;

public class SimpleInterestimpl implements SimpleInterest {
	
	
	public static void main(String[] args) {
		SimpleInterest si=new SimpleInterestimpl();
		
		System.out.println(si.computeInterest(2000, 12, 3));
		
		SimpleInterest newSi=new SimpleInterestimpl() {
		
			
			@Override
			public double computeInterest(double principle, double ratOfInterest, double duration) {
				// TODO Auto-generated method stub
				return super.computeInterest(principle, ratOfInterest, duration);
			}
		};
			
			System.out.println(si.computeInterest(2000, 12, 3));
			
			//SimpleInterest lambdaSi=(p,r,d) ->  p*r*d/100;
			
		
	}
}
