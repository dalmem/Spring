package ex03.setter;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		//MemberDAO가 DatabaseDev에 의존적이다.
//		DatabaseDev db = new DatabaseDev();
//		db.setUrl("데이터 베이스 주소");
//		db.setUid("db아이디");
//		db.setUpw("db비밀번호");
//		
//		MemberDAO dao = new MemberDAO();
//		dao.setDs(db);
//		
//		dao.info();
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("application-context.xml");
		DatabaseDev db = ctx.getBean(DatabaseDev.class);
		System.out.println(db.getUrl());

		//memberDAO 확인
		MemberDAO dao = ctx.getBean(MemberDAO.class);
		dao.info();
		
	}
}
