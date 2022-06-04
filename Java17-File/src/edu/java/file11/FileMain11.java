package edu.java.file11;
//*중요*

import java.io.File;
import java.io.IOException;

public class FileMain11 {
	// 자바에서 상대경로 : 프로젝트(Jave17-File)의 하위 경로
	
	public static final String DIR_NAME = "test2";
	public static final String FILE_NAME = "dummy.txt";
	public static final String FILE_PATH =
			DIR_NAME + File.separator + FILE_NAME;
	
	// C:\Users\goott3\eclipse-workspace\Java17-File\test2\dummy.txt
	// => (현재프로젝트 위치) \test2\dummy.txt
	public static void main(String[] args) {
		System.out.println(FILE_PATH);
		File f = new File(FILE_PATH);
		
		if (!f.exists()) { 
			System.out.println("파일dl 없습니다");
//		creatNewFile() : 새로운 빈 파일을 생성
			try {
				if(f.createNewFile()) {
					System.out.println("파일 생성 성공");
					
				}else {
					System.out.println("파일 생성 실패");
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("폴더가 이미 존재 합니다.");
		}
	} // end main()

} // end FileMain
