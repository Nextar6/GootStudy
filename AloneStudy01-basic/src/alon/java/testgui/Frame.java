package alon.java.testgui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame {
	public static void main(String[] args) {
		JFrame frame= new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Some txext"); // 표시만 가능
		JButton btn1 = new JButton("Click Me !!");
		JButton btn2 = new JButton("Exit!!");
		JTextArea txtArea = new JTextArea();
		JTextField txtField = new JTextField(200); // 한줄정도 제한값필요
		JPanel btnPanel = new JPanel();
		panel.setLayout(new BorderLayout()); // 원하는 위치에
		
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		panel.add(label, BorderLayout.NORTH);
		panel.add(btnPanel, BorderLayout.WEST);
		panel.add(txtArea, BorderLayout.CENTER); // 넓은 범위 텍스트 
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(txtArea.getText()); // 라벨을 txtArea의 글씨로변경!
			}
		});
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		frame.add(panel);
		
		
		frame.setResizable(false); // 프로그램사이즈 움직이지 않게 고정 !!
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(840, 840/12*9));
		frame.setSize(840, 840/12*9);
		frame.setLocationRelativeTo(null); // 가운데
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창끄면 중지
		// 프레임 전체틀 패널 껏다켯다 편리하게 구성
		
		
		
	} // end main

} // end Frame
