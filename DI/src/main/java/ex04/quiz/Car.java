package ex04.quiz;

public class Car {
	
	private IBattery battery;
	
	//생성자 주입
	public Car(IBattery battery) {
		this.battery = battery;
	}
	
	//getter
	public IBattery getBattery() {
		return battery;
	}
}
