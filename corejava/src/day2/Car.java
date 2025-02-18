package day2;

public class Car {

		private String make;
		private String model;
		private int year;
		private String varient;
		
		private int version;

		public String getVarient() {
			return varient;
		}



		public void setVarient(String varient) {
			this.varient = varient;
		}
		
	
		
		
		public Car() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		@Override
		public String toString() {
		// TODO Auto-generated method stub
			//Honda city VX 2024 Version 7
		//return make+" "+model+" "+varient+" "+year+" Version "+version;
			return new StringBuilder()
					.append(make)
					.append(" ")
					.append(model)
					.append(" ")
					.append(varient)
					.append(" ")
					.append(year)
					.append(" Version ")
					.append(version)
					.toString();
		}

		public Car(String make, String model, String varient,int year,  int version) {
			super();
			this.make = make;
			this.model = model;
			this.year = year;
			this.varient = varient;
			this.version = version;
		}
		
		public static CarBuilder builder() {
			return new CarBuilder(new Car());
		}

		@Override
		public int hashCode() {
		// TODO Auto-generated method stub
		return (toString()+"Car").hashCode();
		}
		
		
		@Override
		public boolean equals(Object obj) {
			// if obj is a car
			if(!(obj instanceof Car)) return false;
			Car car=(Car)obj;
			
			//compare obj with this
		return year ==car.year && version==car.version && make.equals(car.make) && model.equals(car.model) && varient.equals(car.varient); 
		}

		public String getMake() {
			return make;
		}
		public void setMake(String make) {
			this.make = make;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public int getVersion() {
			return version;
		}
		public void setVersion(int version) {
			this.version = version;
		}
		
		
		
		
		public static class CarBuilder{
			
			private Car car;
			public CarBuilder(Car car) {
				this.car=car;
				
			}
			public Car build() {
				return car;
			}
			
			public CarBuilder make(String make) {
				car.setMake(make);
				return this;
			}
			
			public CarBuilder model(String model) {
				car.setModel(model);
				return this;
			}
			
			public CarBuilder year(int model) {
				car.setYear(model);
				return this;
			}
			
			public CarBuilder varient(String varient) {
				car.setVarient(varient);
				return this;
			}
			public CarBuilder version(int version) {
				car.setVersion(version);
				return this;
			}
			
			
		}
		
		
		
}
