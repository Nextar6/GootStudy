package edu.java.file07;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import edu.java.file05.Member;

public class FileMain07 {

	public static void main(String[] args) {
		OutputStream out = null;
		BufferedOutputStream bout =null;
		ObjectOutputStream oout = null;
		
		try {
			out = new FileOutputStream("temp/big_member.txt");
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			
			long startTime = System.currentTimeMillis();
			
			String id = null;
			String pw = null;
			
			for(int i = 0 ; i < 1000; i++) {
				id = "member" +i;
				pw = "pw" + i;
				Member m = new Member(i, id, pw);
				
				System.out.println(m);
				oout.writeObject(m);
			}
			long endTime = System.currentTimeMillis();
			System.out.println("경과 시간 : " + (endTime - startTime));
			System.out.println("파일 저장 성공");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}
