package file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FIleService {
	private final String path = "C:\\최영준\\test\\member\\";
	public FIleService() {
		//		path = new File(null);
	}


	public void writeMember() {
		Scanner sc = new Scanner(System.in);
		String name , addr;
		int age;
		System.out.println("이름 입력");
		name = sc.next();
		System.out.println("주소 입력");
		addr = sc.next();
		System.out.println("나이 입력");
		age = sc.nextInt();

		FIleDTO dto = new FIleDTO();
		dto.setName(name);
		dto.setAddr(addr);
		dto.setAge(age);

		File filePath = new File(path + name + ".txt");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(filePath);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(dto);
			System.out.println("저장완료");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if( oos != null )
				try {
					oos.close();
					bos.close();
					fos.close();
				} catch (Exception e2) {

					e2.printStackTrace();
				}

		}

	}

	public void readMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.목록보기");
		System.out.println("2.특정 목록 보기");
		System.out.println("3.모든 사용자 보기");
		System.out.print(">>>>>>>>>>>>>>");
		int num = sc.nextInt();
		if(num == 1) {
			list();
		}else if(num == 2){
			System.out.println("파일명 입력");
			String msg = sc.next();
			memberView(msg + ".txt");
		}else {
			allMemberView();
		}


	}
	private void allMemberView() {
		String [] fileNames = list();

		//		for(String name : fileNames) {
		//			memberView(name);
		//		}
		ArrayList<FIleDTO> members = new ArrayList<>();
		for(String name : fileNames) {

			File file = new File(path+name);
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			ObjectInputStream ois = null;
			try {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				ois = new ObjectInputStream(bis);
				FIleDTO dto = (FIleDTO)ois.readObject();
				members.add(dto);
				ois.close();
				bis.close();
				fis.close();
				//				System.out.println("이름 : " +dto.getName());
				//				System.out.println("주소 : " +dto.getAddr());
				//				System.out.println("나이 : " +dto.getAge());
			} catch (Exception e) {
				System.out.println("해당 사용자는 존재하지 않습니다.");
			}

		}
		System.out.println("---------------------");
		System.out.println("이름\t주소\t나이");
		System.out.println("--------------------");
		for(FIleDTO d : members) {
			System.out.print(d.getName()+"\t");
			System.out.print(d.getAddr()+"\t");
			System.out.println(d.getAge()+"\t");
			System.out.println("======================");
		}
	}
	public void memberView(String msg) {
		//		Scanner sc = new Scanner(System.in);
		//		System.out.println("파일명 입력");
		//		String msg = sc.next();
		File file = new File(path+msg+".txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			FIleDTO dto = (FIleDTO)ois.readObject();
			ois.close();
			bis.close();
			fis.close();
			System.out.println("이름 : " +dto.getName());
			System.out.println("주소 : " +dto.getAddr());
			System.out.println("나이 : " +dto.getAge());
		} catch (Exception e) {
			System.out.println("해당 사용자는 존재하지 않습니다.");
		}


	}

	public String[] list() {
		File file = new File(path);
		String [] fileNames = file.list();
		for(String f : fileNames) {
			System.out.println(f);
			String [] s = f.split("\\.");
			System.out.println(s[0]);
		}
		return fileNames;
	}
}
