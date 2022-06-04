package edu.java.gui11;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class MyFrame extends JFrame {

	private JPanel contentPane; // fram.getContetPane() 과 동일


	public MyFrame() {
//		 JFrame.EXIT_ON_CLOSE : 창 전체 닫기
//		 JFrame.DISPOSE_ON_CLOSE : 현재 창 닫기
//		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(157, 97, 97, 23);
		contentPane.add(btnNewButton);
	}

}
