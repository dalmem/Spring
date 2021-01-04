package ex08.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ex02.construct.Hotel;
import ex03.setter.MemberDAO;
import ex04.quiz.Airplane;
import ex04.quiz.Car;

public class MainClass {
	public static void main(String[] args) {
		
		//자바 설정을 확인할 수 있는 클래스
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(javaConfig.class);
		
		Hotel h = ctx.getBean(Hotel.class);
		h.getChef().cooking();
		
		MemberDAO dao = ctx.getBean(MemberDAO.class);
		dao.info();
		
		//battery와 car, airplane을 자바설정으로 생성
		
		Car c = ctx.getBean(Car.class);
		c.getBattery().energy();
		Airplane air = ctx.getBean(Airplane.class);
		air.getBattery().energy();
	}
}
