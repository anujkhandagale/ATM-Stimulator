package bank.management.system;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

	/**
	 * 
	 */
	
	
	JTextField  panTextField, addharTextField;
	JButton next;
	JRadioButton ayes, ano, syes, sno;
	JComboBox religion, Category, income,  education, occupation;
	String formno;
	
	
	private static final long serialVersionUID = 1L;

	SignupTwo(String formno) {
		this.formno = formno;
		setLayout(null);
		setTitle("AUTOMATED TAILOR MACHINE");
		
		
		 
		
		
		JLabel additionalDetails = new JLabel("Page 2: ADDITIONAL DETAILS");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);
		
		JLabel religen = new JLabel("Religion :");
		religen.setFont(new Font("Raleway", Font.BOLD,20));
		religen.setBounds(100, 140, 100, 30);
		add(religen);
		
		String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
		religion = new JComboBox(valReligion);
		religion.setBounds(300, 140, 400, 30);
		add(religion);
			
		JLabel category = new JLabel("Category Name :");
		category.setFont(new Font("Raleway", Font.BOLD, 20));
		category.setBounds(100, 190, 200, 30);
		add(category);
		
		String valCategory[] = {"Open","Obc","St","Nt","Other"};
		Category = new JComboBox(valCategory);
		Category.setBounds(300, 190, 400, 30);
		add(Category);
		
		JLabel Income = new JLabel("Income :");
		Income.setFont(new Font("Raleway", Font.BOLD, 20));
		Income.setBounds(100, 240, 200, 30);
		add(Income);
		
		String valIncome[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","upto 10,00,000"};
		income = new JComboBox(valIncome);
		income.setBounds(300, 240, 400, 30);
		add(income);
					
		JLabel edu = new JLabel("Educational");
		edu.setFont(new Font("Raleway", Font.BOLD, 20));
		edu.setBounds(100, 310, 200, 30);
		add(edu);
		
		JLabel qualification = new JLabel("Qualification :");
		qualification.setFont(new Font("Raleway", Font.BOLD, 20));
		qualification.setBounds(100, 340, 200, 30);
		add(qualification);
		
		String valEducation[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
		education = new JComboBox(valEducation);
		education.setBounds(300,340, 400, 30);
		add(education);
		
		JLabel Occupation = new JLabel("Occupation :");
		Occupation.setFont(new Font("Raleway", Font.BOLD, 20));
		Occupation.setBounds(100, 390, 200, 30);
		add(Occupation);
		
		String valOccupation[] = {"Salaried","Self Employed","Bussiness","Student","Retired","Other"};
		occupation = new JComboBox(valOccupation);
		occupation.setBounds(300, 390, 400, 30);
		add(occupation);
		
		JLabel pan = new JLabel("PAN No :");
		pan.setFont(new Font("Raleway", Font.BOLD, 20));
		pan.setBounds(100, 440, 200, 30);
		add(pan);
		
		panTextField = new JTextField();
		panTextField.setBounds(300, 440, 400, 30);
		panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		add(panTextField);
		
		JLabel addhar = new JLabel("Addhar No :");
		addhar.setFont(new Font("Raleway", Font.BOLD, 20));
		addhar.setBounds(100, 490, 200, 30);
		add(addhar);
		
		addharTextField = new JTextField();
		addharTextField.setBounds(300, 490, 400, 30);
		addharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		add(addharTextField);

		JLabel citizen = new JLabel("Senior Citizen :");
		citizen.setFont(new Font("Raleway", Font.BOLD, 20));
		citizen.setBounds(100, 540, 200, 30);
		add(citizen);
		
		syes = new JRadioButton("Yes");
		syes.setBounds(300, 540, 100, 30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(450,540,100, 30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup maritelgroup = new ButtonGroup();
		maritelgroup.add(syes);
		maritelgroup.add(sno);
		
		JLabel acc = new JLabel("Existing Account :");
		acc.setFont(new Font("Raleway", Font.BOLD, 20));
		acc.setBounds(100, 590, 200, 30);
		add(acc);
		
		ayes = new JRadioButton("Yes");
		ayes.setBounds(300, 590, 100, 30);
		ayes.setBackground(Color.WHITE);
		add(ayes);
		
		ano = new JRadioButton("No");
		ano.setBounds(450,590,100, 30);
		ano.setBackground(Color.WHITE);
		add(ano);
		
		ButtonGroup Accgroup = new ButtonGroup();
		Accgroup.add(ayes);
		Accgroup.add(ano);
		

		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
	    next.setBounds(620, 660, 80, 30);
	    next.addActionListener(this);
	    add(next);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String religen = (String) religion.getSelectedItem();
		String category = (String) Category.getSelectedItem();
		String Income = (String) income.getSelectedItem();
		String qualification = (String) education.getSelectedItem();
		String Occupation = (String) occupation.getSelectedItem();
		String citizen = null;
		if (syes.isSelected()) {
			citizen = "Yes";
		}else if (sno.isSelected()) {
			citizen = "No";
		}
		String pan = panTextField.getText();
		String acc = null;
		if (ayes.isSelected()) {
			acc = "Yes";
		}else if (ano.isSelected()) {
			acc = "no";
		}
		
		String addhar = addharTextField.getText();
		
		
		try {
			
				Conn c = new Conn();
				String query = "insert into signuptwo values('"+formno+"','"+religen+"','"+category+"','"+Income+"','"+qualification+"','"+Occupation+"','"+citizen+"','"+pan+"','"+acc+"','"+addhar+"')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new SignupThree(formno).setVisible(true);
				
		} catch (Exception e) {
			System.out.println(e);
		} 
		
	}
	
	public static void main(String[] args) {
		new SignupTwo("");

	}

}
