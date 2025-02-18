package day3;

public interface SimpleInterest {
	public default double computeInterest(double principle,double ratOfInterest,double duration) {
		
		return principle*ratOfInterest*duration/100;
		
		
		
		
	}
}
