package com.restaurant.frontpage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.restaurant.utility.DBUtility;

import net.proteanit.sql.DbUtils;

public class TotalOrders extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TotalOrders frame = new TotalOrders();
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
	public TotalOrders() {
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
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Home  f = new Home();
				f.setVisible(true);
				f.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
		});
		back.setForeground(new Color(32, 178, 170));
		back.setFont(new Font("Tahoma", Font.BOLD, 15));
		back.setBackground(new Color(255, 255, 255));
		back.setBounds(0, 0, 89, 23);
		panel_1.add(back);
		
		JLabel lblNewLabel_1 = new JLabel("TOTAL ORDERS");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(420, 11, 526, 51);
		panel_1.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(153, 73, 1046, 437);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		Connection con=DBUtility.connection();
		String query="select * from orders";
		try {
			PreparedStatement stmt=con.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			JButton btnLogout = new JButton("LOGOUT");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					try {
						
						int yesOrNo=JOptionPane.showConfirmDialog(null,"Do you want to Logout?");
						if(yesOrNo==0)
						{
							Login l = new Login();
							l.setVisible(true);
							l.setExtendedState(JFrame.MAXIMIZED_BOTH);
							dispose();
							JOptionPane.showMessageDialog(null,"Successfully Logged Out.");
						}
						
					    
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			btnLogout.setForeground(new Color(32, 178, 170));
			btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnLogout.setBackground(Color.WHITE);
			btnLogout.setBounds(450, 534, 177, 37);
			panel_1.add(btnLogout);
			
			JButton btnExit = new JButton("EXIT");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					int yesOrNo=JOptionPane.showConfirmDialog(null,"Do you want to exit?");
					if(yesOrNo==0)
					{
						System.exit(0);
					}
				}
			});
			btnExit.setForeground(new Color(32, 178, 170));
			btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnExit.setBackground(Color.WHITE);
			btnExit.setBounds(737, 534, 177, 37);
			panel_1.add(btnExit);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
