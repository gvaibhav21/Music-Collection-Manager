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
public class PlistDeleted extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					member m=new member();
					PlistDeleted frame = new PlistDeleted(m);
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
	public PlistDeleted(final member m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 191);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlaylistDeleted = new JLabel("Playlist Deleted");
		lblPlaylistDeleted.setFont(new Font("Calibri", Font.BOLD, 18));
		lblPlaylistDeleted.setBounds(119, 11, 264, 50);
		contentPane.add(lblPlaylistDeleted);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playlists pl=new playlists(m);
				pl.setVisible(true);
				dispose();
				
			}
		});
		btnOk.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnOk.setForeground(Color.BLUE);
		btnOk.setBounds(132, 72, 103, 39);
		contentPane.add(btnOk);
	}
}
