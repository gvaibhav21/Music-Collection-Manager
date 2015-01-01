import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


@SuppressWarnings({ "serial", "unused" })
public class songSuccess extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				member m=new member();
					songSuccess frame = new songSuccess(m);
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
	public songSuccess(final member m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 269, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewSongAdded = new JLabel("New Song added.");
		lblNewSongAdded.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewSongAdded.setBounds(63, 48, 267, 53);
		contentPane.add(lblNewSongAdded);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu men=new menu(m);
				men.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(63, 128, 147, 45);
		contentPane.add(btnNewButton);
	}

}
