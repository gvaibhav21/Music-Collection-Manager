import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


@SuppressWarnings({ "serial", "unused" })
public class newAccount extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	static JFormattedTextField formattedTextField = new JFormattedTextField();
	static JFormattedTextField formattedTextField_1 = new JFormattedTextField();
	
	static JLabel lblNewLabel = new JLabel("");

	/**
	 * Launch the application.
	 */
	
	public static void save(member m)
	{
		try{
			FileInputStream f=new FileInputStream("members.ser");
			ObjectInputStream ois = new ObjectInputStream(f);
			member[] members=new member[200];
			int count=0;
			while(f.available()>0)
			{
				member m1=(member)ois.readObject();
					members[count++]=new member();
					members[count-1].copy(m1);
			}
			members[count++]=new member();
			members[count-1].copy(m);
			
			ois.close();
			
			FileOutputStream o1=new FileOutputStream("members.ser");
			ObjectOutputStream oos1 = new ObjectOutputStream(o1);
			for(int i=0;i<count;++i)
				oos1.writeObject(members[i]);

			oos1.close();
			
			
			/*f.close();
			o.close();
			File old=new File("members.ser");
			old.delete();
			File newFile=new File("temp.ser");
			newFile.renameTo(new File("members.ser"));*/
			
		}catch(Exception e1){}
	}

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newAccount frame = new newAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public newAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewAccount = new JLabel("New Account:");
		lblNewAccount.setForeground(Color.BLUE);
		lblNewAccount.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewAccount.setBounds(134, -1, 229, 63);
		contentPane.add(lblNewAccount);
		
		JButton button = new JButton("<< Back");
		button.setForeground(Color.BLUE);
		button.setFont(new Font("Calibri", Font.BOLD, 18));
		button.setBounds(6, 11, 108, 40);
		contentPane.add(button);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setBounds(71, 82, 70, 31);
		contentPane.add(lblUsername);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblName.setBounds(99, 124, 42, 31);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPassword.setBounds(75, 166, 66, 31);
		contentPane.add(lblPassword);
		
		
		formattedTextField.setBounds(151, 87, 147, 20);
		contentPane.add(formattedTextField);
		
		
		formattedTextField_1.setBounds(151, 129, 147, 20);
		contentPane.add(formattedTextField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(151, 171, 147, 20);
		contentPane.add(passwordField);
		
		
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(151, 294, 147, 14);
		contentPane.add(lblNewLabel);
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				member m=new member();
				boolean flag=false;
				String name=formattedTextField.getText();
				try
				{
					FileInputStream f=new FileInputStream("members.ser");
					ObjectInputStream ois = new ObjectInputStream(f);
					while(f.available()>0)
					{
						member m1=(member)ois.readObject();
						if(m1.getUsername().equals(name))
						{
							flag=true;
							lblNewLabel.setText("Username already Exists.");
						}
					}
					if(!flag)
					{
						String pass1="";
						String pass2="";
						for(int i=0;i<passwordField.getPassword().length;++i)
							pass1=pass1+passwordField.getPassword()[i];
						for(int i=0;i<passwordField_1.getPassword().length;++i)
							pass2=pass2+passwordField_1.getPassword()[i];
						if(!pass1.equals(pass2))
								lblNewLabel.setText("Passwords do not match");
						else
						{
							
							m.setUsername(formattedTextField.getText());
							m.setName(formattedTextField_1.getText());
							m.setPassword(pass1);
							save(m);
						accountCreated acc=new accountCreated();
						acc.setVisible(true);
						dispose();
						}
					}
					ois.close();
				}catch(Exception e1){}
			}
		});
		btnSubmit.setFont(new Font("Calibri", Font.BOLD, 18));
		btnSubmit.setForeground(Color.BLUE);
		btnSubmit.setBounds(151, 250, 108, 31);
		contentPane.add(btnSubmit);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setForeground(Color.BLACK);
		lblConfirmPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblConfirmPassword.setBounds(17, 204, 124, 31);
		contentPane.add(lblConfirmPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(151, 209, 147, 20);
		contentPane.add(passwordField_1);
		
		
	}
}
