import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class BarraTareas {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BarraTareas window = new BarraTareas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BarraTareas() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 396, 123);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblSpotify = new JLabel("");
		lblSpotify.setBounds(0, 0, 80, 84);
		lblSpotify.setIcon(new ImageIcon("src/spotify.png"));
		frame.getContentPane().add(lblSpotify);
		lblSpotify.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ProcessBuilder pb = new ProcessBuilder(
						"C:/Users/jonyn/AppData/Local/Microsoft/WindowsApps/SpotifyAB.SpotifyMusic_zpdnekdrzrea0/Spotify.exe",
						"");
				try {
					pb.start();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});

		JLabel lblChrome = new JLabel("");
		lblChrome.setBounds(100, 0, 80, 84);
		lblChrome.setIcon(new ImageIcon("src/chrome.png"));
		frame.getContentPane().add(lblChrome);

		lblChrome.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ProcessBuilder pb = new ProcessBuilder(
						"C:\\Program Files (x86)\\Google\\Chrome\\Application/chrome.exe", "");
				try {
					pb.start();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});

		JLabel lblEclipse = new JLabel("");
		lblEclipse.setIcon(new ImageIcon("src/eclipse.png"));
		lblEclipse.setBounds(200, 0, 80, 84);
		frame.getContentPane().add(lblEclipse);

		lblEclipse.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ProcessBuilder pb = new ProcessBuilder("C:\\Users\\jonyn\\eclipse\\java-photon\\eclipse/eclipse.exe",
						"");
				try {
					pb.start();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});

		JLabel lblAStudio = new JLabel("");
		lblAStudio.setIcon(new ImageIcon("src/androidStudio.png"));
		lblAStudio.setBounds(300, 0, 80, 84);
		frame.getContentPane().add(lblAStudio);

		lblAStudio.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\Android\\Android Studio\\bin/studio64.exe",
						"");
				try {
					pb.start();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});
	}
}
