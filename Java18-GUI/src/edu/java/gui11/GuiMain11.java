package edu.java.gui11;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;

public class GuiMain11 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain11 window = new GuiMain11();
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
	public GuiMain11() {
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
		
		JButton btn1 = new JButton("New Frame");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); // 기존 프레임을 사라지게하는
				MyFrame myFrame = new MyFrame();
				myFrame.setVisible(true); // setVisible() : 프레임을 화면에 보여주는 함수
				
			}
		});
		btn1.setBounds(12, 50, 287, 50);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("New Dialog");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 다이얼로그 호출
				MyDialog myDialog = new MyDialog();
			}
		});
		btn2.setBounds(12, 110, 287, 50);
		frame.getContentPane().add(btn2);
	}
}
