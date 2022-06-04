package edu.java.homework;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

import edu.java.file05.Member;

public class Homework {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      OutputStream out = null;
      ObjectOutputStream oout = null;
      
      try {
         out = new FileOutputStream("temp/student.txt");
         oout = new ObjectOutputStream(out);
         
         for(int i = 0; i < 3; i++) {
            System.out.println("정보 입력>");
            System.out.println("이름>");
            String name = sc.nextLine();
            System.out.println("수학>");
            int math = sc.nextInt();
            System.out.println("영어>");
            int eng = sc.nextInt();
            sc.nextLine();
            Student s1 = new Student(name, math, eng);
            oout.writeObject(s1);
         }
         
         System.out.println("파일 저장 성공");
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         try {
            oout.close();
            sc.close();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      
      InputStream in = null;
      ObjectInputStream oin = null;
      
      try {
         in = new FileInputStream("temp/student.txt");
         oin = new ObjectInputStream(in);
         
         while(true) {
            try {
               Student s = (Student) oin.readObject();
               System.out.println(s);
            } catch (EOFException e) {
               break;
            }
            
         }
      } catch (Exception e) {

      }
      
      
   } // end main()

} // end Homework







