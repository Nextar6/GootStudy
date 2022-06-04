package edu.java.file03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileMain03 {

	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream("temp/big_text.txt");
			out = new FileOutputStream("temp/big_text2.txt");
			
			byte[] buffer = new byte[1024 * 1024]; // = 1MB;
			int byteCopied = 0;
			long startTime = System.currentTimeMillis();
//			시스템에 현재 시간을 milli-second 단위로 리턴
			
			while(true) {
				int result = in.read(buffer);
//				read(byte[] b) :
//				파일에서 읽은 데이터를 매개변수 배열 b에저장
//				실제로 읽은 바이트 수를 리턴, 파일 끝에서는 -1리턴
				if(result == -1) {
					break;
				}
				out.write(buffer, 0, result);
//				write(byte[] b) :
//				- 매개변수 배열b의 내용을 한번에 파일에 씀
//				write(byte[] b, int off, int len) :
//				- 배열 b의 인덱스 off번째부터 len 길이만큼 파일에씀
				byteCopied += result;
			}
			
			System.out.println("복사된 바이트 : " + byteCopied);
			long endTime = System.currentTimeMillis();
			System.out.println("복사 경과 시간 : " + (endTime - startTime));
			System.out.println("복사된 바이트 : " + byteCopied);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

		
	} // end main()

} // End fileMain03
