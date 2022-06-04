package edu.java.gui12;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class MyFrame extends JFrame {

	private JPanel contentPane; // fram.getContetPane() 과 동일
	


	public MyFrame(String str) {
//		 JFrame.EXIT_ON_CLOSE : 창 전체 닫기
//		 JFrame.DISPOSE_ON_CLOSE : 현재 창 닫기
			
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton(str);
		btnNewButton.setBounds(101, 78, 193, 85);
		contentPane.add(btnNewButton);
		
	}

}
