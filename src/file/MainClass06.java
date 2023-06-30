package file;

import java.util.Scanner;

/*
 * 직렬화
 * - 객체를 특정 위치에 바이트형식으로 변환하여 저장하는 것
 * - implements Serializable 상속을 받으면 자동으로 직렬화 해줌
 * 역직렬화
 * - 특정 위치에 저자외어 있는 byte형식의 데이터를 자바의 객체로 변환
 */
public class MainClass06 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num;
		FIleService fs = new FIleService();
		while(true) {
			System.out.println("1.파일 저장"); 
			System.out.println("2.파일 확인");
			num = sc.nextInt();
			if(num == 1) {
				fs.writeMember();
			}else if(num == 2) {
				fs.readMember();
			}
		}
		 
			
		
		
		
	}
	
}