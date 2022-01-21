package dbmsgui;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class frame1 extends JFrame {

	private JFrame frame;
	private JTextField s;
	private JTextField ps;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 window = new frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public void connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/dbms","root","");
			
		}
		catch(ClassNotFoundException ex)
		{}
		catch(SQLException ex)
		{}
	}
	
	public void table_load()
	{
		try
		{
			pst = con.prepareStatement("select * from school_staff");
			rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel (rs));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	

	/**
	 * Create the application.
	 */
	public frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.setBounds(100, 100, 786, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(10, 86, 369, 236);
		frame.getContentPane().add(panel1);
		panel1.setBorder(new TitledBorder(null, "Staff Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Staff ID");
		lblNewLabel.setBounds(10, 35, 125, 31);
		panel1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLACK);
		
		s = new JTextField();
		s.setBounds(112, 37, 251, 31);
		panel1.add(s);
		s.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 89, 92, 37);
		panel1.add(lblPassword);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		ps = new JTextField();
		ps.setBounds(112, 92, 251, 31);
		panel1.add(ps);
		ps.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(185, 164, 107, 37);
		panel1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBounds(48, 164, 107, 37);
		panel1.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resgisterstaff rg = new resgisterstaff();
				rg.setVisible(true);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String id,pass;
					id=s.getText();
					pass=ps.getText();
					pst =con.prepareStatement("select * from staff_login where StID = ? and password=?");
					pst.setString(1, id);
					pst.setString(2, pass);
					rs = pst.executeQuery();
					
					if(rs.next()==true)
					{
						studentregister sg = new studentregister();
						sg.show();
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Incorrect Staff ID or Password");
					}
				}catch(SQLException eli)
				{
					eli.printStackTrace();
				}
				
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Mid-Day Meal Management");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_1.setBounds(10, 11, 403, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(389, 86, 381, 236);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		connect();
		table_load();
	}
}
