package timecount;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Font;


public class help extends JFrame {
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					help frame = new help();
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
	public help() {
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		setTitle("Yardım");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 450, 300);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 414, 250);
		getContentPane().add(scrollPane);
		
		JTextArea txtarea = new JTextArea();
		txtarea.setWrapStyleWord(true);
		txtarea.setLineWrap(true);
		txtarea.setText("     \r\n       1-Kapan\u0131\u015F zaman\u0131ndaki Saat, Dakika ve Saniye de\u011Ferlerini art\u0131rarak kapanmas\u0131n\u0131 isted\u011Finiz zaman\u0131 ayarlay\u0131n\u0131z.\r\n\r\n       2- Radio butonlar\u0131ndan yap\u0131lmas\u0131n\u0131 istedi\u011Finiz eylemi (PC Kapat, Yeniden Ba\u015Flat, Oturumu Kapat) se\u00E7iniz.\r\n\r\n       3- Kronometreyi ba\u015Flatmak i\u00E7in Ba\u015Flat butonuna bast\u0131\u011F\u0131n\u0131zda kronometre geriye do\u011Fru sayarak s\u00FCre sonunda yapt\u0131rak istedi\u011Finiz eylemi ger\u00E7ekle\u015Ftirecektir.\r\n\r\n       4- Kronometre geriye do\u011Fru sayarken s\u00FCreyi Durdur butonuna basarak  durdurabilirsiniz ve yeni de\u011Fer atayarak tekrar ba\u015Flatt\u0131\u011F\u0131n\u0131zda; verdi\u011Fi\u011Finiz de\u011Ferden geriye saymaya ba\u015Flayacakt\u0131r. \r\n\r\n       5- Kronometreyi ba\u015Flat\u0131ktan sonra durdurup s\u00FCreyi s\u0131f\u0131rlay\u0131p yeniden ba\u015Flat\u0131rsan\u0131z yapt\u0131rmak istedi\u011Finiz eylem an\u0131nda ger\u00E7ekle\u015Fecektir.");
		txtarea.setFont(new Font("Arial", Font.PLAIN, 12));
		txtarea.setBackground(UIManager.getColor("Button.background"));
		scrollPane.setViewportView(txtarea);
	}
}
