package day09.access;

public class AccessModifierEx01 {
	
	/* 접근 제어자 예제*/
	public static void main(String[] args) {
		Student std1 = new Student ();
		std1.grade = 10; //접근제어자가 public 이어서 다른 클래스에서 사용 가능
		std1.classNum = 1; //접근제어자가 protected 여서 같은 패키지에 있는 다른 클래스에서 사용 가능
		std1.num = 1; //접근제어자가 default 여서 같은 패키지에 있는 다른 클래스에서 사용 가능
		// std1.name = "홍길동"; //접근제어자가 private여서 다른 클래스에서 사용이 불가능
	}

}
