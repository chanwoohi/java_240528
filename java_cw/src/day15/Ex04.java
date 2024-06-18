package day15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		/* 1 ~ 45 사이의 중복되지 않은 6개의 번호와 1개의 보너스 번호를 랜멈으로 생성하고,
		 * 사용자가 번호를 6개 입력해서 몇 등인지 맞추는 로또 예제 
		 * 1등 : 번호 6개가 일치
		 * 2등 : 번호 5개와 보너스 번호 일치
		 * 3등 : 번호 5개가 일치
		 * 4등 : 번호 4개가 일치
		 * 5등 : 번호 3개가 일치
		 * 나머지 꽝*/
		
		// 로또 번호와 보너스 번호를 생성
		// 로또 번호 생성
		int count = 0 ;
		Scanner scan = new Scanner(System.in);
		int min = 1, max = 45;
		HashSet<Integer> lotto = new HashSet<Integer>();
		
		while(lotto.size() != 6) {
			int r = (int)(Math.random() * (max - min + 1) + min);
			lotto.add(r);
		}
		// 보너스 번호 생성
		int bonus;
		do {
			bonus = (int)(Math.random() * (max - min + 1) + min );
		}while(lotto.contains(bonus));
		
		System.out.println(lotto + " : " + bonus);
		
		// 사용자가 6개의 번호를 입력
		HashSet<Integer> user = new HashSet<Integer>();
		System.out.print("번호 입력(1~45사이 중복되지 않은 수 6개) : ");
		while(user.size() != 6) {
			user.add(scan.nextInt());
		}
		
		// 입력한 번호를 이용하여 당첨 등수를 출력
		
		for(Integer tmp : user) {
			if( lotto.contains(tmp)){
				count++;
			}
		}
		
		if(count == 6) {
			System.out.println("1등");
		}
		else if(count == 5) {
			if(user.contains(bonus)) {
				System.out.println("2등");
			}
			else {
				System.out.println("3등");
			}
		}
		else if(count == 4) {
			System.out.println("4등");
		}
		else if(count == 3) {
			System.out.println("5등");
		}
		else {
			System.out.println("꽝");
		}
	
	}
}
