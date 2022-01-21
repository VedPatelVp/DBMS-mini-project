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

public class resgisterstaff extends JFrame {

	private JPanel contentPane;
	private JTextField sn;
	private JTextField ps;
	private JTextField doj;
	private JTextField si;
	private JTextField scid;
	private JTextField ph;
	private JTextField ds;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					resgisterstaff frame = new resgisterstaff();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	Connection con;
	PreparedStatement pst;
	
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
	/**
	 * Create the frame.
	 */
	public resgisterstaff() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Staff Resgister", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel1.setBounds(10, 0, 638, 303);
		contentPane.add(panel1);
		
		JLabel lblStaffName = new JLabel("staff name");
		lblStaffName.setForeground(Color.BLACK);
		lblStaffName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStaffName.setBounds(10, 64, 99, 31);
		panel1.add(lblStaffName);
		
		sn = new JTextField();
		sn.setColumns(10);
		sn.setBounds(106, 64, 205, 31);
		panel1.add(sn);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(10, 129, 92, 31);
		panel1.add(lblPassword);
		
		ps = new JTextField();
		ps.setColumns(10);
		ps.setBounds(106, 129, 205, 31);
		panel1.add(ps);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String staffname,staffid,DOJ,designation,schoolid,phone,password;
				staffname=sn.getText();
				staffid=si.getText();
				password=ps.getText();
				designation=ds.getText();
				DOJ=doj.getText();
				schoolid=scid.getText();
				phone=ph.getText();
				
				
				try {
					pst = con.prepareStatement("insert into school_staff(StID,Stname,Stphone,DOJ,Designation,SchoolID)values(?,?,?,?,?,?)");
					pst.setString(1, staffid);
					pst.setString(2, staffname);
					pst.setString(3, phone);
					pst.setString(4, DOJ);
					pst.setString(5, designation);
					pst.setString(6, schoolid);
					pst.executeUpdate();
					ph.setText("");
					sn.setText("");
					ds.setText("");
					doj.setText("");
					si.setText("");
					scid.setText("");
					si.requestFocus();
					
					pst=con.prepareStatement("insert into staff_login(StID,password)values(?,?)");
					pst.setString(1, staffid);
					pst.setString(2, password);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added");
					ps.setText("");
					
				}catch(SQLException el) {
					el.printStackTrace();
				}
				
				
				
				
				
			}
			
		});
		btnNewButton_1.setBounds(276, 255, 107, 37);
		panel1.add(btnNewButton_1);
		
		doj = new JTextField();
		doj.setColumns(10);
		doj.setBounds(396, 129, 226, 31);
		panel1.add(doj);
		
		JLabel lblDoj = new JLabel("DOJ");
		lblDoj.setForeground(Color.BLACK);
		lblDoj.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDoj.setBounds(339, 129, 57, 31);
		panel1.add(lblDoj);
		
		JLabel lblStaffId = new JLabel("staff ID");
		lblStaffId.setForeground(Color.BLACK);
		lblStaffId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStaffId.setBounds(321, 64, 75, 31);
		panel1.add(lblStaffId);
		
		si = new JTextField();
		si.setColumns(10);
		si.setBounds(396, 64, 226, 31);
		panel1.add(si);
		
		JLabel lblStaffName_1 = new JLabel("SchoolID");
		lblStaffName_1.setForeground(Color.BLACK);
		lblStaffName_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStaffName_1.setBounds(10, 196, 75, 31);
		panel1.add(lblStaffName_1);
		
		scid = new JTextField();
		scid.setColumns(10);
		scid.setBounds(91, 196, 107, 31);
		panel1.add(scid);
		
		ph = new JTextField();
		ph.setColumns(10);
		ph.setBounds(276, 196, 107, 31);
		panel1.add(ph);
		
		JLabel lblPassword_1 = new JLabel("Phone");
		lblPassword_1.setForeground(Color.BLACK);
		lblPassword_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword_1.setBounds(217, 196, 57, 31);
		panel1.add(lblPassword_1);
		
		ds = new JTextField();
		ds.setColumns(10);
		ds.setBounds(500, 196, 122, 31);
		panel1.add(ds);
		
		JLabel lblPassword_1_1 = new JLabel("Designation");
		lblPassword_1_1.setForeground(Color.BLACK);
		lblPassword_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword_1_1.setBounds(396, 196, 103, 31);
		panel1.add(lblPassword_1_1);
		
		JButton btnNewButton_1_1 = new JButton("Back");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1 fr=new frame1();
				fr.show();

			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_1.setBounds(10, 255, 107, 37);
		panel1.add(btnNewButton_1_1);
		
		connect();
	}
}
