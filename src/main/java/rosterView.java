import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.graalvm.compiler.nodes.NodeView.Default;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class rosterView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rosterView frame = new rosterView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	

	public rosterView() {
		
		System.out.println("test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(274, 83, 2, 2);
		contentPane.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel(5, 0);
		table = new JTable(model);
		Vector<String> rowData = new Vector<String>();
		rowData.add("1");
		model.addRow(rowData);
		//table.setBounds(0, 0, 1, 1);
		contentPane.add(table);
		
		
		}
	}

