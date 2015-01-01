import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.awt.Color;

@SuppressWarnings({ "unused", "serial" })
public class menu extends JFrame {
	static song[] songs=new song[200];
	static int count=0;
	static JLabel lblNoFavouritesTo = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					member m=new member();
					menu frame = new menu(m);
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
	public menu(final member m)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 301);
		getContentPane().setLayout(null);
		String type;
		if(m.getType()==false)
		{
			type="user";
		}
		else
		{
			type="admin";
		}
		JLabel label = new JLabel("hello "+type+" "+m.getName());
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));

		label.setBounds(22, 11, 362, 37);
		getContentPane().add(label);

		JButton btnNewButton = new JButton("View All Songs");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allSongs all=new allSongs(m,0);
				dispose();
				all.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(22, 59, 191, 31);
		getContentPane().add(btnNewButton);

		JButton btnSearchForA = new JButton("Search for a song");
		btnSearchForA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search S=new search(m);
				S.setVisible(true);
				dispose();
			}
		});
		btnSearchForA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearchForA.setBounds(22, 115, 191, 31);
		getContentPane().add(btnSearchForA);

		JButton btnPlaylists = new JButton("My Playlists");
		btnPlaylists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			playlists pl=new playlists(m);
			pl.setVisible(true);
			dispose();
			}
		});
		btnPlaylists.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPlaylists.setBounds(252, 59, 191, 31);
		getContentPane().add(btnPlaylists);

		
		
		lblNoFavouritesTo.setForeground(Color.RED);
		lblNoFavouritesTo.setBounds(22, 212, 153, 19);
		getContentPane().add(lblNoFavouritesTo);
		
		
		JButton btnMyFavourites = new JButton("My Favourites");
		btnMyFavourites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{	
					FileInputStream f=new FileInputStream("songs.ser");
					ObjectInputStream ois = new ObjectInputStream(f);

					while(f.available()>0)
					{
						song s=(song)ois.readObject() ; 
						if(m.isFav(s.getId()))
						songs[count++]=s;
					}
					ois.close();
				}catch(Exception e1){}	
				if(count!=0)
				{
					Object[][] ob=new Object[count][8];
					for(int i=0;i<count;++i)
					{
						ob[i][0]=songs[i].getId();
						ob[i][1]=songs[i].getName();
						ob[i][2]=songs[i].getArtist();
						ob[i][3]=songs[i].getYear();
						ob[i][4]=songs[i].getAlbum();
						ob[i][5]=songs[i].getGenre();
						ob[i][6]=m.getRating(songs[i].getId());
						if(m.isFav(songs[i].getId()))
							ob[i][7]="Yes";
						else
							ob[i][7]="No";
					}
					searchDisplay d=new searchDisplay(m,songs,count,9);
					d.setVisible(true);
					dispose();
				}
				else
				{
					lblNoFavouritesTo.setText("No Favourites to show.");
				}
			}
		});
		btnMyFavourites.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMyFavourites.setBounds(22, 175, 191, 31);
		getContentPane().add(btnMyFavourites);

		JButton btnPublicPlaylist = new JButton("Create new Playlist");
		btnPublicPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPlist newp=new newPlist(m);
				newp.setVisible(true);
				dispose();
			}
		});
		btnPublicPlaylist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPublicPlaylist.setBounds(252, 115, 191, 31);
		getContentPane().add(btnPublicPlaylist);

		JButton btnEditAccountDetails = new JButton("Logout");
		btnEditAccountDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login l=new login();
				dispose();
				//l.setVisible(true);
				
			}
		});
		btnEditAccountDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditAccountDetails.setBounds(252, 175, 191, 31);
		getContentPane().add(btnEditAccountDetails);
		
		

		if(m.getType())
		{	
			JButton btnAdminPrevelidges = new JButton("Admin Privileges");
			btnAdminPrevelidges.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					adminPreviligdes ad=new adminPreviligdes(m);
					ad.setVisible(true);
					dispose();
					//l.setVisible(true);
					
				}
			});
			btnAdminPrevelidges.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAdminPrevelidges.setBounds(132, 215, 191, 31);
			getContentPane().add(btnAdminPrevelidges);
		}
		/*if(!m.getType())
		{
			JButton btnProvideFeedback = new JButton("provide feedback");
			btnProvideFeedback.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnProvideFeedback.setBounds(346, 230, 119, 20);
			getContentPane().add(btnProvideFeedback);
		}*/
	}
}
