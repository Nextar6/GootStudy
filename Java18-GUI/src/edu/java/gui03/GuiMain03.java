package edu.java.gui03;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GuiMain03 {

	private JFrame frame;
	private JTextField txtName, txtPhone, txtEmail, txtOutput;
	private JButton btnInsert;
	private JTextArea textArea;

	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain03 window = new GuiMain03();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public GuiMain03() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 930, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); // absolute layout 설정
		
		int lblwitdh = 245; // 레이블 넓이
		int lblheight = 76; // 레이블 높이
		Font lblFont = new Font("굴림", Font.BOLD, 48);
		
		JLabel lblname = new JLabel("이름");
		lblname.setOpaque(true); // 배경색 설정을 위한 셋팅 : true
		lblname.setBackground(Color.PINK);
		lblname.setHorizontalAlignment(SwingConstants.CENTER);
		lblname.setFont(lblFont);
		lblname.setBounds(12, 24, lblwitdh, lblheight);
		frame.getContentPane().add(lblname);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setOpaque(true);
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("굴림", Font.BOLD, 48));
		lblPhone.setBackground(Color.ORANGE);
		lblPhone.setBounds(12, 110, lblwitdh, lblheight);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setOpaque(true);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("굴림", Font.BOLD, 48));
		lblEmail.setBackground(Color.CYAN);
		lblEmail.setBounds(12, 196, lblwitdh, lblheight);
		frame.getContentPane().add(lblEmail);
		
		int txtWitdh = 633; // 레이블 넓이
		int txtheight = 76; // 레이블 높이
		Font txtFont = new Font("굴림", Font.PLAIN, 30);
		
		txtName = new JTextField();
		txtName.setFont(txtFont);
		txtName.setBounds(269, 24, txtWitdh, txtheight);
		txtName.setColumns(10);
		frame.getContentPane().add(txtName);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("굴림", Font.PLAIN, 30));
		txtPhone.setColumns(10);
		txtPhone.setBounds(269, 110, txtWitdh, txtheight);
		frame.getContentPane().add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("굴림", Font.PLAIN, 30));
		txtEmail.setColumns(10);
		txtEmail.setBounds(269, 194, txtWitdh, txtheight);
		frame.getContentPane().add(txtEmail);
				
		btnInsert = new JButton("정보 출력");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 기능 구현
				String name = txtName.getText();
				String phone = txtPhone.getText();
				String email = txtEmail.getText();
				String msg = "이름 : " + name + "\n" + "전화번호 : " + phone + "\n" + "이메일 : " + email + "\n" + "반갑습니다";
				txtOutput.setText(msg);
				textArea.setText(msg);
				
			}
		});
		btnInsert.setBounds(12, 279, 890, 100);
		btnInsert.setFont(lblFont);
		btnInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		frame.getContentPane().add(btnInsert);
		
		txtOutput = new JTextField();
		txtOutput.setBounds(12, 389, 890, 100);
		txtOutput.setFont(txtFont);
		txtOutput.setColumns(0);
		frame.getContentPane().add(txtOutput);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(443, 575, 52, -47);
		frame.getContentPane().add(scrollPane);
		
		
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(txtFont);
		textArea.setEditable(false); // 편집불가
		scrollPane.setViewportView(textArea);
		
		
	}
} // end GuiMain03
