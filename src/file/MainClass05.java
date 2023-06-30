package file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringBufferInputStream;

public class MainClass05 {

	public static void main(String[] args) throws Exception {
		
		File path = new File("C:\\최영준\\test\\test.txt");
		FileOutputStream fos = new FileOutputStream(path);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		
		dos.writeUTF("안녕하세요.");
		dos.writeInt(12345);
		dos.writeDouble(1.12345);
		
		dos.close();
		bos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream(path);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);
		
		String msg = dis.readUTF();
		int num = dis.readInt();
		double dou = dis.readDouble();
		System.out.println("msg: " + msg);
		System.out.println("num: " + num);
		System.out.println("dou: " + dou);
		
		dis.close();
		bis.close();
		fis.close();
		
		
		
		
		
	}
}
