package day3;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.module.ModuleDescriptor.Version;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import day2.Car;

class LambdaExpressionsTest {

	@Test
	void test() {
		List<Car> cars=new ArrayList<Car>();
		cars.add(Car.builder().make("Honda").model("City").varient("ZX").year(2024).version(7).build());
		cars.add(new Car("Benz","E class","220D",2024,5));
		cars.add(Car.builder().make("Honda").model("City").varient("VX").year(2024).version(4).build());
		cars.add(Car.builder().make("Honda").model("Jazz").varient("ZX").year(2024).version(6).build());
		
		
		List<Car> newCars=new ArrayList<Car>();
		
		for (Car car : cars) {
			if(car.getVersion()>5) {
				System.out.println(car);
			}
		}
		System.out.println(newCars);
		List<Car> myNewCars=cars.stream().filter(car->car.getVersion()>5).collect(Collectors.toList());
		
		System.out.println(myNewCars);
		
		System.out.println(cars.stream().filter(car->!"Honda".equals(car.getMake())).collect(Collectors.toList()));
		
		//here we are making conversion into string to object using map
		System.out.println(cars.stream().map(car->car.getMake()).collect(Collectors.toSet()));
	
		
	}

}
