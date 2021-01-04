package ex08.javaconfig;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;

import ex02.construct.Chef;
import ex02.construct.Hotel;
import ex03.setter.DatabaseDev;
import ex03.setter.MemberDAO;
import ex04.quiz.Airplane;
import ex04.quiz.Battery1;
import ex04.quiz.Battery2;
import ex04.quiz.Car;

@Configuration //이 클래스가 스프링 설정파일이라는 것을 표기 - xml문서를 대신한다
public class javaConfig {
	
	
	//@Bean이 붙은 메서드를 스프링컨테이너가 객채로 생성합니다.
	@Bean
	public Chef chef() {
		return new Chef();
		
	}
	@Bean
	public Hotel hotel() {
		return new Hotel(chef());
	}
//	<bean id="db" class="ex03.setter.DatabaseDev">
//		<property name="url" value="bean으로넣은데이터베이스주소"/>
//		<property name="uid" value="bean으로넣은아이디"/>
//		<property name="upw" value="bean으로넣은비밀번호"/>
//	</bean>
//
//	<bean id="memberDAO" class="ex03.setter.MemberDAO">
//		<property name="ds" ref="db"></property>
//	</bean>
	
	@Bean
	public DatabaseDev db() {
		DatabaseDev dev = new DatabaseDev();
		dev.setUrl("자바로 설정한 데이터베이스 주소");
		dev.setUid("자바로 설정한 아이디");
		dev.setUpw("자바로 설정한 비밀번호");
		
		return dev;
	}
	
	@Bean
	public MemberDAO memberDAO() {
		
		MemberDAO dao = new MemberDAO();
		dao.setDs(db());
		return dao;
	}
	
	@Bean
	public Battery1 battery1() {
		return new Battery1();
	}
	@Bean
	public Battery2 battery2() {
		return new Battery2();
	}
	
	@Bean
	public Car car() {
		 
		
		return new Car(battery2());
		
	}
	@Bean Airplane airplane() {
		Airplane air = new Airplane();
		air.setBattery(battery2());
		return air;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
