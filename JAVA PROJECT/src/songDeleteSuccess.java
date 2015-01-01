import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings({ "serial", "unused" })
public class songDeleteSuccess extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					member m=new member();
					songDeleteSuccess frame = new songDeleteSuccess(m);
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
	public songDeleteSuccess(final member m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSongDeleted = new JLabel("Song deleted.");
		lblSongDeleted.setFont(new Font("Calibri", Font.PLAIN, 21));
		lblSongDeleted.setForeground(Color.BLUE);
		lblSongDeleted.setBounds(105, 55, 190, 61);
		contentPane.add(lblSongDeleted);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			allSongs all=new allSongs(m,1);
			all.setVisible(true);
			dispose();
			}
		});
		btnOk.setBounds(92, 145, 133, 42);
		contentPane.add(btnOk);
	}

}
