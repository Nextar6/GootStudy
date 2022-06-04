package side.java.porject;

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
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

public class MyPlayListMain01 {

	private JFrame frame;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		dao = MyPlayListDAOImple.getInstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPlayListMain01 window = new MyPlayListMain01();
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
	public MyPlayListMain01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 656, 641);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		

		JScrollPane scrollPane = new JScrollPane();// 여기
		scrollPane.setBounds(12, 261, 616, 331);
		frame.getContentPane().add(scrollPane);

		tableModel = new DefaultTableModel(colNames, 0);
		table = new JTable(tableModel);
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		scrollPane.setViewportView(table); // 여기

		JLabel lblNewLabel = new JLabel("MY PLAY LIST");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setBounds(211, 46, 218, 59);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblTitle = new JLabel("곡명");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(22, 120, 106, 15);
		frame.getContentPane().add(lblTitle);

		JLabel lblArtist = new JLabel("가수");
		lblArtist.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtist.setBounds(157, 120, 108, 15);
		frame.getContentPane().add(lblArtist);

		JLabel lblJanre = new JLabel("장르");
		lblJanre.setHorizontalAlignment(SwingConstants.CENTER);
		lblJanre.setBounds(283, 120, 108, 15);
		frame.getContentPane().add(lblJanre);

		JLabel lblYear = new JLabel("발매연도");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setBounds(413, 120, 108, 15);
		frame.getContentPane().add(lblYear);

		txtTitle = new JTextField();
		txtTitle.setBounds(20, 145, 108, 23);
		frame.getContentPane().add(txtTitle);
		txtTitle.setColumns(10);

		txtArtist = new JTextField();
		txtArtist.setColumns(10);
		txtArtist.setBounds(157, 145, 108, 23);
		frame.getContentPane().add(txtArtist);

		txtJanre = new JTextField();
		txtJanre.setColumns(10);
		txtJanre.setBounds(283, 145, 108, 23);
		frame.getContentPane().add(txtJanre);

		txtYear = new JTextField();
		txtYear.setColumns(10);
		txtYear.setBounds(413, 144, 108, 24);
		frame.getContentPane().add(txtYear);

		txtIndex = new JTextField();
		txtIndex.setBounds(78, 186, 44, 21);
		frame.getContentPane().add(txtIndex);
		txtIndex.setColumns(10);

		JLabel lblIndex = new JLabel("번호");
		lblIndex.setBounds(22, 186, 44, 21);
		frame.getContentPane().add(lblIndex);

		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMusic();
			}
		});
		btnUpdate.setBounds(226, 183, 91, 26);
		frame.getContentPane().add(btnUpdate);

		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteMusic();
			}
		});
		btnDelete.setBounds(319, 183, 91, 26);
		frame.getContentPane().add(btnDelete);

		JButton btnInsert = new JButton("추가");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertMusic();
			}
		});
		btnInsert.setBounds(532, 142, 96, 26);
		frame.getContentPane().add(btnInsert);

		txtLog = new JTextField();
		txtLog.setBounds(22, 219, 388, 32);
		frame.getContentPane().add(txtLog);
		txtLog.setColumns(10);

		JButton btnAllList = new JButton("전체리스트");
		btnAllList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllListTable();
			}
		});
		btnAllList.setBounds(413, 218, 116, 32);
		frame.getContentPane().add(btnAllList);

		JButton btnRandom = new JButton("랜덤선곡");
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<MusicVO> list = dao.select();
				Random generator = new Random();
				int randomIndex = generator.nextInt(list.size()) + 1;
				MusicVO vo = dao.select(randomIndex);
				System.out.println(randomIndex);
				txtLog.setText(vo.toString());
				System.out.println(list.size());
				JOptionPane.showMessageDialog(null, vo.toString());

			}
		});
		btnRandom.setBounds(532, 176, 96, 75);
		frame.getContentPane().add(btnRandom);

		

		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectMusic();
			}
		});
		btnSearch.setBounds(133, 183, 91, 27);
		frame.getContentPane().add(btnSearch);

		JButton btnKategorie = new JButton("카테고리검색");
		btnKategorie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!txtJanre.getText().equals("") && txtArtist.getText().equals("") && txtYear.getText().equals("") 
						&& txtTitle.getText().equals("")) {
					selectKategorieJ();
				} else if (txtJanre.getText().equals("") && !txtArtist.getText().equals("") && txtYear.getText().equals("")
						&& txtTitle.getText().equals("")) {
					selectKategorieA();
				} else if (txtJanre.getText().equals("") && txtArtist.getText().equals("") && !txtYear.getText().equals("")
						&& txtTitle.getText().equals("")) {
					selectKategorieY();
				} else {
					txtLog.setText("정확한 카테고리와 다른카테고리가 빈칸인지 체크 해주세요.");
				}
				
			} 

		});
		btnKategorie.setBounds(413, 180, 116, 32);
		frame.getContentPane().add(btnKategorie);

	} // end main()

	private void insertMusic() {
		String title = txtTitle.getText();
		String artist = txtArtist.getText();
		String janre = txtJanre.getText();
		String year = txtYear.getText();
		if (title.equals("") || artist.equals("") || janre.equals("") || year.equals("")) {
			txtLog.setText("등록 할 연락처 정보를 입력하세요.");
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
//		if(txtJanre.getText() != "" && txtArtist.getText() == "" && txtYear.getText() == "" && txtTitle.getText() == "") {
//		다시넣을때 열기니까 if절 끝에 괄호 주의

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
//		if(txtJanre.getText() != "" && txtArtist.getText() == "" && txtYear.getText() == "" && txtTitle.getText() == "") {
//		다시넣을때 열기니까 if절 끝에 괄호 주의

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

		// 불러오는거는 select 문으로 임플에 select이용해서 janre 를 이용해서 불러오는데
//		출력하는거는 테이블에 올리스트로 해야함 while문 for문 
//		txtJanre.getText() - > 받아서 ....

	} // end sKA

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
		if (txtIndex.getText().equals("") || title.equals("") || artist.equals("") || janre.equals("") || year.equals("")) {
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
} // end MyPlayListMain
