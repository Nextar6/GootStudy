package edu.java.gui12;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiMain12 {

	private JFrame frame;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain12 window = new GuiMain12();
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
	public GuiMain12() {
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
		
		textField = new JTextField();
		textField.setBounds(159, 21, 116, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btn1 = new JButton("New Frame");
		
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// textField에 입력된 데이터를 myFrame - btnNewButton의 txt에 적용 
				// 프레임 호출
				String str = textField.getText(); // 보냄
				MyFrame myFrame = new MyFrame(str);
				myFrame.setVisible(true);
			
				
				
				
			}
		});
		btn1.setBounds(12, 61, 410, 51);
		frame.getContentPane().add(btn1);
	}
}
