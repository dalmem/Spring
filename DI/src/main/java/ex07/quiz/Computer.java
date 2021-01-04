package ex07.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Computer {
	
	//키보드, 마우스, 모니터에 대한 멤버변수를 만들고, resource, autowired를 사용해서 자동주입.
	//main에서 computer의 info기능을 확인
	
	@Qualifier("monitor")
	private Monitor monitor;
	
	@Qualifier("mouse")
	private Mouse mouse;
	
	@Qualifier("keyboard")
	private Keyboard keyboard;
	
	public void computerInfo() {
		monitor.info();
		mouse.info();
		keyboard.info();
	}

	
	
}
