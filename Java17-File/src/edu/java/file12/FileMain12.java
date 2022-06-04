package edu.java.file12;

import java.io.File;

public class FileMain12 {
	public static final String TEST2 = "test2";
	public static final String TEST3 = "test3";
	public static final String DUMMY = "dummy.txt";
	

	public static void main(String[] args) {
		/* 파일, 디렉토리 이름 변경/삭제
		   test2 - > test3 디렉토리 이름변경
		 */
		
		File org = new File(TEST2);
		File dest = new File(TEST3);
		
		if(org.renameTo(dest)) {
			System.out.println("디렉토리 이름변경 성공");
		}else {
			System.out.println("디렉토리 이름변경 실패");
		}
		
		// test3\dummy.txt 파일 삭제
		String filePath = TEST3 + File.separator + DUMMY;
		File file= new File(filePath);
		
		if(file.delete()) {
			System.out.println("파일삭제 성공");
		}else {
			System.out.println("파일 삭제 실패");
		}

	} // end main()

} // end FileMain12
