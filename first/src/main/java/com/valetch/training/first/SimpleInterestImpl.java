package com.valetch.training.first;import java.lang.reflect.AnnotatedArrayType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleInterestImpl implements SimpleInterest {
		@Autowired
		private Arithmetic arithmetic;
		
//		public SimpleInterestImpl(Arithmetic arithmetic) {
//			this.arithmetic = arithmetic;
//			}
	 
		
		@Override
		public int compute(int pri,int time,int rate) {
			return arithmetic.div(arithmetic.mul(pri,arithmetic.mul(time, rate)),100);
		}
		
//		public void setArithmetic(Arithmetic arithmetic) {
//			this.arithmetic = arithmetic;
//		}
		
}
