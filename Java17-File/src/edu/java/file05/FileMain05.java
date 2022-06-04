package edu.java.file05;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/* 프로그램 ==> ObjectOutputStream ==> FileOutputStream ==> 파일(HDD)
  
   objectOutputstream에서 사용되는 객체는
   Serializable 인터페이스를 구현하고 있어야 함.
 */

public class FileMain05 {

	public static void main(String[] args) {
		OutputStream out = null;
		ObjectOutputStream oout= null; 
		
		try {
			out = new FileOutputStream("temp/member.txt");
			oout = new ObjectOutputStream(out);
			
			Member m1 = new Member(1, "root","root 1234");
			oout.writeObject(m1);
			
			Member m2 = new Member(2, "root2","root 1234");
			oout.writeObject(m2);
			
			Member m3 = new Member(3, "root3","root 1234");
			oout.writeObject(m3);
			
			System.out.println("파일 저장 성공!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			리소스(oout) resource 를 해제할 때는 최종적으로 생성된 리소스만 해제하면,
//			그 리소스(oout)가 사용하고 있던 다른 리소스(out)들도 순차적으로 해제됨
			try {
				oout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	} // end main*(

} // end FileMain05
