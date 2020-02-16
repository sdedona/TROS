import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class addMem extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public addMem() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 502);
		contentPane =  new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThing1 = new JLabel("thing1");
		lblThing1.setBounds(25, 142, 68, 16);
		contentPane.add(lblThing1);
		
		textField = new JTextField();
		textField.setBounds(12, 186, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblThing = new JLabel("thing2");
		lblThing.setBounds(256, 142, 56, 16);
		contentPane.add(lblThing);
		
		textField_1 = new JTextField();
		textField_1.setBounds(228, 186, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblThing_1 = new JLabel("thing3");
		lblThing_1.setBounds(433, 142, 56, 16);
		contentPane.add(lblThing_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(409, 186, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(584, 186, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(751, 186, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(608, 142, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(770, 142, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(415, 305, 97, 25);
		contentPane.add(btnAdd);
	}
}
