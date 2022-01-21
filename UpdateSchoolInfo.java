import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class UpdateSchoolInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateSchoolInfo frame = new UpdateSchoolInfo();
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
	public UpdateSchoolInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("School Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(76, 144, 111, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSchoolId = new JLabel("Id");
		lblSchoolId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSchoolId.setBounds(76, 110, 111, 14);
		contentPane.add(lblSchoolId);
		
		JLabel lblHeadName = new JLabel("Head Name");
		lblHeadName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHeadName.setBounds(76, 198, 111, 14);
		contentPane.add(lblHeadName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddress.setBounds(76, 252, 111, 14);
		contentPane.add(lblAddress);
		
		JLabel lblPhoneNo = new JLabel("Phone No");
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhoneNo.setBounds(76, 308, 111, 14);
		contentPane.add(lblPhoneNo);
		
		textField = new JTextField();
		textField.setBounds(240, 109, 111, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(240, 143, 111, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(240, 197, 111, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(240, 251, 111, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(240, 307, 111, 20);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_1 = new JLabel("Update School Info");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(234, 32, 186, 39);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(111, 367, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(262, 367, 89, 23);
		contentPane.add(btnExit);
		
		table = new JTable();
		table.setBounds(403, 110, 249, 262);
		contentPane.add(table);
	}

}
