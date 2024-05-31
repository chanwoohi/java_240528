package day04;

import java.util.Scanner;

public class DowhileEx02 {
	// do-while 문 예제 2
	public static void main(String[] args) {
		/* 다음과 같이 메뉴를 출력하고 종료 메뉴를 선택하면 프로그램이 종료되는 코드를 작성하세요.
		 * 메뉴
		 * 1. 프로그램 실행
		 * 2. 프로그램 저장
		 * 3. 프로그램 불러오기
		 * 4. 프로그램 종료
		 * 메뉴 선택 : 1
		 * */
		Scanner scan = new Scanner(System.in);
		char ch;
		do {
			System.out.println("메뉴");
			System.out.println("1. 프로그램 실행");
			System.out.println("2. 프로그램 저장");
			System.out.println("3. 프로그램 불러오기");
			System.out.println("4. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			ch = scan.next().charAt(0);
		}while(ch != '4');
		System.out.println("프로그램을 종료합니다.");
		
	}

}
