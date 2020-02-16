import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Change extends JFrame {

	 

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public static String[] test(){
        JPanel contentPane;
	    JTextField textField;
	    JTextField textField_1;
	    JTextField textField_2;
	    JTextField textField_3;
	    JTextField textField_4;
        
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 927, 502);
		contentPane =  new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThing1 = new JLabel("Name");
		lblThing1.setBounds(25, 142, 68, 16);
		contentPane.add(lblThing1);
		
		textField = new JTextField();
		textField.setBounds(12, 186, 116, 22);
		contentPane.add(textField);
		textField.setColumns(100);
		
		JLabel lblThing = new JLabel("COL");
		lblThing.setBounds(256, 142, 56, 16);
		contentPane.add(lblThing);
		
		textField_1 = new JTextField();
		textField_1.setBounds(228, 186, 116, 22);
		contentPane.add(textField_1);
        textField_1.setColumns(100);
        
        

		
		JLabel lblThing_1 = new JLabel("Change");
		lblThing_1.setBounds(433, 142, 56, 16);
		contentPane.add(lblThing_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(409, 186, 116, 22);
		contentPane.add(textField_2);
        textField_2.setColumns(10);

        JButton Submit = new JButton("Submit");
        String[] change_values = new String[3];
        Submit.setBounds(475, 395, 131, 25);
        contentPane.add(Submit);  
        String[] nums = new String[3];
        if(Submit.getModel().isPressed()){
                nums[0] = textField.getText();
				nums[1] = textField_1.getText();
				nums[2] = textField_2.getText();
        }
        return nums;        
        /*
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
		contentPane.add(btnAdd);*/
    }
    public static void main(String[] args) {
        System.out.println("Hello");
    }
    
}
