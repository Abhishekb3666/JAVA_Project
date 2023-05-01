package com.restaurant.frontpage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.restaurant.dao.AdminDaoImp;
import com.restaurant.pojo.Admin;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField aName;
	private JTextField aUName;
	private JTextField aPhone;
	private JPasswordField aPass;
	private JPasswordField aCpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1263, 710);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 1365, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RESTAURANT BILLING SYSTEM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1340, 53);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(new Color(32, 178, 170));
		panel_1.setBounds(0, 86, 1365, 700);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN REGISTRATION");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(421, 11, 526, 51);
		panel_1.add(lblNewLabel_1);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Tahoma", Font.BOLD, 20));
		name.setBounds(205, 79, 75, 25);
		panel_1.add(name);
		
		aName = new JTextField();
		aName.setBounds(291, 79, 213, 25);
		panel_1.add(aName);
		aName.setColumns(10);
		
		JLabel v1 = new JLabel("");
		v1.setBounds(514, 79, 146, 25);
		panel_1.add(v1);
		
		JLabel username = new JLabel("Username:");
		username.setFont(new Font("Tahoma", Font.BOLD, 20));
		username.setBounds(705, 79, 122, 25);
		panel_1.add(username);
		
		aUName = new JTextField();
		aUName.setColumns(10);
		aUName.setBounds(838, 79, 213, 25);
		panel_1.add(aUName);
		
		JLabel v2 = new JLabel("");
		v2.setBounds(1061, 79, 146, 25);
		panel_1.add(v2);
		
		JLabel phone = new JLabel("Phone No.:");
		phone.setFont(new Font("Tahoma", Font.BOLD, 20));
		phone.setBounds(171, 136, 109, 25);
		panel_1.add(phone);
		
		aPhone = new JTextField();
		aPhone.setColumns(10);
		aPhone.setBounds(291, 136, 213, 25);
		panel_1.add(aPhone);
		
		JLabel v3 = new JLabel("");
		v3.setBounds(514, 136, 146, 25);
		panel_1.add(v3);
		
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Tahoma", Font.BOLD, 20));
		address.setBounds(726, 136, 101, 25);
		panel_1.add(address);
		
		JLabel v4 = new JLabel("");
		v4.setBounds(1061, 136, 146, 25);
		panel_1.add(v4);
		
		JTextArea aAddress = new JTextArea();
		aAddress.setBounds(838, 136, 213, 66);
		panel_1.add(aAddress);
		
		JLabel adminPassword = new JLabel("Password:");
		adminPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		adminPassword.setBounds(171, 224, 109, 25);
		panel_1.add(adminPassword);
		
		JLabel v5 = new JLabel("");
		v5.setBounds(514, 224, 146, 25);
		panel_1.add(v5);
		
		JLabel cPass = new JLabel("Confirm Pass:");
		cPass.setFont(new Font("Tahoma", Font.BOLD, 20));
		cPass.setBounds(689, 224, 138, 25);
		panel_1.add(cPass);
		
		JLabel v6 = new JLabel("");
		v6.setBounds(1061, 224, 146, 25);
		panel_1.add(v6);
		
		aPass = new JPasswordField();
		aPass.setBounds(291, 224, 213, 25);
		panel_1.add(aPass);
		
		aCpass = new JPasswordField();
		aCpass.setBounds(838, 224, 213, 25);
		panel_1.add(aCpass);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String name=aName.getText();
				String uname=aUName.getText();
				String phone=aPhone.getText();
				String address=aAddress.getText();
				String password=aPass.getText();
				String cpassword=aCpass.getText();
				
				if(name.equals(""))
				{
					v1.setText("This field is required");
				}
				
				else if(uname.equals(""))
				{
					v2.setText("This field is required");
				}
				
				else if(phone.equals(""))
				{
					v3.setText("This field is required");
				}
				
				else if(address.equals(""))
				{
					v4.setText("This field is required");
				}
				
				else if(password.equals(""))
				{
					v5.setText("This field is required");
				}
				
				else if(cpassword.equals(""))
				{
					v6.setText("This field is required");
				}
				
				else if(!password.equals(cpassword))
				{
					JOptionPane.showMessageDialog(null,"Password Mismatch, please try again");
				}
				
				else
				{
					Admin admin=new Admin(name,phone,uname,password,address);
					boolean flag=new AdminDaoImp().addAdmin(admin);
					
					if(flag==true)
					{
						JOptionPane.showMessageDialog(null,"Registered Successfully as "+name);
						Login  l = new Login();
						l.setVisible(true);
						l.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    				dispose();
					}
					
					else
					{
						JOptionPane.showMessageDialog(null,"Failed to register, Please try again.");
					}
					
				}
					
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(32, 178, 170));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(503, 289, 335, 37);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Already User? ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(551, 369, 109, 25);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("click here to Login");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				Login  l = new Login();
				l.setVisible(true);
				l.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
		});
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(670, 369, 158, 25);
		panel_1.add(lblNewLabel_3);
	}
}
