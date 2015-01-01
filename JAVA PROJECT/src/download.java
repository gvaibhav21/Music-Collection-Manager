import java.awt.BorderLayout;
import java.util.concurrent.TimeUnit;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;


@SuppressWarnings({ "unused", "serial" })
public class download extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					download frame = new download();
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
	public download() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 371, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Your Song is being downloaded");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(45, 29, 192, 53);
		contentPane.add(label);
		try
		{
			
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(247, 29, 117, 53);
		contentPane.add(label_1);
		wait();
		label_1.setText(".");
		TimeUnit.SECONDS.sleep(1);
		label_1.setText(". .");
		TimeUnit.MILLISECONDS.sleep(500);
		label_1.setText(". . .");
		TimeUnit.MILLISECONDS.sleep(500);
		label_1.setText(".");
		TimeUnit.MILLISECONDS.sleep(500);
		label_1.setText(". .");
		TimeUnit.MILLISECONDS.sleep(500);
		label_1.setText(". . .");
		TimeUnit.MILLISECONDS.sleep(500);
		JLabel lblSongDownloaded = new JLabel("Downlad Complete.");
		lblSongDownloaded.setBounds(45, 91, 117, 36);
		contentPane.add(lblSongDownloaded);
		TimeUnit.MILLISECONDS.wait(1000);
		
		dispose();
		}catch(Exception e){}
		
	}
}
