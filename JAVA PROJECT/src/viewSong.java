import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JLabel;


@SuppressWarnings({ "serial", "unused" })
public class viewSong extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					song s=new song();
					member m=new member();
					viewSong frame = new viewSong(s,m,1);
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
	public viewSong(final song s,final member m,final int menuType) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("<< Back");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(menuType==0)
				{
					allSongs all=new allSongs(m,0);
					all.setVisible(true);
					dispose();
				}
				else if(menuType==8)
				{
					playlists play=new playlists(m);
					play.setVisible(true);
					dispose();
				}
				else if(menuType==9)
				{
					menu men=new menu(m);
					men.setVisible(true);
					dispose();
				}
				else
				{
					searchEnter s1=new searchEnter(m,menuType);
					s1.setVisible(true);
					dispose();
				}		

		}
	});
		btnNewButton.setBounds(10, 11, 106, 37);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Song Name: "+s.getName());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 59, 194, 30);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("Song Id: "+s.getId());
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(230, 59, 194, 30);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Release Year: "+s.getYear());
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 100, 194, 30);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Album: "+s.getAlbum());
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(230, 100, 194, 30);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Artist: "+s.getArtist());
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(10, 141, 194, 30);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Genre : "+s.getGenre());
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(230, 141, 194, 30);
		contentPane.add(label_4);

	//	JLabel label_5 = new JLabel("Search Frequency: "+m.getSearchFreq(s.getId()));
//		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
	//	label_5.setBounds(10, 182, 194, 30);
//		contentPane.add(label_5);

		JLabel label_6 = new JLabel("Personal Rating: "+m.getRating(s.getId()));
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(230, 182, 194, 30);
		contentPane.add(label_6);

		JButton btnNewButton_1 = new JButton("Set as favourite/Rate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rating d=new rating(m,s);
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(138, 209, 200, 37);
		contentPane.add(btnNewButton_1);
}

}
