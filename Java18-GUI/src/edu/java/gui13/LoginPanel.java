package edu.java.gui13;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;

public class LoginPanel extends JPanel{
	public LoginPanel() {
		setBackground(Color.RED);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("로그인 되었습니다.");
		lblNewLabel.setBounds(94, 101, 269, 73);
		add(lblNewLabel);
		
	}
}
