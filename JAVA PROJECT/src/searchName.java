import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JLabel;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JFormattedTextField;


@SuppressWarnings({ "serial", "unused" })
public class searchName extends JFrame {
	static int count=0;
	static song[] songs=new song[200];

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					member m=new member();
					searchName frame = new searchName(m);
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
	public searchName(final member m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton = new JButton("<< Back");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 11, 107, 45);
		contentPane.add(btnNewButton);
		
		JLabel lblSearchByName = new JLabel("Search By Name:");
		lblSearchByName.setForeground(Color.BLUE);
		lblSearchByName.setFont(new Font("Calibri", Font.BOLD, 18));
		lblSearchByName.setBounds(299, 15, 148, 36);
		contentPane.add(lblSearchByName);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(457, 21, 224, 27);
		contentPane.add(formattedTextField);
		
		JLabel lblEnterSongId = new JLabel("Enter Song Id:");
		lblEnterSongId.setForeground(Color.BLUE);
		lblEnterSongId.setFont(new Font("Calibri", Font.BOLD, 18));
		lblEnterSongId.setBounds(299, 53, 148, 36);
		contentPane.add(lblEnterSongId);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(457, 59, 224, 27);
		contentPane.add(formattedTextField_1);
		
		JLabel lblKindlyEnterId = new JLabel("");
		lblKindlyEnterId.setForeground(Color.RED);
		lblKindlyEnterId.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblKindlyEnterId.setBounds(299, 100, 292, 23);
		contentPane.add(lblKindlyEnterId);
		
		JLabel lblSongDoesNot = new JLabel("");
		lblSongDoesNot.setForeground(Color.RED);
		lblSongDoesNot.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblSongDoesNot.setBounds(10, 67, 248, 23);
		contentPane.add(lblSongDoesNot);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			@SuppressWarnings("serial")
			public void actionPerformed(ActionEvent e) {
				try
				{
					count=0;
					FileInputStream f=new FileInputStream("songs.ser");
					ObjectInputStream ois = new ObjectInputStream(f);
					//String name=
					while(f.available()>0)
					{
						song s=(song)ois.readObject() ; 
						songs[count++]=s;
					}
					ois.close();
				}catch(Exception e1){}	
				if(count!=0)
				{
					Object[][] ob=new Object[count][8];
					for(int i=0;i<count;++i)
					{
						ob[i][0]=songs[i].getId();
						ob[i][1]=songs[i].getName();
						ob[i][2]=songs[i].getArtist();
						ob[i][3]=songs[i].getYear();
						ob[i][4]=songs[i].getAlbum();
						ob[i][5]=songs[i].getGenre();
						ob[i][6]=m.getRating(songs[i].getId());
						if(m.isFav(songs[i].getId()))
							ob[i][7]="Yes";
						else
							ob[i][7]="No";
					}
					
				}
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"SongId", "Name", "Artist", "Year", "Album", "Genre", "Personal Rating", "Favourite"
					}
				) {
					@SuppressWarnings("rawtypes")
					Class[] columnTypes = new Class[] {
						Integer.class, String.class, String.class, Integer.class, String.class, String.class, Integer.class, String.class
					};
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				table.getColumnModel().getColumn(1).setPreferredWidth(96);
				table.getColumnModel().getColumn(2).setPreferredWidth(95);
				table.getColumnModel().getColumn(3).setPreferredWidth(70);
				table.getColumnModel().getColumn(4).setPreferredWidth(95);
				table.getColumnModel().getColumn(6).setPreferredWidth(88);
				table.setColumnSelectionAllowed(true);
				table.setCellSelectionEnabled(true);
				table.setBounds(10, 130, 755, 290);
				contentPane.add(table);
				
			}
		});
		btnSearch.setForeground(Color.BLUE);
		btnSearch.setBounds(686, 23, 79, 27);
		contentPane.add(btnSearch);
		
		JButton btnGo = new JButton("Go");
		btnGo.setForeground(Color.BLUE);
		btnGo.setBounds(686, 61, 79, 27);
		contentPane.add(btnGo);
	}
}
