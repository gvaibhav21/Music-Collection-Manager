import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings({ "serial", "unused" })
public class adminPreviligdes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					member m=new member();
					adminPreviligdes frame = new adminPreviligdes(m);
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
	public adminPreviligdes(final member m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminPrevilidges = new JLabel("Admin Previlidges");
		lblAdminPrevilidges.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAdminPrevilidges.setBounds(148, 23, 197, 47);
		contentPane.add(lblAdminPrevilidges);
		
		JButton button = new JButton("<< Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu men=new menu(m);
				men.setVisible(true);
				dispose();
			}
		});
		button.setForeground(Color.BLUE);
		button.setFont(new Font("Calibri", Font.PLAIN, 18));
		button.setBounds(10, 23, 102, 47);
		contentPane.add(button);
		
		JButton btnAddANew = new JButton("Add a new song");
		btnAddANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newSong ns=new newSong(m);
				ns.setVisible(true);
				dispose();
				
			}
		});
		btnAddANew.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnAddANew.setBounds(148, 101, 154, 47);
		contentPane.add(btnAddANew);
		
		JButton btnDeleteASong = new JButton("delete a song");
		btnDeleteASong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allSongs ds=new allSongs(m,1);
				ds.setVisible(true);
				dispose();
				
			}
		});
		btnDeleteASong.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnDeleteASong.setBounds(339, 101, 142, 47);
		contentPane.add(btnDeleteASong);
	}

}
