package edu.java.gui06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiMain06 {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain06 window = new GuiMain06();
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
	public GuiMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// 남자 여자 중에 선택된 라디오에 따라 확인 버튼을 눌렀을때
		// 남자인 경우 -> 확인버튼 클릭 - >textArea에 "성별 : 남자" 출력
		// 여자인 경우 -> 확인버튼 클릭 - >textArea에 "성별 : 여자" 출력
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton rdbtnFemale = new JRadioButton("여자");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBounds(133, 10, 121, 23);
		frame.getContentPane().add(rdbtnFemale);
		
		JRadioButton rdbtnMale = new JRadioButton("남자");
		rdbtnMale.setSelected(true);
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBounds(8, 10, 121, 23);
		frame.getContentPane().add(rdbtnMale);
		
		JButton btnCheck = new JButton("확인");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMale.isSelected()) {
				textArea.setText("성별 : " + rdbtnMale.getText());
				} else if (rdbtnFemale.isSelected()) {
				textArea.setText("성별 : " + rdbtnFemale.getText());
				}
			
			}
		});
		btnCheck.setBounds(8, 39, 97, 23);
		frame.getContentPane().add(btnCheck);
		
		textArea = new JTextArea();
		textArea.setBounds(8, 72, 414, 179);
		frame.getContentPane().add(textArea);
	}
	}
