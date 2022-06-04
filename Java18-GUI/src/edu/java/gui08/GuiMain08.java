package edu.java.gui08;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuiMain08 {

	private JFrame frame;
	private static final ImageIcon[] IMAGE_ICONS = {
			new ImageIcon("res/dog1.jpg"),
			new ImageIcon("res/dog2.jpg"),
			new ImageIcon("res/dog3.jpg"),
			new ImageIcon("res/dog4.jpg"),
			new ImageIcon("res/dog5.jpg"),
			
	};
	private int index;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain08 window = new GuiMain08();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application. 메인의 생성자 (자기자신을 지속적으로 불러내기위함)
	 */
	public GuiMain08() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblImage = new JLabel();
		lblImage.setIcon(IMAGE_ICONS[0]);
		lblImage.setFont(new Font("굴림", Font.BOLD, 42));
		lblImage.setBounds(91, 54, 256, 256);
		frame.getContentPane().add(lblImage);
		
		JButton btnPrev = new JButton("이전");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index > 0) { // 현재 인덱스가 0 보다 크면
					index--;
				}else {
					index = IMAGE_ICONS.length - 1;
				}
				System.out.println(index);
				lblImage.setIcon(IMAGE_ICONS[index]);
			}
		});
		btnPrev.setFont(new Font("굴림", Font.BOLD, 48));
		btnPrev.setBounds(12, 382, 177, 86);
		frame.getContentPane().add(btnPrev);
		
		JButton btnNext = new JButton("다음");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index < IMAGE_ICONS.length - 1) {
					index++;
					
				}else { // index가 문자열의 길이 - 1 가되는 경우
					index = 0;
					
				}
				System.out.println(index);
				lblImage.setIcon(IMAGE_ICONS[index]);
			}
		});
		btnNext.setFont(new Font("굴림", Font.BOLD, 48));
		btnNext.setBounds(245, 382, 177, 86);
		frame.getContentPane().add(btnNext);
	}
}