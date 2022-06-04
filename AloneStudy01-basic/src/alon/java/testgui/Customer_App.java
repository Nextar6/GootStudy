package alon.java.testgui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.security.Identity;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;

public class Customer_App {

	private JFrame frame;
	private JTextField txtEnterId;
	private JPasswordField passwordField;
	private JPanel mainPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_App window = new Customer_App();
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
	public Customer_App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(359,412);
		frame.getContentPane().setLayout(null);
		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:\\Users\\heema\\Desktop\\JAVA_CODES\\AloneStudy01-basic\\image\\bruno.jpg").getImage());
		welcomePanel.setBounds(0, 1, 343, 335);
		frame.getContentPane().add(welcomePanel);
		
		JLabel lblNewLabel = new JLabel("LogIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Rockwell Condensed", Font.PLAIN, 16));
		lblNewLabel.setBounds(217, 194, 118, 35);
		welcomePanel.add(lblNewLabel);
		
		txtEnterId = new JTextField();
		txtEnterId.setText("Enter ID");
		txtEnterId.setToolTipText("Enter ID");
		txtEnterId.setBounds(237, 239, 98, 25);
		welcomePanel.add(txtEnterId);
		txtEnterId.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter pw");
		passwordField.setBounds(237, 274, 98, 21);
		welcomePanel.add(passwordField);
		
		JButton btnLogIn = new JButton("LogIn");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(txtEnterId.getText());
				if(txtEnterId.getText().equals("Heeman") && Arrays.equals(passwordField.getPassword(),"1234".toCharArray())) {
					System.out.println("Hello Heeman");
					welcomePanel.setVisible(false); // 창 안보이게 !
					mainPanel.setVisible(true); // 메인페널이 보이게 !!
				} else {
					System.out.println("아이디와 비밀번호를 확인해주세요");
				}
				
				
			}
		});
		btnLogIn.setBounds(238, 303, 97, 23);
		welcomePanel.add(btnLogIn);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 1, 343, 335);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome !");
		lblNewLabel_1.setFont(new Font("돋움", Font.BOLD, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(114, 10, 116, 33);
		mainPanel.add(lblNewLabel_1);
		frame.setJMenuBar(menuBar());
		frame.setResizable(false);
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public JMenuBar menuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");
		
		bar.add(fileMenu);
		bar.add(aboutMenu);
		
		JMenuItem openFile = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(openFile);
		fileMenu.add(exit);
		fileMenu.addSeparator();
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		return bar;
	} // JMenuBar
}
class ImagePanel extends JPanel{
	private Image img;
	
	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);
	}
	public int getWidth() {
		return img.getWidth(null);
	}
	public int getHighth() {
		return img.getHeight(null);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
		
	}
}