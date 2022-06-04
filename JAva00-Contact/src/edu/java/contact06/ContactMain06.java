package edu.java.contact06;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTable;

public class ContactMain06 {

	private JFrame frame;
	private JTextField txtName, txtPhone, txtEmail, txtIndex;
	private JTextArea txtAreaInfo, txtAreaLog;
	public static ContactDAO dao;

   /* 스윙 테이블을 사용하기 위한 멤버 변수 선언*/
   private JTable table;
   private String[] colNames = {"No", "이름", "전화번호", "이메일"}; // 테이블 헤더에 들어갈 이름들
   private Object[] records = new Object[colNames.length]; // 테이블 데이터를 저장할 배열 객체
   private DefaultTableModel tableModel; // 테이블 형태를 만들 모델 변수

	public static void main(String[] args) {
		dao = ContactDAOImple.getInstance(); // 싱글톤 객체 불러오기 (초기화할때 메인 맨처음)
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain06 window = new ContactMain06();
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
	public ContactMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 786, 662);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Font lblFont = new Font("굴림", Font.PLAIN, 44);
		int lblWidth = 176;
		int lblHeight = 55;
		JLabel lblNewLabel = new JLabel("연락처 프로그램 Version 6");
		lblNewLabel.setFont(lblFont);
		lblNewLabel.setBounds(12, 10, 746, 66);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblName = new JLabel("이름");
		lblName.setFont(lblFont);
		lblName.setBounds(12, 86, lblWidth, lblHeight);
		frame.getContentPane().add(lblName);

		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setFont(lblFont);
		lblPhone.setBounds(12, 151, lblWidth, lblHeight);
		frame.getContentPane().add(lblPhone);

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setFont(lblFont);
		lblEmail.setBounds(12, 216, lblWidth, lblHeight);
		frame.getContentPane().add(lblEmail);

		Font txtFont = new Font("굴림", Font.PLAIN, 34);
		int txtWidth = 286;
		int txtHeight = 55;
		txtName = new JTextField();
		txtName.setFont(txtFont);
		txtName.setBounds(200, 86, txtWidth, txtHeight);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtPhone = new JTextField();
		txtPhone.setFont(txtFont);
		txtPhone.setBounds(200, 151, txtWidth, txtHeight);
		frame.getContentPane().add(txtPhone);
		txtPhone.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(txtFont);
		txtEmail.setBounds(200, 216, txtWidth, txtHeight);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		Font btnFont = new Font("굴림", Font.PLAIN, 24);

		JButton btnInsert = new JButton("등록");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertContact();

			}
		});
		btnInsert.setFont(btnFont);
		btnInsert.setBounds(12, 281, 110, 46);
		frame.getContentPane().add(btnInsert);

		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectContact();
				

			}
		});

		btnSearch.setFont(btnFont);
		btnSearch.setBounds(256, 281, 110, 46);
		frame.getContentPane().add(btnSearch);

		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateContact();

			}
		});

		btnUpdate.setFont(btnFont);
		btnUpdate.setBounds(12, 337, 110, 46);
		frame.getContentPane().add(btnUpdate);

		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteContact();

			}
		});

		btnDelete.setFont(btnFont);
		btnDelete.setBounds(134, 337, 110, 46);
		frame.getContentPane().add(btnDelete);

		JButton btnAllSearch = new JButton("전체검색");
		btnAllSearch.addActionListener((e) -> {
			selectAllContact();
			selectAllContactTable();
			

		});
		btnAllSearch.setFont(btnFont);
		btnAllSearch.setBounds(256, 337, 190, 46);
		frame.getContentPane().add(btnAllSearch);

		txtIndex = new JTextField();
		txtIndex.setText("번호입력");
		txtIndex.setFont(new Font("굴림", Font.PLAIN, 17));
		txtIndex.setBounds(134, 281, 108, 46);
		frame.getContentPane().add(txtIndex);
		txtIndex.setColumns(5);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 393, 480, 95);
		frame.getContentPane().add(scrollPane);

		txtAreaInfo = new JTextArea();
		txtAreaInfo.setFont(new Font("굴림", Font.PLAIN, 16));
		scrollPane.setViewportView(txtAreaInfo);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 498, 480, 95);
		frame.getContentPane().add(scrollPane_1);

		txtAreaLog = new JTextArea();
		txtAreaLog.setFont(new Font("굴림", Font.PLAIN, 16));
		scrollPane_1.setViewportView(txtAreaLog);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(504, 281, 254, 312);
		frame.getContentPane().add(scrollPane_2);

      // 테이블 기본형태 초기화
      tableModel = new DefaultTableModel(colNames, 0); // 모델 이름과 행 개수 설정
      table = new JTable(tableModel); // 테이블 모델을 테이블에 적용
      table.setFont(new Font("굴림", Font.PLAIN, 15));
      scrollPane_2.setViewportView(table);
      
	} // end initialize()

	private void insertContact() { // 인서트로 vo로 저장
		String name = txtName.getText();
		String phone = txtPhone.getText();
		String email = txtEmail.getText();

		// name phone email 중 하나라도 입력되지 않으면
		// 모두 입력 하도록 출력
		if (name.equals("") || phone.equals("") || email.equals("")) {
			txtAreaLog.setText("등록 할 연락처 정보를 입력하세요.");
			JOptionPane.showMessageDialog(frame, "연락처 정보를 입력하세요");

			return; // 함수 종료
		}

		ContactVO vo = new ContactVO(0, name, phone, email);
		int result = dao.insert(vo);
		if (result == 1) { // 데이터 파악 리턴값 1
			txtAreaLog.setText("연락처 등록 성공");
			clearTextFields();

		} else {
			txtAreaInfo.setText("연락처 등록 실패");
		}

	} // end insertContact()

	private void selectContact() {
		try {
			int index = Integer.parseInt(txtIndex.getText());
			ContactVO vo = dao.select(index);
			txtAreaInfo.setText(vo.toString());

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "0이상의 정수를 입력하세요.");
			txtAreaLog.setText("0 이상의 정수를 입력하세요.");

		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(frame, "연락처 번호가 존재하지 않습니다.");

		}
		// TODO : 예외 처리

