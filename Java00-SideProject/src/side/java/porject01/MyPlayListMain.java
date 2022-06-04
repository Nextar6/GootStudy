package side.java.porject01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;



import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class MyPlayListMain {

	private JFrame frame;
	private JPanel mainPanel;
	private JPanel loginPanel;
	private JTextField txtTitle;
	private JTextField txtArtist;
	private JTextField txtJanre;
	private JTextField txtYear;
	private JTextField txtIndex;
	private JTextField txtLog;
	public static MusicDAO dao;

	private JTable table;
	private String[] colNames = { "cid", "곡명", "가수", "장르", "발매연도" };
	private Object[] records = new Object[colNames.length];
	private DefaultTableModel tableModel;
	private JTextField txtID;
	private JPasswordField txtPW;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		dao = MyPlayListDAOImple.getInstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPlayListMain window = new MyPlayListMain();
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
	public MyPlayListMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		// 이미지 사이즈 변경

		frame.setBounds(100, 100, 677, 641);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 661, 602);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);

		JScrollPane scrollPane = new JScrollPane(); // 스크롤 테이블 여기
		scrollPane.setBounds(12, 254, 637, 338);
		mainPanel.add(scrollPane);
		tableModel = new DefaultTableModel(colNames, 0);
		table = new JTable(tableModel);
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		scrollPane.setViewportView(table); // 스크롤 테이블 여기

		JLabel lblHello = new JLabel("\"heeman님 반갑습니다.\"");
		lblHello.setForeground(Color.PINK);
		lblHello.setBounds(12, 12, 187, 19);
		mainPanel.add(lblHello);

		JButton btnLogout = new JButton("로그아웃");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?");
				mainPanel.setVisible(false);
				loginPanel.setVisible(true);
				txtID.setText("");
				txtPW.setText("");

			}
		});
		btnLogout.setBounds(513, 10, 136, 23);
		mainPanel.add(btnLogout);

		JLabel lblYear = new JLabel("발매연도");
		lblYear.setBounds(420, 110, 121, 15);
		mainPanel.add(lblYear);
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblTitle = new JLabel("곡명");
		lblTitle.setBounds(12, 110, 116, 15);
		mainPanel.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblArtist = new JLabel("가수");
		lblArtist.setBounds(146, 110, 116, 15);
		mainPanel.add(lblArtist);
		lblArtist.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblJanre = new JLabel("장르");
		lblJanre.setBounds(284, 110, 116, 15);
		mainPanel.add(lblJanre);
		lblJanre.setHorizontalAlignment(SwingConstants.CENTER);

		txtTitle = new JTextField();
		txtTitle.setBounds(12, 135, 116, 23);
		mainPanel.add(txtTitle);
		txtTitle.setColumns(10);

		txtArtist = new JTextField();
		txtArtist.setBounds(156, 135, 116, 23);
		mainPanel.add(txtArtist);
		txtArtist.setColumns(10);

		txtJanre = new JTextField();
		txtJanre.setBounds(294, 135, 116, 24);
		mainPanel.add(txtJanre);
		txtJanre.setColumns(10);

		txtYear = new JTextField();
		txtYear.setBounds(425, 135, 116, 23);
		mainPanel.add(txtYear);
		txtYear.setColumns(10);

		txtIndex = new JTextField();
		txtIndex.setBounds(70, 177, 44, 21);
		mainPanel.add(txtIndex);
		txtIndex.setColumns(10);

		JLabel lblIndex = new JLabel("번호");
		lblIndex.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndex.setBounds(12, 177, 44, 21);
		mainPanel.add(lblIndex);

		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBounds(227, 174, 91, 26);
		mainPanel.add(btnUpdate);

		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(319, 174, 91, 26);
		mainPanel.add(btnDelete);

		JButton btnInsert = new JButton("추가");
		btnInsert.setBounds(553, 134, 96, 26);
		mainPanel.add(btnInsert);

		txtLog = new JTextField();
		txtLog.setBounds(12, 212, 402, 32);
		mainPanel.add(txtLog);
		txtLog.setColumns(10);

		JButton btnAllList = new JButton("전체리스트");
		btnAllList.setBounds(425, 211, 116, 32);
		mainPanel.add(btnAllList);

		JButton btnRandom = new JButton("랜덤선곡");
		btnRandom.setBounds(553, 171, 96, 75);
		mainPanel.add(btnRandom);

		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(135, 174, 91, 26);
		mainPanel.add(btnSearch);

		JButton btnKategorie = new JButton("카테고리검색");
		btnKategorie.setBounds(425, 171, 116, 32);
		mainPanel.add(btnKategorie);

		JLabel lblNewLabel = new JLabel("MY PLAY LIST");
		lblNewLabel.setBounds(199, 36, 218, 59);
		mainPanel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 28));

		btnKategorie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!txtJanre.getText().equals("") && txtArtist.getText().equals("") && txtYear.getText().equals("")
						&& txtTitle.getText().equals("")) {
					// 장르가 빈칸이 아니고 나머지가 빈칸일때 - > 카테고리 J 실행
					selectKategorieJ();
				} else if (txtJanre.getText().equals("") && !txtArtist.getText().equals("")
						&& txtYear.getText().equals("") && txtTitle.getText().equals("")) {
					// 아티스트가 빈칸이아니고 나머지가 빈칸
					selectKategorieA();
				} else if (txtJanre.getText().equals("") && txtArtist.getText().equals("")
						&& !txtYear.getText().equals("") && txtTitle.getText().equals("")) {
					selectKategorieY();
				} else {
					txtLog.setText("정확한 카테고리와 다른카테고리가 빈칸인지 체크 해주세요.");
				}

			}

		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectMusic();
			}
		});
		btnRandom.addActionListener(new ActionListener() { // 랜덤선곡
			public void actionPerformed(ActionEvent e) {
				selectRandomIndex();
			}
				
		});
		btnAllList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllListTable();
			}
		});
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertMusic();
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteMusic();
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMusic();
			}
		});
