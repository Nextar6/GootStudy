package edu.java.gui01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class GuiMain01 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain01 window = new GuiMain01();
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
	public GuiMain01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel north = new JLabel("North");
		frame.getContentPane().add(north, BorderLayout.NORTH);
		
		JLabel west = new JLabel("West");
		frame.getContentPane().add(west, BorderLayout.WEST);
		
		JLabel east = new JLabel("East");
		frame.getContentPane().add(east, BorderLayout.EAST);
		
		JLabel center = new JLabel("Center");
		frame.getContentPane().add(center, BorderLayout.CENTER);
		
		JLabel south = new JLabel("South");
		frame.getContentPane().add(south, BorderLayout.SOUTH);
	}

}
