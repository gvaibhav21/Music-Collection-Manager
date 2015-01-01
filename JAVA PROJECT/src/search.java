import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


@SuppressWarnings({ "serial", "unused" })
public class search extends JFrame {

	private JPanel contentPane;
	static int count;
	static song[] songs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					member m=new member();
					search frame = new search(m);
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
	public search(final member m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchForA = new JLabel("Search for a song:");
		lblSearchForA.setForeground(Color.BLUE);
		lblSearchForA.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblSearchForA.setBounds(115, 11, 278, 53);
		contentPane.add(lblSearchForA);
		
		JLabel lblNoSongFound = new JLabel("");
		lblNoSongFound.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNoSongFound.setForeground(Color.RED);
		lblNoSongFound.setBounds(299, 27, 182, 21);
		contentPane.add(lblNoSongFound);
		
		JButton btnNewButton = new JButton("Search by Song Name");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				searchEnter s1=new searchEnter(m,1);
				s1.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton.setBounds(22, 89, 207, 47);
		contentPane.add(btnNewButton);
		
		JButton btnSearchByYear = new JButton("Search by Year of Release");
		btnSearchByYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchEnter s1=new searchEnter(m,3);
				s1.setVisible(true);
				dispose();
			}
		});
		btnSearchByYear.setForeground(Color.BLUE);
		btnSearchByYear.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSearchByYear.setBounds(22, 168, 207, 47);
		contentPane.add(btnSearchByYear);
		
		JButton btnSearchByArtist = new JButton("Search by Artist");
		btnSearchByArtist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchEnter s1=new searchEnter(m,2);
				s1.setVisible(true);
				dispose();
			}
		});
		btnSearchByArtist.setForeground(Color.BLUE);
		btnSearchByArtist.setFont(new Font("Calibri", Font.BOLD, 18));
		btnSearchByArtist.setBounds(274, 89, 207, 47);
		contentPane.add(btnSearchByArtist);
		
		JButton btnSearchByAlbum = new JButton("Search by Album");
		btnSearchByAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchEnter s1=new searchEnter(m,4);
				s1.setVisible(true);
				dispose();
			}
		});
		btnSearchByAlbum.setForeground(Color.BLUE);
		btnSearchByAlbum.setFont(new Font("Calibri", Font.BOLD, 18));
		btnSearchByAlbum.setBounds(274, 167, 207, 47);
		contentPane.add(btnSearchByAlbum);
		
		JButton btnSearchByGenre = new JButton("Search by Genre");
		btnSearchByGenre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchEnter s1=new searchEnter(m,5);
				s1.setVisible(true);
				dispose();
			}
		});
		btnSearchByGenre.setForeground(Color.BLUE);
		btnSearchByGenre.setFont(new Font("Calibri", Font.BOLD, 18));
		btnSearchByGenre.setBounds(22, 258, 207, 47);
		contentPane.add(btnSearchByGenre);
		
		JButton btnSearchByPersonal = new JButton("Search by Personal Rating");
		btnSearchByPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchEnter s1=new searchEnter(m,6);
				s1.setVisible(true);
				dispose();
			}
		});
		btnSearchByPersonal.setForeground(Color.BLUE);
		btnSearchByPersonal.setFont(new Font("Calibri", Font.BOLD, 15));
		btnSearchByPersonal.setBounds(274, 259, 207, 47);
		contentPane.add(btnSearchByPersonal);
		
		JButton button_7 = new JButton("<< Back");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu Menu=new menu(m);
				Menu.setVisible(true);
				dispose();
			}
		});
		button_7.setForeground(Color.BLACK);
		button_7.setFont(new Font("Calibri", Font.PLAIN, 16));
		button_7.setBounds(10, 11, 83, 47);
		contentPane.add(button_7);
		
		
	}
}
