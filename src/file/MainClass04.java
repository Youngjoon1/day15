package file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainClass04 {

	public static void main(String[] args) throws Exception {
		
		File path = new File("C:\\최영준\\test\\test.txt");
		FileOutputStream fos = new FileOutputStream(path);
		
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		//임시저장소
		for(char ch = '0'; ch <= '9'; ch++) {
			Thread.sleep(50);
//			fos.write(ch);
			bos.write(ch);
		}
		bos.flush();
		//임시 저장소에서 전송
		bos.write('A');
		bos.flush();
		bos.write('B');
		bos.close();
		
	}
	
}
