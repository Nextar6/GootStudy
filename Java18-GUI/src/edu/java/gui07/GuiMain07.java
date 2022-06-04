package edu.java.gui07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiMain07 {

	private JFrame frame;
	private static final String[] STRINGS = {
			"1. 유재석",
			"2. 조세호",
			"3. 박명수",
			"4. 김종국",
			"5. 아이유",
			
	};
	private int index;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain07 window = new GuiMain07();
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
	public GuiMain07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOutput = new JLabel("New label");
		lblOutput.setText(STRINGS[0]);
		lblOutput.setFont(new Font("굴림", Font.BOLD, 42));
		lblOutput.setBounds(12, 10, 410, 106);
		frame.getContentPane().add(lblOutput);
		
		JButton btnPrev = new JButton("이전");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index > 0) { // 현재 인덱스가 0 보다 크면
					index--;
				}else {
					index = STRINGS.length - 1;
				}
				System.out.println(index);
				lblOutput.setText(STRINGS[index]);
			}
		});
		btnPrev.setFont(new Font("굴림", Font.BOLD, 48));
		btnPrev.setBounds(12, 143, 177, 86);
		frame.getContentPane().add(btnPrev);
		
		JButton btnNext = new JButton("다음");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index < STRINGS.length - 1) {
					index++;
					
				}else { // index가 문자열의 길이 - 1 가되는 경우
					index = 0;
					
				}
				System.out.println(index);
				lblOutput.setText(STRINGS[index]);
			}
		});
		btnNext.setFont(new Font("굴림", Font.BOLD, 48));
		btnNext.setBounds(245, 143, 177, 86);
		frame.getContentPane().add(btnNext);
	}
}
