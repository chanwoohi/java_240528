package day10;

import java.util.Scanner;


public class VocabularyEx01 {
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		/* 메뉴
		 * 1. 단어 등록
		 * 2. 단어 수정
		 * 3. 단어 검색
		 * 4. 단어 삭제
		 * 5. 종료
		 * 메뉴 선택 :
		 * */
		//필요한 변수들
		
		int menu;
		final int WORD_MAX = 2;
		int wordCount = 0; //저장된 단어 갯수
		Word [] list = new Word[WORD_MAX]; // 단어 리스트
		Word tmp;
		// 반복 : 종료를 선택하지 않을 때 까지
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//선택한 메뉴에 따른 기능 실행
			switch(menu) {
			case 1 :
				wordCount = insertWord(list, wordCount);
				//단어 리스트가 다 찼으면 단어 리스트를 늘려줌
				if(wordCount == list.length) {
					list = expandWordList(list, list.length + 10);
				}
				insertWord(list, wordCount);
				for(int i = 0 ; i<wordCount; i++) {
					list[i].print();
				}
				
				break;
			case 2 :
				//단어 수정을 구현하기 위한 과정을 주석으로 작성. 같은 단어가 있는 경우
				//누구를 수정할지를 선택하는 부분을 고민해야함
				//같은 단어가 있는 경우를 찾아서, 해당 번지를 출력 !! i i+1 로 하면됨 정렬해놧음 !!
				indexOf(list, wordCount, std);
				
				// i + 1 번지에 새로운 단어 등록?
				
				// 알파벳순 배열 한 번 더
				break;
			case 3 :
				System.out.println("단어 검색 입니다.");
				break;
			case 4 :
				System.out.println("단어 삭제 입니다.");
				break;
			case 5 :
				System.out.println("프로그램을 종료합니다.");
				break;
			default :
				System.out.println("잘못된 메뉴 입니다.");
				break;
			}
		} while(menu != 5);
	}



	/* 메뉴를 출력하는 메소드
	 * */
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 단어 등록");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 검색");
		System.out.println("4. 단어 삭제");
		System.out.println("5. 종료");
		System.out.print("메뉴 선택 : ");
	}
	/* 단어장을 입력 하는 메소드 */
	public static Word inputWord (Scanner scan){
		System.out.print("단어 입력 : ");
		String word = scan.next();
		System.out.print("품사 입력 : ");
		String wordClass = scan.next();
		System.out.print("의미 입력 : ");
		scan.nextLine(); //공백 처리
		String meaning = scan.nextLine();
		Word tmp = new Word(word, wordClass, meaning);
		return tmp;
	}
	/**기능 : 단어 정보를 입력받아 단어 리스트에 추가하고 등록된 단어 숫자를 알려주는 메소드
	 * @param list 단어 리스트
	 * @param scan 단어 정보를 입력받기 위한 Scanner
	 * @param count 현재 단어 숫자
	 * @return 등록된 단어 숫자
	 * */
	public static int insertWord (Word [] list, Scanner scan, int wordCount) {
		if(wordCount == list.length) {
			System.out.println("다 찼습니다.");
			return wordCount;
		}
		System.out.println("단어 등록입니다.");
		//단어 리스트에 단어 객체를 저장
		//= 마지막으로 저장된 위치 다음에 단어 객체를 저장
		Word tmp = inputWord(scan);
		//저장된 단어 개수를 1 증가
		return wordCount + 1;	
	}


	public static int indexOf(Word[]list, int count, Word std) {
		if( list == null || std == null ) {
			return -1;
		}
		for( int i = 0 ; i < count ; i++ ) {
			if(std.getWord() != list[i].getWord()) {
				return i;
			}
		}
		return  -1;
	}
	/**기능 : 저장된 단어 리스트를 정렬하는 메소드 
	 * @param list 단어 리스트
	 * @param wordCount 저장된 단어 개수
	 * */
	public static void wordSort(int wordCount, Word [] list){
		//단어 리스트를 정렬(알파벳 순으로)
		for(int i = 0 ; i < wordCount - 1 ; i++) {
			for(int j = 0 ; j < wordCount -1 ; j++) {
				//j번지에 있는 단어가 사전순으로 j+1번지에 있는 단어 보다 뒤이면 두 단어 객체를 교환
				// j 번지에 있는 단어 : list[j].getWord() , j + 1 번지에 있는 단어 : list[j+1].getWord()
				if(list[j].getWord().compareTo(list[j+1].getWord()) > 0){
					Word tmpWord = list[j];
					list[j] = list[j+1];
					list[j+1] = tmpWord;
				}
			}
		}
	}
	/**기능 : 단어 리스트에 단어를 입력받아 단어를 추가하고 등록된 단어 숫자를 알려주는 메소드
	 * @param list 단어 리스트
	 * @param wordCount 저장된 단어 개수
	 * @return 저장된 단어 개수
	 * */
	public static int insertWord(Word[] list, int wordCount) {
		System.out.println("단어 등록입니다.");
		//단어 리스트에 단어 객체를 저장 => 마지막으로 저장된 위치 다음에 단어 객체를 저장
		Word tmp = inputWord(scan);
		list[wordCount] = tmp;
		//저장된 단어 개수를 1 증가
		wordCount++;
		//단어 리스트를 정렬(알파벳 순으로)
		wordSort(wordCount, list);
		System.out.println("--------------------");
		System.out.println("단어 등록을 완료했습니다.");
		System.out.println("--------------------");
		return wordCount;
	}
	/**기능 : 단어 리스트를 늘려서 돌려주는 메소드
	 * @param list 단어 리스트
	 * @param size 늘려줄 크기
	 * @return 늘어난 단어 리스트
	 * */
	public static Word[] expandWordList(Word[] list, int size) {
		if(list.length >= size) {
			return list;
		}
		Word [] tmp = new Word[size];
		//list 0번지 부터 list.length를 tmp의 0번지부터 복붙
		System.arraycopy(list, 0, tmp, 0, list.length);
		return tmp;
	}
}
/**영어 단어를 관리하기 위한 Word 클래스를 만들고,
 * 필요한 멤버변수들을 선언 해 보세요.
 * */
class Word {
	//단어, 뜻, 품사
	private String word, meaning, wordClass;

	//생성자
	public Word(String word, String wordClass, String meaning) {
		this.word = word;
		this.wordClass = wordClass;
		this.meaning = meaning;
	}

	//필요한 기능
	/**기능 : 단어를 출력하는 메소드
	 * */
	public void print() {
		System.out.println("--------------------");
		System.out.println("단어 : " + word );
		System.out.println("품사 : " + wordClass );
		System.out.println("의미 : " + meaning );
		System.out.println("--------------------");
	}

	//getter와 setter
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getWordClass() {
		return wordClass;
	}

	public void setWordClass(String wordClass) {
		this.wordClass = wordClass;
	}
}
