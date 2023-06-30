package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainClass03 {

	public static void main(String[] args) throws Exception {
		
		File path = new File("C:\\최영준\\test\\test.txt");
		/*
		 * true : 파일이 없으면 새롭게 만들고, 기존에 파일이 있으면
		 * 기존파일의 내용 뒤에 이어써준다 append
		 */
		FileOutputStream fos = new FileOutputStream(path, true);
		fos.write("test".getBytes());
		fos.close();
		
		
		FileInputStream fis = new FileInputStream(path);
//		System.out.println(fis.read());
//		System.out.println((char)fis.read());
		while(true) {
			int res = fis.read();
			if(res < 0) {
				System.out.println("내용이 없습니다 : " + res);
				break;
			}
			System.out.println((char)res);
		}
		fis.close();
		
	}
}
