import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;


@SuppressWarnings({ "serial", "unused" })
public class playlistView extends JFrame {
	static JFormattedTextField formattedTextField = new JFormattedTextField();

	private JPanel contentPane;
	private JTable table;
	private JLabel lblEnterSongId;
	private JLabel lblKindlyEnterSongid;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					member m=new member();
					playlistView frame = new playlistView(m,0);
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
	public playlistView(final member m,final int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Object[][] ob=new Object[m.getPlist(index).getCounter()][8];
		for(int i=0;i<m.getPlist(index).getCounter();++i)
		{
			ob[i][0]=m.getPlist(index).songs[i].getId();
			ob[i][1]=m.getPlist(index).songs[i].getName();
			ob[i][2]=m.getPlist(index).songs[i].getArtist();
			ob[i][3]=m.getPlist(index).songs[i].getYear();
			ob[i][4]=m.getPlist(index).songs[i].getAlbum();
			ob[i][5]=m.getPlist(index).songs[i].getGenre();
			ob[i][6]=m.getRating(m.getPlist(index).songs[i].getId());
			if(m.isFav(m.getPlist(index).songs[i].getId()))
				ob[i][7]="Yes";
			else
				ob[i][7]="No";
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 754, 255);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			ob,
			new String[] {
				"Song Id", "Name", "Artist", "Year", "Genre", "Album", "Personal Rating", "Favourite"
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
		table.getColumnModel().getColumn(1).setPreferredWidth(99);
		table.getColumnModel().getColumn(2).setPreferredWidth(94);
		table.getColumnModel().getColumn(3).setPreferredWidth(81);
		table.getColumnModel().getColumn(4).setPreferredWidth(95);
		table.getColumnModel().getColumn(5).setPreferredWidth(103);
		table.getColumnModel().getColumn(6).setPreferredWidth(92);
		
		JButton btnNewButton = new JButton("<< Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playlists pl=new playlists(m);
				pl.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton.setBounds(10, 11, 111, 36);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Calibri", Font.BOLD, 20));
		label.setForeground(Color.BLUE);
		label.setText(m.getPlist(index).getName());
		label.setBounds(147, 11, 250, 36);
		contentPane.add(label);
		
		lblEnterSongId = new JLabel("Enter Song Id:");
		lblEnterSongId.setFont(new Font("Calibri", Font.BOLD, 18));
		lblEnterSongId.setBounds(407, 11, 111, 36);
		contentPane.add(lblEnterSongId);
		
		formattedTextField.setBounds(528, 20, 156, 20);
		contentPane.add(formattedTextField);
		
		lblKindlyEnterSongid = new JLabel("");
		lblKindlyEnterSongid.setForeground(Color.RED);
		lblKindlyEnterSongid.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblKindlyEnterSongid.setBounds(10, 49, 369, 36);
		contentPane.add(lblKindlyEnterSongid);
		
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num=Integer.parseInt(formattedTextField.getText());
				int i;
				for(i=0;i<m.getPlist(index).getCounter();++i)
				{
					if(m.getPlist(index).getSong(i).getId()==num)
					{
						viewSong view=new viewSong(m.getPlist(index).getSong(i),m,8);
						view.setVisible(true);
						dispose();
					}
				}
				if(i==m.getPlist(index).getCounter())
				{
					lblKindlyEnterSongid.setText("Kindly Enter Song ID from the table below.");
				}
				
			}
		});
		btnGo.setBounds(694, 16, 53, 28);
		contentPane.add(btnGo);
		
		
	}
}
