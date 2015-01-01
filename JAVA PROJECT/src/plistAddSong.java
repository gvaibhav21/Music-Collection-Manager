import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JFormattedTextField;


@SuppressWarnings({ "serial", "unused" })
public class plistAddSong extends JFrame {
	static JFormattedTextField formattedTextField = new JFormattedTextField();
	private JPanel contentPane;


	JLabel label = new JLabel("");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					member m=new member();
					plistAddSong frame = new plistAddSong(m);
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
	public plistAddSong(final member m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("<< Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu Menu=new menu(m);
				Menu.setVisible(true);
				dispose();

			}
		});
		button.setFont(new Font("Calibri", Font.BOLD, 18));
		button.setBounds(10, 11, 162, 44);
		contentPane.add(button);

		JLabel lblNameOfThe = new JLabel("Name of the song to be added:");
		lblNameOfThe.setForeground(Color.BLUE);
		lblNameOfThe.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNameOfThe.setBounds(128, 104, 247, 50);
		contentPane.add(lblNameOfThe);


		formattedTextField.setBounds(377, 111, 214, 38);
		contentPane.add(formattedTextField);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setForeground(Color.RED);
		
		label.setBounds(43, 158, 289, 53);
		contentPane.add(label);

		JButton btnAdd = new JButton("Add Song");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=formattedTextField.getText();
				try
				{
				FileInputStream f=new FileInputStream("songs.ser");
				ObjectInputStream ois = new ObjectInputStream(f);
				boolean flag=false;
				while(f.available()>0)
				{
	
					song s=(song)ois.readObject() ; 
					if(s.getName().equalsIgnoreCase(name))
					{
						flag=true;
						m.getPlist(m.getPlistcounter()-1).addSong(s);
						songAdded songadded=new songAdded(m,s,m.getPlist(m.getPlistcounter()-1));
						songadded.setVisible(true);
						dispose();
						break;
					}
					
					songAdded added=new songAdded(m,s,m.getPlist(m.getPlistcounter()-1));
					
				}
				ois.close();
				if(flag==false)
				{
					throw new SongNotFoundException();
				}
				}catch(SongNotFoundException e1){label.setText("Song does not exist.");	
				}catch(Exception e1){}
				
			}
		});
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnAdd.setForeground(Color.BLUE);
		btnAdd.setBounds(377, 173, 107, 38);
		contentPane.add(btnAdd);

		
	}
}
