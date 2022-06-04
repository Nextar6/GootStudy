package edu.java.contact05;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;


public class ContactMain05 {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtIndex;
	private JTable table;
	private JTextArea txtAreaLog;
	private JTextArea txtAreaInfo;

	
	public static ContactDAO dao;
	public static ContactVO vo;
	

	private String[] colNames = { "No", "이름", "전화번호" };
	private Object[] records = new Object[colNames.length];
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		dao = ContactDAOImple.getInstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain05 window = new ContactMain05();
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
	public ContactMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 458, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("연락처 프로그램 Version 0.5");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setBounds(12, 10, 418, 78);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewName = new JLabel("이름");
		lblNewName.setFont(new Font("굴림", Font.PLAIN, 17));
		lblNewName.setBounds(12, 83, 140, 40);
		frame.getContentPane().add(lblNewName);

		JLabel lblNewPhone = new JLabel("전화번호");
		lblNewPhone.setFont(new Font("굴림", Font.PLAIN, 17));
		lblNewPhone.setBounds(12, 132, 140, 40);
		frame.getContentPane().add(lblNewPhone);

		JLabel lblNewEmail = new JLabel("이메일");
		lblNewEmail.setFont(new Font("굴림", Font.PLAIN, 17));
		lblNewEmail.setBounds(12, 182, 140, 40);
		frame.getContentPane().add(lblNewEmail);

		txtName = new JTextField();
		txtName.setBounds(183, 85, 179, 40);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(183, 132, 179, 40);
		frame.getContentPane().add(txtPhone);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(183, 182, 179, 40);
		frame.getContentPane().add(txtEmail);

		JButton btnInsert = new JButton("등록");
		btnInsert.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				insertContact();

				

			} // end insertContact()

		});
		btnInsert.setBounds(12, 234, 79, 46);
		frame.getContentPane().add(btnInsert);

		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteContact();
			
				
			
				
			}
		});
		btnDelete.setBounds(193, 232, 79, 46);
		frame.getContentPane().add(btnDelete);

		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateContact();


			}
		
			
		});
		btnUpdate.setBounds(103, 234, 79, 46);
		frame.getContentPane().add(btnUpdate);

		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			findContact();	
				
			}
		});
		btnSearch.setBounds(77, 288, 79, 46);
		frame.getContentPane().add(btnSearch);

		JButton btnAllsearch = new JButton("전체검색");
		btnAllsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAllContact();
			
				
			}
			
		});
		btnAllsearch.setBounds(168, 288, 104, 46);
		frame.getContentPane().add(btnAllsearch);

		txtIndex = new JTextField();
		txtIndex.setText("번호입력");
		txtIndex.setBounds(12, 290, 53, 40);
		frame.getContentPane().add(txtIndex);
		txtIndex.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(284, 232, 146, 239);
		scrollPane.setViewportView(table);
		frame.getContentPane().add(scrollPane);

		// ㅅㄱ 스크롤판;;

		tableModel = new DefaultTableModel(colNames, 0);
		table = new JTable(tableModel);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setBounds(12, 10, 410, 241);
		frame.getContentPane().add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 340, 257, 61);
		frame.getContentPane().add(scrollPane_1);
		
		txtAreaInfo = new JTextArea();
		scrollPane_1.setViewportView(txtAreaInfo);

//		txtAreaInfo = new TextArea();
//		txtAreaInfo.setColumns(40);
//		scrollPane_1.setViewportView(txtAreaInfo);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(12, 410, 257, 61);
		frame.getContentPane().add(scrollPane_1_1);
		
		txtAreaLog = new JTextArea();
		scrollPane_1_1.setViewportView(txtAreaLog);

//		txtAreaLog = new TextArea();
//		txtAreaLog.setColumns(50);
//		scrollPane_1_1.setViewportView(txtAreaLog);

	} // end main()
	
	public void insertContact() {
	ContactVO vo = new ContactVO(txtName.getText(), txtPhone.getText(), txtEmail.getText());

	int result = dao.insert(vo);
	if (result == 1) {
		txtAreaLog.setText("등록 되었습니다.");
		
	} 
	
	} // end insertContact
	public void findContact() {

		int index = Integer.parseInt(txtIndex.getText());
		
		int size = ((ContactDAOImple) dao).getSize();
		if(index >= 0 && index < size) {
			ContactVO vo = dao.select(index);
			txtAreaInfo.setText(vo.toString());
			System.out.println("연락처 개수 : " + size);
		} else {
			txtAreaLog.setText("해당 인덱스에 연락처가 없습니다.");
		
	} 
	
	}// end findContact()
	
	public void deleteContact() {
		int index = Integer.parseInt(txtIndex.getText());
		int size = ((ContactDAOImple) dao).getSize();
		
		if(index >= 0 && index < size) {
			int result = dao.delete(index);
			if(result == 1) {
			txtAreaLog.setText("삭제 되었습니다.");
			}
		} else {
			txtAreaLog.setText("해당 인덱스에 연락처가 없습니다.");
		} 
	} //end deleteContact()
	
	public void updateContact() {
		int index = Integer.parseInt(txtIndex.getText());
		int size = ((ContactDAOImple) dao).getSize();
		if (index >= 0 && index < size) {

			ContactVO vo = new ContactVO(txtName.getText(), txtPhone.getText(), txtEmail.getText());
			int result = dao.update(index, vo);
			if (result == 1) {
				txtAreaLog.setText("연락처가 수정되었습니다");
			}

		} else {
			txtAreaLog.setText("연락처 인덱스가 올바르지 않습니다");
		}
	} // end updateContact()

	public void selectAllContact() {
		txtAreaInfo.setText("");
		ArrayList<ContactVO> contactList = dao.select();
		int size = ((ContactDAOImple) dao).getSize();
		System.out.println("연락처 개수 : " + size);
		for (int i = 0; i < size; i++) {
			txtAreaInfo.append(contactList.get(i).toString()+"\n");
		}
	} // end selectAllContact()
	
} // End ContactMain05
