package etc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;

public class Gui {

	private JFrame frame;
	private JTable table;
	private String[] colNames = {"No", "이름","전화번호"};
	private Object[] records = new Object[colNames.length];
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
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
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tableModel = new DefaultTableModel(colNames, 0);
		table = new JTable(tableModel);
		table.setBounds(12, 10, 410, 241);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 410, 241);
		scrollPane.setViewportView(table);
		frame.getContentPane().add(scrollPane);
		
		for(int i = 0; i < 3; i++ ) {
			records[0] = i;
			records[1] = "Test" + i;
			records[2] = "010-1111-111" + i;
			tableModel.addRow(records);
			
		}
	}
}