//		int size = ((ContactDAOImple) dao).getSize();
//		if(index >= 0 && index < size) {
//			ContactVO vo = dao.select(index);
//			txtAreaInfo.setText(vo.toString());
//			System.out.println("연락처 개수 : " + size);
//		} else {
//			txtAreaInfo.setText("해당 인덱스에 연락처가 없습니다.");
//		}

	} // end selectContact()

	private void updateContact() { // 수정
		String name = txtName.getText();
		String phone = txtPhone.getText();
		String email = txtEmail.getText();

		// name phone email 중 하나라도 입력되지 않으면
		// 모두 입력 하도록 출력
		if (name.equals("") || phone.equals("") || email.equals("")) {
			txtAreaLog.setText("등록 할 연락처 정보를 입력하세요.");
			JOptionPane.showMessageDialog(frame, "연락처 정보를 입력하세요");

			return; // 함수 종료
		}
		int index = Integer.parseInt(txtIndex.getText());
		ContactVO vo = new ContactVO(index, name, phone, email);
		int result = dao.update(index, vo);
		if(result ==1 ) {
			txtAreaLog.setText("연락처 수정 성공!");
		} else {
			txtAreaLog.setText(index + " 번 연락처가 존재하지 않습니다.");
		}
		
//
	} // end updateContact()

	private void deleteContact() {
		int index = Integer.parseInt(txtIndex.getText());

		int result = dao.delete(index);
		if (result == 1) {
			txtAreaLog.setText("연락처 삭제 성공!");
		} else {
			txtAreaLog.setText(index + "번 연락처가 없습니다.");
		}

} // end deleteContact()


	private void selectAllContact() {
		ArrayList<ContactVO> list = dao.select();
		txtAreaInfo.setText("");
		for (int i = 0; i < list.size(); i++) {
			txtAreaInfo.append("---" + i + " 번 연락처 --- \n");
			txtAreaInfo.append(list.get(i).toString() + "\n"); // for문 사용 append !!

		}

	} // end selectAllContact();
	private void selectAllContactTable() {
		ArrayList<ContactVO> list = dao.select();
		tableModel.setRowCount(0);
		
		for(int i = 0 ; i < list.size(); i++) {
			records[0] = i;
			records[1] = list.get(i).getName();
			records[2] = list.get(i).getPhone();
			records[3] = list.get(i).getEmail();
			tableModel.addRow(records);
		}
		
		
		
	} // selectAllContactTable()

	private void clearTextFields() {
		txtName.setText("");
		txtPhone.setText("");
		txtEmail.setText("");
		
	} // clearTextFields()
	
	
	

} // end ContactMain05
