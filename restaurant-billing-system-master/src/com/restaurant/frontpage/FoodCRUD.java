package com.restaurant.frontpage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.restaurant.dao.FoodDaoImp;
import com.restaurant.pojo.Food;


public class FoodCRUD extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField price;
	private JTextField fid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodCRUD frame = new FoodCRUD();
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
	public FoodCRUD() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Add / Update /Delete Food");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(415, 11, 526, 51);
		panel_1.add(lblNewLabel_1);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Tahoma", Font.BOLD, 20));
		name.setBounds(208, 149, 75, 25);
		panel_1.add(name);
		
		fname = new JTextField();
		fname.setColumns(10);
		fname.setBounds(294, 149, 213, 25);
		panel_1.add(fname);
		
		JLabel cat = new JLabel("Category:");
		cat.setFont(new Font("Tahoma", Font.BOLD, 20));
		cat.setBounds(722, 149, 109, 25);
		panel_1.add(cat);
		
		JComboBox category = new JComboBox();
		category.setBounds(841, 149, 213, 25);
	    category.addItem("");
		category.addItem("Snack");
		category.addItem("Light Food");
		category.addItem("Soft Drinks");
		category.addItem("Desserts");
		category.addItem("Meal");
		category.addItem("Other");
		panel_1.add(category);
		
		JLabel v1 = new JLabel("");
		v1.setBounds(517, 149, 146, 25);
		panel_1.add(v1);
		
		JLabel v2 = new JLabel("");
		v2.setBounds(1064, 149, 146, 25);
		panel_1.add(v2);
		
		JLabel prc = new JLabel("Price:");
		prc.setFont(new Font("Tahoma", Font.BOLD, 20));
		prc.setBounds(216, 206, 67, 25);
		panel_1.add(prc);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(294, 206, 213, 25);
		panel_1.add(price);
		
		JLabel v3 = new JLabel("");
		v3.setBounds(517, 206, 146, 25);
		panel_1.add(v3);
		
		JLabel desc = new JLabel("Description:");
		desc.setFont(new Font("Tahoma", Font.BOLD, 20));
		desc.setBounds(708, 206, 122, 25);
		panel_1.add(desc);
		
		JTextArea description = new JTextArea();
		description.setBounds(841, 206, 213, 66);
		panel_1.add(description);
		
		JLabel v4 = new JLabel("");
		v4.setBounds(1064, 206, 146, 25);
		panel_1.add(v4);
		
		JButton addButton = new JButton("ADD FOOD");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String name=fname.getText();
				String catg=(String) category.getSelectedItem();
				String prc=price.getText();
				String desc=description.getText();
				
				if(name.equals(""))
				{
					v1.setText("This field is required.");
				}
				
				else if(catg.equals(""))
				{
					v2.setText("Select Category.");
				}
				
				else if(prc.equals(""))
				{
					v3.setText("This field is required.");
				}
				
				else if(desc.equals(""))
				{
					v4.setText("This field is required.");
				}
				
				else
				{
					Food food=new Food(name, catg, desc,Double.parseDouble(prc));
					boolean flag=new FoodDaoImp().addFood(food);
					
					if(flag==true)
					{
						fname.setText("");
                        category.setSelectedItem("");
                        price.setText("");
                        description.setText("");
						JOptionPane.showMessageDialog(null,"Food Added successfully.");
					}
					
					else
					{
						JOptionPane.showMessageDialog(null,"Failed to add Food.");
					}
					
				}
				
			}
		});
		addButton.setForeground(new Color(32, 178, 170));
		addButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		addButton.setBackground(Color.WHITE);
		addButton.setBounds(219, 311, 157, 37);
		panel_1.add(addButton);
		
		JLabel id = new JLabel("Food Id:");
		id.setFont(new Font("Tahoma", Font.BOLD, 20));
		id.setBounds(198, 95, 85, 25);
		panel_1.add(id);
		
		fid = new JTextField();
		fid.setColumns(10);
		fid.setBounds(294, 95, 213, 25);
		panel_1.add(fid);
		
		JButton btnUpdateFood = new JButton("UPDATE FOOD");
		btnUpdateFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String id=fid.getText();
				String name=fname.getText();
				String catg=(String) category.getSelectedItem();
				String prc=price.getText();
				String desc=description.getText();
				
				if(id.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter Food Id:)");
				}
				
				else if(name.equals(""))
				{
					v1.setText("This field is required.");
				}
				
				else if(catg.equals(""))
				{
					v2.setText("Select Category.");
				}
				
				else if(prc.equals(""))
				{
					v3.setText("This field is required.");
				}
				
				else if(desc.equals(""))
				{
					v4.setText("This field is required.");
				}
				
				else
				{
					Food food=new Food(name, catg, desc,Double.parseDouble(prc));
					food.setFoodId(Integer.parseInt(id));
					boolean flag=new FoodDaoImp().updateFood(food);
					
					if(flag==true)
					{
						fid.setText("");
						fname.setText("");
                        category.setSelectedItem("");
                        price.setText("");
                        description.setText("");
						JOptionPane.showMessageDialog(null,"Food updated successfully.");
					}
					
					else
					{
						JOptionPane.showMessageDialog(null,"Failed to update Food.");
					}
					
				}
			}
		});
		btnUpdateFood.setForeground(new Color(32, 178, 170));
		btnUpdateFood.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpdateFood.setBackground(Color.WHITE);
		btnUpdateFood.setBounds(658, 311, 192, 37);
		panel_1.add(btnUpdateFood);
		
		JButton btnDeleteFood = new JButton("DELETE FOOD");
		btnDeleteFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String id=fid.getText();
				
				if(id.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter Food Id:)");
				}
				
				else
				{

					boolean flag=new FoodDaoImp().deleteFoodById(Integer.parseInt(id));
					
					if(flag==true)
					{
						fid.setText("");
						fname.setText("");
                        category.setSelectedItem("");
                        price.setText("");
                        description.setText("");
						JOptionPane.showMessageDialog(null,"Food deleted successfully.");
					}
					
					else
					{
						JOptionPane.showMessageDialog(null,"Failed to delete Food.");
					}
					
				}
			}
		});
		btnDeleteFood.setForeground(new Color(32, 178, 170));
		btnDeleteFood.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDeleteFood.setBackground(Color.WHITE);
		btnDeleteFood.setBounds(882, 311, 172, 37);
		panel_1.add(btnDeleteFood);
		
		JButton getbutton = new JButton("GET FOOD");
		getbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(fid.getText().equals(""))
				{
				    JOptionPane.showMessageDialog(null,"Enter Food Id to Fetch the food.");	
				}
				
				else
				{
					String i=fid.getText();
					int id=Integer.parseInt(i);
					Food f=new FoodDaoImp().getFoodById(id);
					
					if(f==null)
					{
						JOptionPane.showMessageDialog(null,"No such food available.");	
					}
					
					else
					{
						fid.setText(i);
						fname.setText(f.getFoodName());
						price.setText(String.valueOf(f.getPrice()));
						description.setText(f.getFoodDescription());
						category.setSelectedItem(f.getFoodCategory());
					}
				
				}
				
				
			}
		});
		getbutton.setForeground(new Color(32, 178, 170));
		getbutton.setFont(new Font("Tahoma", Font.BOLD, 20));
		getbutton.setBackground(Color.WHITE);
		getbutton.setBounds(427, 311, 192, 37);
		panel_1.add(getbutton);
		
		JLabel lblNewLabel_2 = new JLabel("Enter food Id to fetch the product.");
		lblNewLabel_2.setBounds(525, 95, 178, 23);
		panel_1.add(lblNewLabel_2);
		
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
	}
}
