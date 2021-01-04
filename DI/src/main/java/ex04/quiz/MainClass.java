package ex04.quiz;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
//		Battery1 b1 = new Battery1();
//		Battery2 b2 = new Battery2();
//		Airplane ap = new Airplane(b1);
//		ap.getBattery().energy();
//		Airplane ap1 = new Airplane(b2);
//		ap1.getBattery().energy();
//		Car c = new Car(b1);
//		c.getBattery().energy();
//		Car c1 = new Car(b2);
//		c1.getBattery().energy();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context.xml");
		
		Car car = ctx.getBean(Car.class);
		
		Airplane ap = ctx.getBean("ap",Airplane.class);
		
		car.getBattery().energy();
		ap.getBattery().energy();
		
		//스프링 설정파일에서 빈을 사용할 때 마다 기본적으로 싱글톤 형식을 가지고 있습니다.
		
	}
}
