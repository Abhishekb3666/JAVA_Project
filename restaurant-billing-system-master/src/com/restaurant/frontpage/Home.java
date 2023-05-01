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
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.restaurant.utility.DBUtility;

import net.proteanit.sql.DbUtils;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField searchName;
	private JTextField searchPrice;
	private JTable table;
	private JComboBox cate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
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
		
		JButton btnAddMedicine = new JButton("ADD FOOD");
		btnAddMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				FoodCRUD  f = new FoodCRUD();
				f.setVisible(true);
				f.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
		});
		btnAddMedicine.setForeground(new Color(32, 178, 170));
		btnAddMedicine.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddMedicine.setBackground(new Color(255, 255, 255));
		btnAddMedicine.setBounds(60, 51, 177, 37);
		panel_1.add(btnAddMedicine);
		
		JButton btnUpdateMedicine = new JButton("UPDATE FOOD");
		btnUpdateMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				FoodCRUD  f = new FoodCRUD();
				f.setVisible(true);
				f.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
		});
		btnUpdateMedicine.setBackground(new Color(255, 255, 255));
		btnUpdateMedicine.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdateMedicine.setForeground(new Color(32, 178, 170));
		btnUpdateMedicine.setBounds(60, 127, 177, 37);
		panel_1.add(btnUpdateMedicine);
		
		JButton btnDeleteMedicine = new JButton("DELETE FOOD");
		btnDeleteMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				FoodCRUD  f = new FoodCRUD();
				f.setVisible(true);
				f.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
		});
		btnDeleteMedicine.setForeground(new Color(32, 178, 170));
		btnDeleteMedicine.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeleteMedicine.setBackground(new Color(255, 255, 255));
		btnDeleteMedicine.setBounds(60, 206, 177, 37);
		panel_1.add(btnDeleteMedicine);
		
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
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.setBounds(60, 450, 177, 37);
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
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setForeground(new Color(32, 178, 170));
		btnExit.setBackground(new Color(255, 255, 255));
		btnExit.setBounds(60, 531, 177, 37);
		panel_1.add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(247, 51, 2, 517);
		panel_1.add(separator);
		
		searchName = new JTextField();
		searchName.setColumns(10);
		searchName.setBounds(271, 51, 155, 37);
		panel_1.add(searchName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(271, 116, 1070, 452);
		panel_1.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		Connection con=DBUtility.connection();
		String query="select * from food";
		try {
			PreparedStatement stmt=con.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		JButton searchByName = new JButton("Search By Name");
		searchByName.setBackground(new Color(255, 255, 255));
		searchByName.setForeground(new Color(32, 178, 170));
		searchByName.setFont(new Font("Tahoma", Font.BOLD, 12));
		searchByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(searchName.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Enter Food Name to Search.");
				}
				
				else
				{
					Connection con=DBUtility.connection();
					String value=searchName.getText();
					String query="select * from food where FoodName like '%"+value+"%'";
					try {
						PreparedStatement stmt=con.prepareStatement(query);
						ResultSet rs=stmt.executeQuery();
						searchName.setText("");
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				
			}
		});
		searchByName.setBounds(436, 51, 145, 37);
		panel_1.add(searchByName);
		
		JButton searchByCategory = new JButton("Search By Category");
		searchByCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String c=(String)cate.getSelectedItem();
				if(c.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Select Food Category to Search.");
				}
				
				else
				{
					Connection con=DBUtility.connection();
					String query="select * from food where FoodCategory='"+c+"'";
					try {
						PreparedStatement stmt=con.prepareStatement(query);
						ResultSet rs=stmt.executeQuery();
						cate.setSelectedItem("");
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		searchByCategory.setForeground(new Color(32, 178, 170));
		searchByCategory.setFont(new Font("Tahoma", Font.BOLD, 13));
		searchByCategory.setBackground(Color.WHITE);
		searchByCategory.setBounds(789, 51, 165, 37);
		panel_1.add(searchByCategory);
		
		searchPrice = new JTextField();
		searchPrice.setColumns(10);
		searchPrice.setBounds(1011, 51, 155, 37);
		panel_1.add(searchPrice);
		
		JButton btnSearchByPrice = new JButton("Search By Price");
		btnSearchByPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(searchPrice.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Enter Food Name to Search.");
				}
				
				else
				{
					Connection con=DBUtility.connection();
					String value=searchPrice.getText();
					Double p=Double.parseDouble(value);
					String query="select * from food where price<="+p;
					try {
						PreparedStatement stmt=con.prepareStatement(query);
						ResultSet rs=stmt.executeQuery();
						searchPrice.setText("");
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnSearchByPrice.setForeground(new Color(32, 178, 170));
		btnSearchByPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearchByPrice.setBackground(Color.WHITE);
		btnSearchByPrice.setBounds(1176, 51, 165, 37);
		panel_1.add(btnSearchByPrice);
		
	    cate = new JComboBox();
		cate.setBounds(624, 51, 155, 37);
		Connection con1=DBUtility.connection();
		String q="select distinct(FoodCategory) from food";
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(q);
			cate.addItem("");
			while(rs.next())
			{
				cate.addItem(rs.getString("FoodCategory"));
			}
			
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panel_1.add(cate);
		
		JButton btnOrderFood = new JButton("ORDER FOOD");
		btnOrderFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Bill l = new Bill();
				l.setVisible(true);
				l.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
			
		});
		btnOrderFood.setForeground(new Color(32, 178, 170));
		btnOrderFood.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOrderFood.setBackground(Color.WHITE);
		btnOrderFood.setBounds(60, 284, 177, 37);
		panel_1.add(btnOrderFood);
		
		JButton btnTotalOrders = new JButton("TOTAL ORDERS");
		btnTotalOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				TotalOrders l = new TotalOrders();
				l.setVisible(true);
				l.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
		});
		btnTotalOrders.setForeground(new Color(32, 178, 170));
		btnTotalOrders.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTotalOrders.setBackground(Color.WHITE);
		btnTotalOrders.setBounds(60, 366, 177, 37);
		panel_1.add(btnTotalOrders);
		
	}
}
