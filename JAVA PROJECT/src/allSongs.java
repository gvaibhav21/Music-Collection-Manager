import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
@SuppressWarnings({ "serial", "unused" })
public class allSongs extends javax.swing.JFrame {
	static int count=0;
	static song[] songs=new song[200];
	/**
	 * Creates new form allSongs
	 */
	public allSongs(member m,int menuType) {
		initComponents(m,menuType);
	}

	public static void remove(song s)
	{
		try{
			FileInputStream f=new FileInputStream("songs.ser");
			ObjectInputStream ois = new ObjectInputStream(f);
			song[] songs=new song[200];
			int count=0;
			while(f.available()>0)
			{
				song s1=(song)ois.readObject();
				if(!(s1.getId()==s.getId()))
				songs[count++]=new song(s1);
			}
			
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

	
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings({ "unchecked" })
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents(final member m,final int menuType) {
		count=0;
		jScrollPane1 = new javax.swing.JScrollPane();

		jFormattedTextField1 = new javax.swing.JFormattedTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


		try
		{
			FileInputStream f=new FileInputStream("songs.ser");
			ObjectInputStream ois = new ObjectInputStream(f);

			while(f.available()>0)
			{
				song s=(song)ois.readObject();
				songs[count++]=s;
			}
			ois.close();
		}catch(Exception e){}	
		try
		{
			if(count==0) throw new DatabaseEmptyException();
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
			jTable1 = new javax.swing.JTable();
			jTable1.setModel(new javax.swing.table.DefaultTableModel(
					ob,
					new String [] {
							"Song Id", "Name", "Artist", "Year of Release", "Album", "Genre", "Personal Rating", "Favourite"
					}
					) {
				@SuppressWarnings("rawtypes")
				Class[] types = new Class [] {
					java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
				};

				@SuppressWarnings("rawtypes")
				public Class getColumnClass(int columnIndex) {
					return types [columnIndex];
				}
			});
			jScrollPane1.setViewportView(jTable1);
		
		}
		catch(DatabaseEmptyException e)
		{

			jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); 
			jLabel2.setForeground(new java.awt.Color(255, 0, 0));
			jLabel2.setText("No Song Found in Database.");

		}

		if(menuType==0)
		{
		jLabel1.setText("Enter Song Id:");

		jButton1.setText("Go");

		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int Id=Integer.parseInt(jFormattedTextField1.getText());
				int i;
				try{
				for(i=0;i<count;++i)
				{
					if(songs[i].getId()==Id)
					{
						viewSong view=new viewSong(songs[i],m,0);
						view.setVisible(true);
						dispose();
						break;
					}
				}
				if(i==count)
				{
					throw new SongNotFoundException();
						}
				}catch(SongNotFoundException e1){jLabel2.setFont(new java.awt.Font("Tahoma", 0, 11)); 
				jLabel2.setForeground(new java.awt.Color(255, 0, 0));
				
				jLabel2.setText("Please enter Song Id from the list Below.");
		}
			}
		});
		}
		else
		{
			jLabel1.setText("Enter Song Id:");
			jButton1.setText("Go");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					int Id=Integer.parseInt(jFormattedTextField1.getText());
					int i;
					for(i=0;i<count;++i)
					{
						if(songs[i].getId()==Id)
						{
							remove(songs[i]);
							break;
						}
					}
					if(i==count)
					{
						jLabel2.setFont(new java.awt.Font("Tahoma", 0, 11)); 
						jLabel2.setForeground(new java.awt.Color(255, 0, 0));
						jLabel2.setText("Please enter Song Id from the list Below.");
					}
					songDeleteSuccess sds=new songDeleteSuccess(m);
					sds.setVisible(true);
					dispose();
				}
			});
		}
		jButton2.setText("<< Back");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menu Menu=new menu(m);
				Menu.setVisible(true);
				dispose();
			}
		});


		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(jScrollPane1))
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGap(35, 35, 35)
														.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(60, 60, 60)
														.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(layout.createSequentialGroup()
																.addGap(85, 85, 85)
																.addComponent(jLabel2)))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18, 18)
																.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jFormattedTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
										.addComponent(jButton1))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jButton2)))
										.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
						                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
						                .addContainerGap())
				);

		pack();
	}// </editor-fold>                        



	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(allSongs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(allSongs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(allSongs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(allSongs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				member m=new member();
				new allSongs(m,0).setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify                     
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JFormattedTextField jFormattedTextField1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	// End of variables declaration                   
}
