import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFormattedTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;


@SuppressWarnings({ "serial", "unused" })
public class newSong extends JFrame {
	JFormattedTextField formattedTextField = new JFormattedTextField();
	JFormattedTextField formattedTextField_1 = new JFormattedTextField();
	JFormattedTextField formattedTextField_2 = new JFormattedTextField();
	JFormattedTextField formattedTextField_3 = new JFormattedTextField();
	JFormattedTextField formattedTextField_4 = new JFormattedTextField();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	
	public static void save(song s)
	{
		try{
			FileInputStream f=new FileInputStream("songs.ser");
			ObjectInputStream ois = new ObjectInputStream(f);
			song[] songs=new song[200];
			int count=0;
			while(f.available()>0)
			{
				song s1=(song)ois.readObject();
				songs[count++]=new song(s1);
					
				
			}
			songs[count++]=new song(s);
			ois.close();
			
			
			FileOutputStream o1=new FileOutputStream("songs.ser");
			ObjectOutputStream oos1 = new ObjectOutputStream(o1);
			for(int i=0;i<count;++i)
				oos1.writeObject(songs[i]);

			oos1.close();
			
			
			/*f.close();
			o.close();
			File old=new File("members.ser");
			old.delete();
			File newFile=new File("temp.ser");
			newFile.renameTo(new File("members.ser"));*/
			
		}catch(Exception e1){}
	}

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					member m=new member();
					newSong frame = new newSong(m);
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
	public newSong(final member m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("<< Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(27, 28, 114, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblName.setBounds(135, 96, 49, 35);
		contentPane.add(lblName);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblYear.setBounds(145, 139, 39, 35);
		contentPane.add(lblYear);
		
		JLabel lblAlbum = new JLabel("Album:");
		lblAlbum.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAlbum.setBounds(133, 185, 51, 35);
		contentPane.add(lblAlbum);
		
		JLabel lblArtist = new JLabel("Artist:");
		lblArtist.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblArtist.setBounds(135, 231, 51, 35);
		contentPane.add(lblArtist);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblGenre.setBounds(133, 279, 51, 35);
		contentPane.add(lblGenre);
		
		
		formattedTextField.setBounds(221, 104, 163, 20);
		contentPane.add(formattedTextField);
		
		formattedTextField_1.setBounds(221, 147, 163, 20);
		contentPane.add(formattedTextField_1);
		
		formattedTextField_2.setBounds(221, 193, 163, 20);
		contentPane.add(formattedTextField_2);
		
		formattedTextField_3.setBounds(221, 239, 163, 20);
		contentPane.add(formattedTextField_3);
		
		formattedTextField_4.setBounds(221, 287, 163, 20);
		contentPane.add(formattedTextField_4);
		try{
		FileReader inputFil = new FileReader("counter.txt");
		BufferedReader in = new BufferedReader(inputFil);
		int counter=Integer.parseInt(in.readLine());
		in.close();
		}catch(Exception e1){}
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				song Song = new song();
				Song.setName(formattedTextField.getText());
				Song.setYear(Integer.parseInt(formattedTextField_1.getText()));
				Song.setAlbum(formattedTextField_2.getText());
				Song.setArtist(formattedTextField_3.getText());
				Song.setGenre(formattedTextField_4.getText());
				try{
					FileReader inputFil = new FileReader("counter.txt");
					BufferedReader in = new BufferedReader(inputFil);
					int counter=Integer.parseInt(in.readLine());
					Song.setId(counter+1);
					++counter;
					in.close();
					Writer wr = new FileWriter("counter.txt");
					wr.write(Integer.toString(counter));
					wr.close();
				}catch(Exception e1){}
				save(Song);
				songSuccess ss=new songSuccess(m);
				ss.setVisible(true);
				dispose();
			}
		});
		btnSubmit.setForeground(Color.BLUE);
		btnSubmit.setBounds(221, 318, 114, 49);
		contentPane.add(btnSubmit);
		
		
	}

}
