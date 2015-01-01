
import java.io.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JScrollPane;

@SuppressWarnings("unused")
public class login {

	private JFrame frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
		frame.setVisible(true);
			
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 452, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterUsernameAnd = new JLabel("Enter Username and Password:");
		lblEnterUsernameAnd.setBounds(29, 28, 203, 31);
		lblEnterUsernameAnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(lblEnterUsernameAnd);
		
		final JFormattedTextField frmtdtxtfldUsername = new JFormattedTextField();
		frmtdtxtfldUsername.setBounds(125, 98, 162, 20);
		frmtdtxtfldUsername.setForeground(Color.BLACK);
		frame.getContentPane().add(frmtdtxtfldUsername);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(29, 88, 96, 31);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(29, 130, 96, 31);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(lblPassword);
		passwordField = new JPasswordField();
		passwordField.setBounds(125, 137, 162, 20);
		frame.getContentPane().add(passwordField);
		
		final JLabel label = new JLabel("");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(125, 223, 214, 22);
		frame.getContentPane().add(label);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(125, 189, 89, 23);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=frmtdtxtfldUsername.getText();
				char[] password1=passwordField.getPassword();
				String password="";
				for(int i=0;i<password1.length;++i)
				 password=password+password1[i];
				try{
				FileInputStream f = new FileInputStream("members.ser");
				@SuppressWarnings("resource")
				ObjectInputStream ois = new ObjectInputStream(f);
				boolean flag=false;
				member m;
				while(f.available()>0)
				{	
					m=new member();
					m=(member)ois.readObject(); 
					if(username.equals(m.getUsername()))
					{
						if(password.equals(m.getPassword()))
						{
							frame.dispose();
							menu screen=new menu(m);
							screen.setVisible(true);
							flag=true;
						}
					}
				}
				if(flag==false)
					throw new NoMatchException();
					//label.setText("invalid username or password.");
				}catch(NoMatchException ex){label.setText("Invalid username or password.");
				}catch(Exception ex){ex.printStackTrace();}
			}
		});
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblOr = new JLabel("or");
		lblOr.setBounds(231, 181, 27, 31);
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(lblOr);
		JButton btnCreateNewAccount = new JButton("Create new account");
		btnCreateNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newAccount acc=new newAccount();
				acc.setVisible(true);
				frame.dispose();
				
			}
		});
		btnCreateNewAccount.setBounds(268, 189, 145, 23);
		frame.getContentPane().add(btnCreateNewAccount);
	}
}
