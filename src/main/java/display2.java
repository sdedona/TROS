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
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.util.List;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class display2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public display2() throws IOException, GeneralSecurityException{
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
		  DefaultTableModel model = new DefaultTableModel(0,5); 
		  JTable tb = new JTable(model);
		  tb.setShowGrid(true);
		  //Vector<String> rowData = new Vector<String>();
		  
		  //Throw in the data
		  List<List<Object>> all= SheetsQuickstart.getVals();
		  model.setRowCount(all.size());
		  model.setColumnCount(all.get(0).size());
		  
		  for(int i=1;i<all.size();i++) {
			  for(int k = 0; k<all.get(0).size(); k++){
					//rowData.add((String)all.get(i).get(0));
					//rowData.add((String)all.get(i).get(1));
					//rowData.add((String)all.get(i).get(2));
					String value = (String)all.get(i).get(k);
					System.out.println(value);
					model.setValueAt(value, i, k);
		  	}
			
		//model.addRow(new String[] {(String)all.get(i).get(0),(String)all.get(i).get(1),(String)all.get(i).get(2)}); 
		  }
		  
		  
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

		JFrame JChange = new JFrame("Change");
		JChange.setSize(800, 500);
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JChange.setVisible(true);
			}
		});
		btnChange.setBounds(489, 312, 131, 25);
		contentPane.add(btnChange);

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
