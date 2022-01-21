import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class UpdateDist extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField txtName;
	private JTextField txtPh;
	private JTextField txtSchool;
	private JTextField txtDOJ;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDist frame = new UpdateDist();
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
	public UpdateDist() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Distributor Info");
		lblNewLabel.setBounds(185, 40, 148, 48);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(66, 108, 341, 277);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(28, 76, 104, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(28, 119, 54, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Phone No");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(28, 162, 124, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Schools");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(28, 202, 124, 14);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Date of joining");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(10, 227, 124, 30);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		textId = new JTextField();
		textId.setBounds(122, 75, 86, 20);
		panel.add(textId);
		textId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(122, 118, 86, 20);
		panel.add(txtName);
		
		txtPh = new JTextField();
		txtPh.setColumns(10);
		txtPh.setBounds(122, 161, 86, 20);
		panel.add(txtPh);
		
		txtSchool = new JTextField();
		txtSchool.setColumns(10);
		txtSchool.setBounds(122, 201, 86, 20);
		panel.add(txtSchool);
		
		txtDOJ = new JTextField();
		txtDOJ.setColumns(10);
		txtDOJ.setBounds(122, 234, 86, 20);
		panel.add(txtDOJ);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(76, 396, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(196, 396, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(295, 396, 89, 23);
		contentPane.add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(417, 105, 326, 286);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(55, 442, 374, 48);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("ID");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(25, 23, 51, 14);
		panel_1.add(lblNewLabel_1_1_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(98, 22, 86, 20);
		panel_1.add(textField);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(454, 456, 89, 23);
		contentPane.add(btnSearch);
	}
}
