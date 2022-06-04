package edu.java.file08;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import edu.java.file05.Member;

public class FileMain08 {

	public static void main(String[] args) {
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin  = null;
		
		try {
			in = new FileInputStream("temp/big_member.txt");
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			
			List<Member> list = new ArrayList<Member>();
			long startTime = System.currentTimeMillis();
			
			while(true) {
				try {
					Member m = (Member) oin.readObject();
					System.out.println(m);
					list.add(m);
					
				} catch(EOFException e ) {
					break;
					
				}
			}
			
			long endTime = System.currentTimeMillis();
			System.out.println("경과 시간 : " + (endTime - startTime));
			System.out.println("리스트 : " + list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				
		

	} // end main()

} // end FileMain08
