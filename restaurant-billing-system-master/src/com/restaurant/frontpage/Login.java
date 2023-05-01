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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.restaurant.dao.AdminDaoImp;
import com.restaurant.pojo.Admin;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField uname;
	private JPasswordField pass;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
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
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN LOGIN");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(414, 11, 526, 51);
		panel_1.add(lblNewLabel_1);
		
		JLabel adminUserName = new JLabel("Username:");
		adminUserName.setFont(new Font("Tahoma", Font.BOLD, 20));
		adminUserName.setBounds(442, 87, 118, 25);
		panel_1.add(adminUserName);
		
		uname = new JTextField();
		uname.setColumns(10);
		uname.setBounds(571, 87, 213, 25);
		panel_1.add(uname);
		
		JLabel password = new JLabel("Password:");
		password.setFont(new Font("Tahoma", Font.BOLD, 20));
		password.setBounds(446, 147, 118, 25);
		panel_1.add(password);
		
		JLabel v1 = new JLabel("");
		v1.setBounds(794, 87, 146, 25);
		panel_1.add(v1);
		
		JLabel v2 = new JLabel("");
		v2.setBounds(794, 147, 146, 25);
		panel_1.add(v2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String username=uname.getText();
				String password=pass.getText();
				
				if(username.equals(""))
				{
					v1.setText("This field is required.");
				}
				
				else if(password.equals(""))
				{
					v2.setText("This field is required.");
				}
				
				else
				{
					Admin admin=new AdminDaoImp().getAdmin(username, password);
					if(admin==null)
					{
						JOptionPane.showMessageDialog(null,"Failed to Login, Please try again..");
					}
					
					else
					{
						Home  l = new Home();
						l.setVisible(true);
						l.setExtendedState(JFrame.MAXIMIZED_BOTH);
						dispose();
						JOptionPane.showMessageDialog(null,"Logged in Successfully as "+username);
					}
				}
				
			}
		});
		btnNewButton.setForeground(new Color(32, 178, 170));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(571, 201, 213, 37);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New User? ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(561, 273, 109, 25);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("click here to Register");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				Register  l = new Register();
				l.setVisible(true);
				l.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
		});
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(656, 273, 158, 25);
		panel_1.add(lblNewLabel_3);
		
		pass = new JPasswordField();
		pass.setBounds(571, 147, 213, 25);
		panel_1.add(pass);
	}
}
