import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


@SuppressWarnings({ "serial", "unused" })
public class nameSearch extends JFrame {
	static JFormattedTextField formattedTextField = new JFormattedTextField();
	static JLabel lblSongDoesNot = new JLabel();
	static int count;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					member m=new member();
					nameSearch frame = new nameSearch(m);
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
	public nameSearch(final member m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchBySong = new JLabel("Search by Song Name:");
		lblSearchBySong.setForeground(Color.BLUE);
		lblSearchBySong.setFont(new Font("Calibri", Font.BOLD, 18));
		lblSearchBySong.setBounds(20, 60, 185, 46);
		contentPane.add(lblSearchBySong);
		
		
		formattedTextField.setBounds(222, 71, 199, 26);
		contentPane.add(formattedTextField);
		
		JButton btnGo = new JButton("Go");
		
		lblSongDoesNot.setForeground(Color.RED);
		lblSongDoesNot.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblSongDoesNot.setBounds(20, 117, 319, 33);
		contentPane.add(lblSongDoesNot);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=formattedTextField.getText();
				song s = null;
				try
				{
					
					count=0;
					FileInputStream f=new FileInputStream("songs.ser");
					ObjectInputStream ois = new ObjectInputStream(f);

					while(f.available()>0)
					{
						s=(song)ois.readObject() ; 
						if(s.getName().equalsIgnoreCase(name))
						{
							count=1;
							break;
						}
						
					}
					ois.close();
				}catch(Exception e1){}
				if(count==0)
				{
					lblSongDoesNot.setText("Song Does not exist in Database.");
				}
				else
				{
					viewSong v=new viewSong(s,m,1);
					v.setVisible(true);;
					dispose();
				}
			}
		});
		btnGo.setFont(new Font("Calibri", Font.BOLD, 18));
		btnGo.setForeground(Color.BLUE);
		btnGo.setBounds(431, 65, 61, 36);
		contentPane.add(btnGo);
		
		JButton btnNewButton = new JButton("<< Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search S=new search(m);
				S.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton.setBounds(10, 11, 114, 38);
		contentPane.add(btnNewButton);
		
		
	}

}
