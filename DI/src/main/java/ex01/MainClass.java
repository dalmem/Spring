package ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
//		SpringTest st = new SpringTest();
//		st.test();
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("application-context.xml");
		
		SpringTest st = ctx.getBean(SpringTest.class);
		st.test();
		
		//스프링 설정파일에서 빈을 사용할 때마다
		SpringTest st2 = ctx.getBean(SpringTest.class);
		System.out.println(st == st2);
		
		
	}
}
