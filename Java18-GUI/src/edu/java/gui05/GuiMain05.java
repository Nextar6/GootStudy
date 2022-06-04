package edu.java.gui05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiMain05 {

	private JFrame frame;
	
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain05 window = new GuiMain05();
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
	public GuiMain05() {
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
		
		JRadioButton rdbtnReject = new JRadioButton("거절");
		rdbtnReject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(rdbtnReject.getText());
				
			}
		});
		buttonGroup_1.add(rdbtnReject);
		rdbtnReject.setBounds(154, 6, 142, 31);
		frame.getContentPane().add(rdbtnReject);
		
		JTextArea textArea = new JTextArea();     // 지역변수 => 멤버변수로 *중요*
		textArea.setBounds(8, 43, 414, 208);
		frame.getContentPane().add(textArea);
		
		JRadioButton rdbtnAgree = new JRadioButton("동의");
		rdbtnAgree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(rdbtnAgree.getText());
			}
		});
		buttonGroup_1.add(rdbtnAgree);
		rdbtnAgree.setBounds(8, 6, 142, 31);
		frame.getContentPane().add(rdbtnAgree);
	}
}
