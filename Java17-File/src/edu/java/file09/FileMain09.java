package edu.java.file09;

// *중요*

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import edu.java.file05.Member;

public class FileMain09 {

   public static void main(String[] args) {
      // ** ArrayList<Member> 객체를 파일에 저장하고 읽어오는 코드
      System.out.println("ArrayList<Member> 데이터를 저장하고 읽어오는 코드");
      
      /* 데이터를 ArrayList에 저장하는 코드 */
      OutputStream out = null;
      BufferedOutputStream bout = null;
      ObjectOutputStream oout = null;
      
      try {
         out = new FileOutputStream("temp/list.txt");
         bout = new BufferedOutputStream(out);
         oout = new ObjectOutputStream(bout);
         
         ArrayList<Member> list = new ArrayList<Member>();
         for(int i = 0; i < 100; i++) {
            String id = "member" + i;
            String pw = "pw" + i;
            Member m = new Member(i, id, pw);
            list.add(m);
         }
         
         oout.writeObject(list);
         
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         try {
            oout.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
      
      /* 데이터 파일을 읽어서 ArrayList의 내용을 출력 */
      InputStream in = null;
      BufferedInputStream bin = null;
      ObjectInputStream oin = null;
      
      try {
		in = new FileInputStream("temp/list.txt");
		bin = new BufferedInputStream(in);
		oin = new ObjectInputStream(bin);
		
		ArrayList<Member> list = (ArrayList<Member>) oin.readObject();
		
		for(Member m : list) {
			System.out.println(m);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			oin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
      
   } // end main()

} // FileMain09



