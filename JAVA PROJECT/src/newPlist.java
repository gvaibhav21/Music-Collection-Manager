import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings({ "serial", "unused" })
public class newPlist extends JFrame {
	static JFormattedTextField formattedTextField = new JFormattedTextField();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					member m=new member();
					newPlist frame = new newPlist(m);
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
	public newPlist(final member m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("<< Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu Menu=new menu(m);
				Menu.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton.setBounds(10, 11, 130, 42);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Name of New Playlist:");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel.setBounds(94, 82, 181, 42);
		contentPane.add(lblNewLabel);
		
		
		formattedTextField.setBounds(285, 94, 181, 20);
		contentPane.add(formattedTextField);
		
		JButton btnNext = new JButton("Next >>");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=formattedTextField.getText();
				playlist p=new playlist();
				m.addPlist(p);
				m.getPlist(m.getPlistcounter()-1).setName(name);
				plistAddSong plistadd=new plistAddSong(m);
				plistadd.setVisible(true);
				dispose();
			}
		});
		btnNext.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNext.setBounds(285, 141, 157, 42);
		contentPane.add(btnNext);
	}

}
