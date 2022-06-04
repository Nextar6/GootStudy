package edu.java.gui02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuiMain02 {

	private JFrame frame;
	private JTextField txtInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain02 window = new GuiMain02();
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
	public GuiMain02() {
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
		
		JLabel lblOutput = new JLabel("수요일입니다.");
		lblOutput.setForeground(Color.BLUE);
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblOutput.setBounds(35, 25, 357, 47);
		frame.getContentPane().add(lblOutput);
		
		txtInput = new JTextField();
		txtInput.setFont(new Font("돋움체", Font.PLAIN, 24));
		txtInput.setBounds(35, 82, 357, 47);
		frame.getContentPane().add(txtInput);
		txtInput.setColumns(10);
		
		JButton btninputButton = new JButton("입력");
		btninputButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 버튼을 클릭했을 때 해야할 기능 구현
				// JTextField에 입력된 내용을 읽어서 JLabel에 씀
				String msg = txtInput.getText();
				lblOutput.setText(msg);
			}
		});
		btninputButton.setFont(new Font("굴림", Font.PLAIN, 17));
		btninputButton.setBounds(35, 144, 357, 47);
		frame.getContentPane().add(btninputButton);
	}
}
