package alon.java.testgui;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Lesson3 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lesson3 window = new Lesson3();
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
	public Lesson3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel startPage = new JPanel();
		startPage.setBounds(0, 0, 784, 551);
		frame.getContentPane().add(startPage);
		startPage.setLayout(null);
		
	
		
		JPanel lastPage = new JPanel();
		lastPage.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(lastPage);
		lastPage.setLayout(null);
		
		JButton btnLast = new JButton("GO TO LAST PAGE");
		btnLast.setFont(new Font("굴림", Font.BOLD, 32));
		btnLast.setBounds(337, 121, 297, 263);
		lastPage.add(btnLast);
		
		lastPage.setVisible(false);
		
		JButton btnNext = new JButton("GO TO NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lastPage.setVisible(true);
				startPage.setVisible(false);
				
			}
		});
		
		btnNext.setBounds(37, 153, 257, 248);
		startPage.add(btnNext);
		
		btnLast.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startPage.setVisible(true);
				lastPage.setVisible(false);
				
			}
		});
	}
}
