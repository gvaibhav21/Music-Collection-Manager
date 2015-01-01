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
public class searchEnter extends JFrame {
	static JFormattedTextField formattedTextField = new JFormattedTextField();
	static JLabel lblSongDoesNot = new JLabel();
	static int count;
	static song s=null;
	static song[] songs=new song[200];
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					member m=new member();
					searchEnter frame = new searchEnter(m,1);
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
	public searchEnter(final member m,final int menuType) {
		lblSongDoesNot.setText("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSearchBySong = new JLabel("Search:");
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
				String input=null;
				if(menuType!=7)
					input=formattedTextField.getText();
				
				try{
				try
				{

					count=0;
					FileInputStream f=new FileInputStream("songs.ser");
					ObjectInputStream ois = new ObjectInputStream(f);

					while(f.available()>0)
					{
						s=(song)ois.readObject(); 
						switch(menuType)
						{
							case 1:
							if(s.getName().equalsIgnoreCase(input))
							{
								count=1;
								songs[0]=s;
							}
							break;
							
							case 2:
							if(s.getArtist().equalsIgnoreCase(input))
							{
								songs[count++]=s;
							}
							break;
							
							case 3:
							if(s.getYear()==Integer.parseInt(input))
							{
								songs[count++]=s;
							}
							break;
							
							case 4:
							if(s.getAlbum().equalsIgnoreCase(input))
							{
								songs[count++]=s;
							}
							break;
							
							case 5:
							if(s.getGenre().equalsIgnoreCase(input))
							{
								songs[count++]=s;
							}
							break;
							
							case 6:
							if(m.getRating(s.getId())==Integer.parseInt(input))
							{
								songs[count++]=s;
							}
							break;
							case 7:
							if(s.getYear()==2014)
							{
									songs[count++]=s;
							}
						}

					}
					ois.close();
				}catch(Exception e1){}
				if(count==0)
				{
					throw new NoResultException();
				}
				else
				{
					searchDisplay s1=new searchDisplay(m,songs,count,menuType);
					s1.setVisible(true);
					dispose();
				}
				}catch(NoResultException e2){lblSongDoesNot.setText("No Results are available for your query.");}
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
