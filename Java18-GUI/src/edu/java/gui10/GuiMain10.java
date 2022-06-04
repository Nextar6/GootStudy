package edu.java.gui10;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class GuiMain10 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain10 window = new GuiMain10();
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
	public GuiMain10() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewOpen = new JMenuItem("Open");
		mntmNewOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // JFileChooser : 파일을 선택 할 수 있는 팝업창
				JFileChooser chooser = new JFileChooser();
				int result = chooser.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					System.out.println("파일 선택");
					File selected = chooser.getSelectedFile();
					System.out.println(selected.getAbsolutePath());
					
				}else { // 취소
					System.out.println("취소");
				}
			}
		});
		
		mnFile.add(mntmNewOpen);
		
		JMenuItem mntmNewSave = new JMenuItem("Save");
		mnFile.add(mntmNewSave);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmNewExit = new JMenuItem("Exit");
		mntmNewExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ConfirmDialog : 
				// Yes (확인) - No(아니오) - Cancel(취소) 버튼을 갖는 다이얼로그
				int result = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?");
				// parentComponent : 부모 컴퍼넌트를 설정. 현재 컴퍼넌트의 보여줄 위치를 선정한다.
				System.out.println("선택결과 : " + result);
				if(result == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
					
					
				}else {
					System.out.println("취소");
				}
			}
		});
		mnFile.add(mntmNewExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmNewAbout = new JMenuItem("About");
		mntmNewAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 메세지와 OK 버튼만 있는 다이얼로그 : MessageDialog
				// 매개변수 parentComponent :
				// 	MessageDialog의 부모 컴퍼넌트를 설정
				// 설정이 되어있으면, 다이얼로그는 부모 창의가운데 보임
				// null로 되어있으면, 윈도우 화면 중앙
				JOptionPane.showMessageDialog(frame, "버전 1.0");
			}
		});
		mnHelp.add(mntmNewAbout);
	}

}
