import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JScrollPane;


@SuppressWarnings({ "unused", "serial" })
public class playlists extends JFrame {
	static JFormattedTextField formattedTextField = new JFormattedTextField();
	static JFormattedTextField formattedTextField_1 = new JFormattedTextField();
	static JLabel lblKindltEnterSr = new JLabel("");
	static JLabel label_1 = new JLabel("");
	
	
	
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
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
					member m=new member();
					playlists frame = new playlists(m);
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
	public playlists(final member m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("<< Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu m1=new menu(m);
				m1.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(23, 24, 120, 47);
		contentPane.add(btnNewButton);
	
		label_1.setBounds(72, 82, 263, 20);
		contentPane.add(label_1);
		
		
		
		JLabel lblMyPlaylists = new JLabel("My Playlists:");
		lblMyPlaylists.setFont(new Font("Calibri", Font.BOLD, 20));
		lblMyPlaylists.setForeground(Color.BLUE);
		lblMyPlaylists.setBounds(174, 24, 120, 47);
		contentPane.add(lblMyPlaylists);
		
		JLabel lblEnterPlaylistSr = new JLabel("Enter playlist's Sr. No. :");
		lblEnterPlaylistSr.setFont(new Font("Calibri", Font.BOLD, 18));
		lblEnterPlaylistSr.setBounds(304, 24, 180, 47);
		contentPane.add(lblEnterPlaylistSr);
		
		
		formattedTextField.setBounds(494, 38, 158, 20);
		contentPane.add(formattedTextField);
		
		JButton btnNewButton_1 = new JButton("Go");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				int num=Integer.parseInt(formattedTextField.getText());
				if(num<=m.getPlistcounter())
				{
					playlistView v1=new playlistView(m,num-1);
					v1.setVisible(true);
					dispose();
				}
				else
				{
					throw new SongNotFoundException();
				}
				}catch(SongNotFoundException e2){
					label_1.setText("Kindly enter Sr. No. from the given table.");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBounds(662, 31, 69, 34);
		contentPane.add(btnNewButton_1);
		Object[][] ob=new Object[m.getPlistcounter()][3];
		for(int i=0;i<m.getPlistcounter();++i)
		{
			ob[i][0]=i+1;
			ob[i][1]=m.getPlist(i).getName();
			ob[i][2]=m.getPlist(i).getCounter();
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 113, 495, 261);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			ob,
			new String[] {
				"Sr. No.", "Playlist Name", "No. of Songs"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JLabel lblDeleteAPlaylist = new JLabel("Delete a playlist:");
		lblDeleteAPlaylist.setFont(new Font("Calibri", Font.BOLD, 16));
		lblDeleteAPlaylist.setForeground(Color.BLUE);
		lblDeleteAPlaylist.setBounds(529, 172, 173, 34);
		contentPane.add(lblDeleteAPlaylist);
		
		JLabel label = new JLabel("Enter playlist's Sr. No. :");
		label.setFont(new Font("Calibri", Font.BOLD, 15));
		label.setBounds(529, 201, 180, 20);
		contentPane.add(label);
		
		lblKindltEnterSr.setForeground(Color.RED);
		lblKindltEnterSr.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblKindltEnterSr.setBounds(529, 302, 202, 27);
		contentPane.add(lblKindltEnterSr);
		
		formattedTextField_1.setBounds(529, 228, 180, 20);
		contentPane.add(formattedTextField_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=Integer.parseInt(formattedTextField_1.getText());
				try{
				if(index<=m.getPlistcounter())
				{
					
				
				--index;
				playlist[] p1=new playlist[200];
				for(int i=index;i<m.getPlistcounter()-1;++i)
				{
					m.getPlist(i).copy(m.getPlist(i+1));
				}
				m.decrPlistCounter();
				save(m);
				PlistDeleted pd=new PlistDeleted(m);
				pd.setVisible(true);
				dispose();
				
				}
				else
				{
					throw new SongNotFoundException();
					
				}
				}catch(SongNotFoundException e1){lblKindltEnterSr.setText("Kindly enter Sr. No. from the given table.");}
			}
		});
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton_2.setBounds(529, 260, 91, 34);
		contentPane.add(btnNewButton_2);
		
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(181);
		table.getColumnModel().getColumn(2).setPreferredWidth(97);
	}
}
