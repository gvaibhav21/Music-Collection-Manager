import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


@SuppressWarnings({ "serial", "unused" })
public class rating extends JFrame {

	private JPanel contentPane;
	static JFormattedTextField formattedTextField = new JFormattedTextField();
	static JLabel lblNewLabel = new JLabel("");
	

	/**
	 * Launch the application.
	 */
	
	
	public static void save(member m)
	{
		try{
			FileInputStream f=new FileInputStream("members.ser");
			ObjectInputStream ois = new ObjectInputStream(f);
			FileOutputStream o=new FileOutputStream("temp.ser");
			ObjectOutputStream oos = new ObjectOutputStream(o);
			member[] members=new member[200];
			int count=0;
			while(f.available()>0)
			{
				member m1=(member)ois.readObject();
				if(m1.getUsername().equals(m.getUsername()))
				{
					members[count++]=new member();
					members[count-1].copy(m);
				}
				else
				{
					members[count++]=new member();
					members[count-1].copy(m1);
				}
			}
			ois.close();
			oos.close();
			
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
					member m=new member();
					song s=new song();
					rating frame = new rating(m,s);
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
	public rating(final member m,final song s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		formattedTextField.setBounds(60, 75, 150, 20);
		contentPane.add(formattedTextField);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Provide Rating");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num=Integer.parseInt(formattedTextField.getText());
				try{
				if(num>5)
				{
					throw new InvalidRatingException();
					
				}
				else
				{
					m.setRating(s.getId(),num);
					save(m);
					ratingAdded r=new ratingAdded(m,s);
					r.setVisible(true);
					dispose();
				}
				}catch(InvalidRatingException e1)
				{
					lblNewLabel.setText("Enter an Integer b/w 1 to 5");
				}
					
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(241, 63, 160, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add to Favourites");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!m.isFav(s.getId()))
				{
					m.setFavourite(s.getId());
					save(m);
					favAdded fav=new favAdded(m,s);
					fav.setVisible(true);
					dispose();
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(145, 157, 160, 44);
		contentPane.add(btnNewButton_1);
		
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOr.setBounds(214, 126, 40, 20);
		contentPane.add(lblOr);
		
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(60, 101, 132, 26);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("<< Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu men=new menu(m);
				men.setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("Calibri", Font.PLAIN, 17));
		button.setForeground(Color.BLUE);
		button.setBounds(10, 11, 115, 41);
		contentPane.add(button);
	}

}