//		frame.getContentPane().add(loginPanel);
//		loginPanel.setLayout(null);

		loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 661, 602);
		frame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("MY PLAY LIST");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Algerian", Font.PLAIN, 34));
		lblNewLabel_1.setBounds(27, 26, 358, 124);
		loginPanel.add(lblNewLabel_1);

		JButton btnlogInButton = new JButton("로그인");
		btnlogInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtID.getText().equals("heeman") && Arrays.equals(txtPW.getPassword(), "1234".toCharArray())) {
					System.out.println("Hello");
					loginPanel.setVisible(false);
					mainPanel.setVisible(true);

					// 로그인이 성공하면 로그인패널이 사라지고 메인패널이 나타나는

				} else {
					System.out.println("wrong id or pw");
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀렸습니다.");
					// 메세지박스 사용
				}

			}
		});
		btnlogInButton.setBounds(447, 490, 163, 37);
		loginPanel.add(btnlogInButton);

		txtID = new JTextField();
		txtID.setBounds(447, 396, 163, 37);
		loginPanel.add(txtID);
		txtID.setColumns(10);

		txtPW = new JPasswordField();
		txtPW.setBounds(447, 443, 163, 37);
		loginPanel.add(txtPW);

		JLabel lblLabelID = new JLabel("ID");
		lblLabelID.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabelID.setBounds(344, 396, 72, 37);
		loginPanel.add(lblLabelID);

		JLabel lblLabelPW = new JLabel("PassWord");
		lblLabelPW.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabelPW.setBounds(344, 443, 72, 37);
		loginPanel.add(lblLabelPW);

	} // end main()

	private void insertMusic() {
		String title = txtTitle.getText();
		String artist = txtArtist.getText();
		String janre = txtJanre.getText();
		String year = txtYear.getText();
		if (title.equals("") || artist.equals("") || janre.equals("") || year.equals("")) {
			txtLog.setText("정확한 곡 정보와 빈칸을 확인해주세요.");
			return; // 종료
		}
		MusicVO vo = new MusicVO(0, title, artist, janre, year);
		int result = dao.insert(vo);
		if (result == 1) {
			txtLog.setText("등록 성공");
		} else {
			txtLog.setText("등록 실패");
		} // 2.21 저녁 할일 : 등록 부분 입력 데이타 베이스 연동 부터

	} // end insertMusic()

	private void selectMusic() {
		try {
			int index = Integer.parseInt(txtIndex.getText());
			MusicVO vo = dao.select(index);
			txtLog.setText(vo.toString());
		} catch (NumberFormatException e) {
			txtLog.setText("0이상의 정수를 입력하세요");
		} catch (IndexOutOfBoundsException e) {
			txtLog.setText("정보가 존재하지 않습니다");
		}

	} // end selectMusic

	private void AllListTable() {
		ArrayList<MusicVO> list = dao.select();
		tableModel.setRowCount(0);

		for (int i = 0; i < list.size(); i++) {

			records[0] = list.get(i).getCid();
			records[1] = list.get(i).getTitle();
			records[2] = list.get(i).getArtist();
			records[3] = list.get(i).getJanre();
			records[4] = list.get(i).getYear();
			tableModel.addRow(records);
		}

	} // End AllListTable

	private void selectKategorieJ() {

		ArrayList<MusicVO> list = dao.selectKategorieJanre(txtJanre.getText());

		tableModel.setRowCount(0);

		for (int i = 0; i < list.size(); i++) {

			records[0] = list.get(i).getCid();
			records[1] = list.get(i).getTitle();
			records[2] = list.get(i).getArtist();
			records[3] = list.get(i).getJanre();
			records[4] = list.get(i).getYear();
			tableModel.addRow(records);

		}

		// 불러오는거는 select 문으로 임플에 select이용해서 janre 를 이용해서 불러오는데
//		출력하는거는 테이블에 올리스트로 해야함 while문 for문 
//		txtJanre.getText() - > 받아서 ....

	} // end selectKategorieJ

	private void selectKategorieA() {

		// 다시넣을때 열기니까 if절 끝에 괄호 주의

		ArrayList<MusicVO> list = dao.selectKategorieArtist(txtArtist.getText());

		tableModel.setRowCount(0);

		for (int i = 0; i < list.size(); i++) {

			records[0] = list.get(i).getCid();
			records[1] = list.get(i).getTitle();
			records[2] = list.get(i).getArtist();
			records[3] = list.get(i).getJanre();
			records[4] = list.get(i).getYear();
			tableModel.addRow(records);

		}
	} // end sKA

	// 불러오는거는 select 문으로 임플에 select이용해서 janre 를 이용해서 불러오는데
