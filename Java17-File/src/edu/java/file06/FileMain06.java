package edu.java.file06;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

import edu.java.file05.Member;

public class FileMain06 {

	public static void main(String[] args) {
		InputStream in = null;
		ObjectInputStream oin =null;
		
		try {
			in = new FileInputStream("temp/member.txt");
			oin = new ObjectInputStream(in);
			while(true) {
				
				try {
					Member m = (Member) oin.readObject();
					System.out.println(m);
					
				} catch(EOFException e) {
					break;
					
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
	} // end main()

} // end FileMain06
