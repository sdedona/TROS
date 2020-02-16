import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class display2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					display2 frame = new display2();
					frame.setTitle("TROS");
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
	public display2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Roster Management Software");
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTitle.setBounds(424, 96, 248, 36);
		contentPane.add(lblTitle);

		// Create the roster jtable here
		  JFrame rosterDisp = new JFrame("Roster"); 
		  rosterDisp.setLocationRelativeTo(null);
		  rosterDisp.setSize(800, 500); 
		  DefaultTableModel model = new DefaultTableModel(5,5); 
		  JTable tb = new JTable(model);
		  tb.setShowGrid(true);
		  JScrollPane scrollPane = new JScrollPane(tb);
		  scrollPane.setBounds(getBounds());
		  rosterDisp.getContentPane().add(scrollPane);
		  //end jtable work
		  
		  //Start add member page
		  JFrame addDisp = new JFrame("Add Member");
		  addDisp.setLocationRelativeTo(null);
		  addDisp.setSize(800, 500);
		  addDisp.setLayout(null);
		  
		  
		 
		
		JButton btnAddMember = new JButton("Add Member");
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				addMem open = new addMem();
				open.setVisible(true);
			
			}
		});
		btnAddMember.setBounds(349, 312, 131, 25);
		contentPane.add(btnAddMember);

		JButton btnNewButton = new JButton("Remove Member");
		btnNewButton.setBounds(489, 312, 131, 25);
		contentPane.add(btnNewButton);

		JButton btnViewRoster = new JButton("View Roster");
		btnViewRoster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rosterDisp.setVisible(true);
				
			}
		});
		btnViewRoster.setBounds(475, 395, 131, 25);
		contentPane.add(btnViewRoster);

		JButton btnGenerateEmailList = new JButton("Generate Email List");
		btnGenerateEmailList.setBounds(632, 312, 166, 25);
		contentPane.add(btnGenerateEmailList);
		
		JButton btnEditMember = new JButton("Edit Member");
		btnEditMember.setBounds(225, 312, 112, 25);
		contentPane.add(btnEditMember);
	}
}
