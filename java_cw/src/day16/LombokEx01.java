package day16;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class LombokEx01 {

	public static void main(String[] args) {
		
		Test t = new Test();
		t.setName("홍길동");
		t.setNumber("1");
		System.out.println(t);
		
		Test t2 = new Test("홍길동", "1");
		
		
		System.out.println(t.equals(t2));
		
		Test t3 = new Test("3");
		System.out.println(t3);
	}

}
/* @Data : @EqualsAndHashCode + @Getter + @Setter + @ToString 을 합친 기능
 * @EqualsAndHashCode : equals() 와 hashCode() 메소드를 오버라이딩. 모든 멤버변수를 가지고 비교 
 * @Getter , @Setter :  모든 멤버 변수에 대해서 getter 와  setter 를 만들어줌
 * @ToString : toString 을 오버라이딩 해줌
 * @RequiredArgsConstructor : 반드시 필요한 멤버 변수들을 매개 변수로 갖는 생성자. 
 * 							  @NonNull 이 붙은 멤버들만을 이용한 생성자 
 * */

@Data
@AllArgsConstructor  // 모든 멤버변수를 필요로 하는 생성자를 추가
@NoArgsConstructor // 기본 생성자
@RequiredArgsConstructor
class Test{
	private String name;
	@NonNull
	private String number;
	@Override
	public String toString() {
		return "이름 : " + name + " : 번호 : " + number ;
	}
	
	
}