//		출력하는거는 테이블에 올리스트로 해야함 while문 for문 
//		txtJanre.getText() - > 받아서 ....

	private void selectKategorieY() {
//		다시넣을때 열기니까 if절 끝에 괄호 주의

		ArrayList<MusicVO> list = dao.selectKategorieYear(txtYear.getText());

		tableModel.setRowCount(0);

		for (int i = 0; i < list.size(); i++) {

			records[0] = list.get(i).getCid();
			records[1] = list.get(i).getTitle();
			records[2] = list.get(i).getArtist();
			records[3] = list.get(i).getJanre();
			records[4] = list.get(i).getYear();
			tableModel.addRow(records);

		}

		// 불러오는거는 select 문으로 임플에 select이용해서 janre 를 이용해서 불러오는데
//		출력하는거는 테이블에 올리스트로 해야함 while문 for문 
//		txtJanre.getText() - > 받아서 ....

	} // sKy

	private void updateMusic() {

		String title = txtTitle.getText();
		String artist = txtArtist.getText();
		String janre = txtJanre.getText();
		String year = txtYear.getText();
		if (txtIndex.getText().equals("") || title.equals("") || artist.equals("") || janre.equals("")
				|| year.equals("")) {
			txtLog.setText("곡 정보를 확인 해주세요.");

			return;
		}
		int index = Integer.parseInt(txtIndex.getText());
		MusicVO vo = new MusicVO(index, title, artist, janre, year);

		int result = dao.update(index, vo);
		if (result == 1) {
			txtLog.setText("수정이 완료되었습니다.");
		} else {
			txtLog.setText(index + " 번 곡 정보가 존재하지 않습니다.");
		}
	} // end updateMusic()

	private void deleteMusic() {
		int index = Integer.parseInt(txtIndex.getText());

		int result = dao.delete(index);
		if (result == 1) {
			txtLog.setText("삭제가 완료 되었습니다.");
		} else {
			txtLog.setText(index + "번 연락처가 없습니다.");
		}

	} // end deleteMusic()
	
	private void selectRandomIndex() {
		ArrayList<MusicVO> list = dao.select();
		
		MusicVO vo = new MusicVO();
		for(int i=0; i < list.size(); i++) {
			vo = new MusicVO(); // 시드값이아닌 차인덱스로저장
			System.out.println(i);
			System.out.println(list.get(i).toString());
		} // 순서대로 ㅂㅐ열 저장
		
		Random generator = new Random();
		int randomIndex = generator.nextInt(list.size());
		// api랜덤 메소드이용 = 배열 사이즈안에서 랜덤
		
		// vo에 랜덤인덱스의 정보를 불러옴
		// 기존의 셀렉트문을 사용했을때는 시드값으로 셀렉트문을 사용해야 했는데
		// 그러면 삭제한값의 빈 시드값이 발생되어 랜덤리스트 할때 널값이발생
		// 위에 for문으로 다시 배열을 차례로 저장한후에 그 index에서 랜덤추출
		System.out.println(randomIndex);
		txtLog.setText(list.get(randomIndex).toString());
		// 로그창확인 --> 메세지창에도 추가 !
		System.out.println(list.size());
		JOptionPane.showMessageDialog(null, list.get(randomIndex).toString());
	}
} // end MyPlayListMain
