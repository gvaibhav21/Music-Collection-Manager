import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


@SuppressWarnings({ "serial", "unused" })
public class songAdded extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	@SuppressWarnings("resource")
	/*public static void save()
	{
		try
		{
			FileInputStream f=new FileInputStream("songs.ser");
			ObjectInputStream ois = new ObjectInputStream(f);
			
		}catch(Exception e){}
		
	}*/
	public static void save(member m)
	{
		try{
			FileInputStream f=new FileInputStream("members.ser");
			ObjectInputStream ois = new ObjectInputStream(f);
			FileOutputStream o=new FileOutputStream("temp.ser");
			ObjectOutputStream oos = new ObjectOutputStream(o);
			member[] members=new member[200];
			int count=0;
			while(f.available()>0)
			{
				member m1=(member)ois.readObject();
				if(m1.getUsername().equals(m.getUsername()))
				{
					members[count++]=new member();
					members[count-1].copy(m);
				}
				else
				{
					members[count++]=new member();
					members[count-1].copy(m1);
				}
			}
			ois.close();
			oos.close();
			
			FileOutputStream o1=new FileOutputStream("members.ser");
			ObjectOutputStream oos1 = new ObjectOutputStream(o1);
			for(int i=0;i<count;++i)
				oos1.writeObject(members[i]);

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
					song s=new song();
					playlist p=new playlist();
					member m=new member();
					songAdded frame = new songAdded(m,s,p);
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
	public songAdded(final member m,song s,playlist p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTheSong = new JLabel("The Song "+s.getName()+" has been added to your playlist: "+p.getName());
		lblTheSong.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblTheSong.setForeground(Color.BLACK);
		lblTheSong.setBounds(10, 42, 479, 56);
		contentPane.add(lblTheSong);
		
		JButton btnNewButton = new JButton("Add another song");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plistAddSong adds=new plistAddSong(m);
				adds.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(63, 141, 176, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblOr = new JLabel("or");
		lblOr.setFont(new Font("Calibri", Font.BOLD, 18));
		lblOr.setForeground(Color.BLACK);
		lblOr.setBounds(258, 141, 43, 31);
		contentPane.add(lblOr);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save(m);
				menu Menu=new menu(m);
				Menu.setVisible(true);
				dispose();
			}
		});
		btnFinish.setForeground(Color.BLUE);
		btnFinish.setFont(new Font("Calibri", Font.BOLD, 18));
		btnFinish.setBounds(301, 141, 176, 31);
		contentPane.add(btnFinish);
	}

}
