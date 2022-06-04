package edu.java.gui09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiMain09 {

	private JFrame frame;
	private JTextArea textArea;
	private JButton btnOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain09 window = new GuiMain09();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiMain09() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 533, 366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCheckBox chMusic = new JCheckBox("음악");
		chMusic.setBounds(8, 6, 115, 23);
		frame.getContentPane().add(chMusic);
		
		JCheckBox chMovie = new JCheckBox("영화");
		chMovie.setBounds(127, 6, 115, 23);
		frame.getContentPane().add(chMovie);
		
		JCheckBox chReading = new JCheckBox("독서");
		chReading.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if(chReading.isSelected()) {// 체크박스를 선택하면
					btnOutput.setEnabled(false); // 기능 못쓰게하는 인에이블
					
				}else { // 체크박스를 해제하면
					btnOutput.setEnabled(true);
					
				}
			}
		});
		chReading.setBounds(246, 6, 115, 23);
		frame.getContentPane().add(chReading);
		
		btnOutput = new JButton("출력");
		btnOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = "음악 : " + chMusic.isSelected() + "\n" + "영화 : " 
			+chMovie.isSelected() + "\n" + "독서 : " + chReading.isSelected();
				textArea.setText(result);
				
			}
		});
		btnOutput.setBounds(408, 25, 97, 23);
		frame.getContentPane().add(btnOutput);
		
		textArea = new JTextArea();
		textArea.setBounds(8, 58, 497, 259);
		frame.getContentPane().add(textArea);
	}
}
