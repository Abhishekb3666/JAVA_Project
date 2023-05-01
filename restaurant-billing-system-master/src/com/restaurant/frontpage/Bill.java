package com.restaurant.frontpage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.restaurant.dao.FoodDaoImp;
import com.restaurant.dao.OrderDaoImp;
import com.restaurant.message.SendMessage;
import com.restaurant.pojo.Food;
import com.restaurant.pojo.Order;
import com.restaurant.utility.DBUtility;

import net.proteanit.sql.DbUtils;

public class Bill extends JFrame {

	private JPanel contentPane;
	private JTextField searchName;
	private JTable table;
	private JTextField custName;
	private JTextField fid;
	private JTextField quantity;
	private JTable showAddedFood;
	private JTextArea bill;
	public static String customerName;
	public static String customerMobile;
	public static List<Order> l=new ArrayList<>();
	private JTextField mob;
	private JLabel lblMobileNo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    Bill frame = new Bill();
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
	public Bill() {
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(32, 178, 170));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		panel_2.setBounds(10, 39, 390, 572);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("TOTAL FOODS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBackground(new Color(32, 178, 170));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(48, 22, 287, 30);
		panel_2.add(lblNewLabel_1);
		
		searchName = new JTextField();
		searchName.setBounds(23, 62, 237, 30);
		panel_2.add(searchName);
		searchName.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 103, 338, 458);
		panel_2.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		Connection con=DBUtility.connection();
		String query="select FoodID,FoodName,price as FoodPrice from food";
		try {
			PreparedStatement stmt=con.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setForeground(new Color(32, 178, 170));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(272, 62, 89, 30);
		panel_2.add(btnNewButton);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		panel_2_1.setBackground(new Color(32, 178, 170));
		panel_2_1.setBounds(425, 39, 516, 572);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ORDER FOOD");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBackground(new Color(32, 178, 170));
		lblNewLabel_1_1.setBounds(114, 22, 287, 30);
		panel_2_1.add(lblNewLabel_1_1);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Tahoma", Font.BOLD, 20));
		name.setBounds(53, 63, 75, 25);
		panel_2_1.add(name);
		
		custName = new JTextField();
		custName.setColumns(10);
		custName.setBounds(139, 63, 213, 25);
		panel_2_1.add(custName);
		
		JLabel v1 = new JLabel("");
		v1.setBounds(362, 63, 146, 25);
		panel_2_1.add(v1);
		
		JLabel id = new JLabel("Food Id:");
		id.setFont(new Font("Tahoma", Font.BOLD, 20));
		id.setBounds(37, 153, 91, 25);
		panel_2_1.add(id);
		
		JLabel v2 = new JLabel("");
		v2.setBounds(362, 153, 146, 25);
		panel_2_1.add(v2);
		
		fid = new JTextField();
		fid.setColumns(10);
		fid.setBounds(139, 153, 213, 25);
		fid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				char c=e.getKeyChar();
				if(Character.isLetter(c))
				{ 
					v2.setText("Enter only number.");
					fid.setEditable(false);
				}
				else
				{
					fid.setEditable(true);
				}
			}
		});
		panel_2_1.add(fid);
		
		
		
		JLabel quan = new JLabel("Quantity:");
		quan.setFont(new Font("Tahoma", Font.BOLD, 20));
		quan.setBounds(25, 199, 103, 25);
		panel_2_1.add(quan);
		
		JLabel v3 = new JLabel("");
		v3.setBounds(362, 199, 146, 25);
		panel_2_1.add(v3);
		
		quantity = new JTextField();
		quantity.setColumns(10);
		quantity.setBounds(139, 199, 213, 25);
		quantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				char c=e.getKeyChar();
				if(Character.isLetter(c))
				{ 
					v3.setText("Enter only number.");
					quantity.setEditable(false);
				}
				else
				{
					quantity.setEditable(true);
				}
			}
		});
		panel_2_1.add(quantity);
		
		lblMobileNo = new JLabel("Mobile No.:");
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMobileNo.setBounds(10, 106, 118, 25);
		panel_2_1.add(lblMobileNo);
		
		mob = new JTextField();
		mob.setColumns(10);
		mob.setBounds(139, 106, 213, 25);
		panel_2_1.add(mob);
		
		JLabel v4 = new JLabel("");
		v4.setBounds(362, 106, 146, 25);
		panel_2_1.add(v4);
		
		JButton btnOrder = new JButton("ADD");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(!l.isEmpty())
				{
					custName.setText("");
					mob.setText("");
					bill.setText("****************** WELCOME TO FOOD PLAZA *****************"
							+ "\n\nCustomer Name : "+customerName+"\nDate : "+LocalDate.now().toString()
							+  "\n\n*******************************************************************"
							+ "\n\n|Food Name|\t\t|Quantity|\t|Price|"
							+ "\n-------------------------------------------------------------------------------"
							);
					
					for(Order o:l)
					{
						String foodName=new FoodDaoImp().getFoodNameById(o.getFoodId());
						bill.setText(bill.getText()+"\n"+foodName+"\t\t|"+o.getQuantity()+"|\t"+"|"+o.getPrice()+"|\n-------------------------------------------------------------------------------");
					}
					
					Connection con=DBUtility.connection();
					for(Order o:l)
					{
						new OrderDaoImp().addOrder(o);
					}
					
					bill.setText(bill.getText()+"\n\n\t\tTotal Price : "+new OrderDaoImp().totalOrderPrice(customerName));
					DefaultTableModel model = (DefaultTableModel)showAddedFood.getModel();
					while(model.getRowCount()>0)
					{
						for(int i=0;i<model.getRowCount();i++)
						{
							model.removeRow(i);
							custName.setText("");
							fid.setText("");
							quantity.setText("");
						}
					}
		
					l.removeAll(l);
					JOptionPane.showMessageDialog(null,"Order added Successfully and Bill is generated.");
				}
				
				else
				{
					JOptionPane.showMessageDialog(null,"Add the foods to order.");
				}
				
				
			}
		});
		btnOrder.setForeground(new Color(32, 178, 170));
		btnOrder.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOrder.setBackground(Color.WHITE);
		btnOrder.setBounds(115, 518, 138, 43);
		panel_2_1.add(btnOrder);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				DefaultTableModel model = (DefaultTableModel)showAddedFood.getModel();
				while(model.getRowCount()>0)
				{
					for(int i=0;i<model.getRowCount();i++)
					{
						model.removeRow(i);
						custName.setText("");
						fid.setText("");
						quantity.setText("");
					}
				}
	
				l.removeAll(l);
	
			}
		});
		btnCancel.setForeground(new Color(32, 178, 170));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(263, 518, 138, 43);
		panel_2_1.add(btnCancel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 278, 468, 225);
		panel_2_1.add(scrollPane_1);
		
		showAddedFood = new JTable();
		showAddedFood.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Food Name", "Quantity", "Food Price"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(showAddedFood);
		
		JButton add = new JButton("ADD FOOD");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String name=custName.getText();
				String mobile=mob.getText();
				String foodId=fid.getText();
				String quan=quantity.getText();
				
				if(name.equals(""))
				{
					v1.setText("This field is required.");
				}
				
				if(mobile.equals(""))
				{
					v4.setText("This field is required.");
				}
				
				else if(foodId.equals(""))
				{
					v2.setText("This field is required.");
				}
				
				else if(quan.equals(""))
				{
					v3.setText("This field is required.");
				}
				
				else
				{
					customerName=name;
					customerMobile=mobile;
					String foodName=new FoodDaoImp().getFoodNameById(Integer.parseInt(foodId));
					Food f=new FoodDaoImp().getFoodById(Integer.parseInt(foodId));
					
					if(f!=null)
					{
						Double price=f.getPrice();
						Double totalPrice=price*Integer.parseInt(quan);
						DefaultTableModel model = (DefaultTableModel)showAddedFood.getModel();
						model.addRow(new Object[]{
								foodName,
						     Integer.parseInt(quan),
						     totalPrice
						});
						
						fid.setText("");
						quantity.setText("");
						
						Order o=new Order();
						o.setFoodId(Integer.parseInt(foodId));
						o.setDate(LocalDate.now().toString());
						o.setCustomerName(name);
						o.setQuantity(Integer.parseInt(quan));
						o.setPrice(totalPrice);
						l.add(o);
					}
					
					else
					{
						fid.setText("");
						quantity.setText("");
						JOptionPane.showMessageDialog(null,"No such food is available.");
					}
					
				}
		
			}
		});
		add.setBackground(new Color(255, 255, 255));
		add.setFont(new Font("Tahoma", Font.BOLD, 15));
		add.setForeground(new Color(32, 178, 170));
		add.setBounds(139, 244, 213, 23);
		panel_2_1.add(add);
		
		
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		panel_2_2.setBackground(new Color(32, 178, 170));
		panel_2_2.setBounds(965, 39, 390, 572);
		panel_1.add(panel_2_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("BILL ");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBackground(new Color(32, 178, 170));
		lblNewLabel_1_2.setBounds(48, 22, 287, 30);
		panel_2_2.add(lblNewLabel_1_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(20, 58, 349, 444);
		panel_2_2.add(scrollPane_2);
		
		bill = new JTextArea();
		bill.setEditable(false);
		scrollPane_2.setViewportView(bill);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				bill.setText("");
			}
		});
		btnClear.setForeground(new Color(32, 178, 170));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setBackground(Color.WHITE);
		btnClear.setBounds(197, 513, 138, 43);
		panel_2_2.add(btnClear);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			      try {
			    	String file = "C:/Users/Vostro.MURADALIMJ/Desktop/PDF's/bill.pdf";    
				    //Creating a Document object 
				    Document doc = new Document();    
					PdfWriter.getInstance(doc, new FileOutputStream(file));
					doc.open();
				    Paragraph para = new Paragraph(bill.getText());
				    System.out.println(bill.getText());
				    doc.add(para);
				    doc.close(); 
				    bill.setText("");
				    System.out.println("Text added successfully.."); 
				  } catch (FileNotFoundException | DocumentException e1) {
					e1.printStackTrace();
				}
			      String apiKey="VeKDJJ29ZpxDPDWaKfhYZ5qwJvMHFgFlduIKTf5205GohItZyCG";
				  SendMessage sotp=new SendMessage();
				  String message="****** FOOD PLAZA ******"+
				                 "\nTotal Bill for your Order is Rs. "+new OrderDaoImp().totalOrderPrice(customerName)+"\nThanks for visiting we loved to served you:)\nvisit again....";
				  System.out.println(message);
		          sotp.sendMessage(message, customerMobile, apiKey);
			      
			}
		});
		btnPrint.setForeground(new Color(32, 178, 170));
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPrint.setBackground(Color.WHITE);
		btnPrint.setBounds(49, 513, 138, 43);
		panel_2_2.add(btnPrint);
		
		
	}
}
