package timecount;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hakinda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLokmanuguryahoocom;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hakinda frame = new hakinda();
					frame.setVisible(true);	

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws URISyntaxException 
	 */
	public hakinda() {
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		setTitle("Hakkında");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(200, 200, 428, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Program Lokman UĞUR tarafından geliştirilmiştir.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(41, 26, 348, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Program kulanımı ücretsizdir ve bütün hakları saklıdır.");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 57, 392, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Program hakindaki görüş ve önerileriniz için e-mail adresim:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(28, 82, 361, 14);
		contentPane.add(lblNewLabel_3);
		
		txtLokmanuguryahoocom = new JTextField();
		txtLokmanuguryahoocom.setHorizontalAlignment(SwingConstants.CENTER);
		txtLokmanuguryahoocom.setBackground(SystemColor.menu);
		txtLokmanuguryahoocom.setForeground(Color.BLACK);
		txtLokmanuguryahoocom.setText("lokman.ugur@yahoo.com");
		txtLokmanuguryahoocom.setBounds(135, 107, 149, 20);
		contentPane.add(txtLokmanuguryahoocom);
		txtLokmanuguryahoocom.setColumns(10);
	    
	    JButton button_1 = new JButton();
	    button_1.setText("<HTML>Linki Tıkla <FONT color=\"#000099\"><U>http://www.lokmanugur.com</U></FONT> Sitesine Git.</HTML>");
	    button_1.setBounds(28, 138, 361, 22);
	    contentPane.add(button_1);
	    button_1.addActionListener(new OpenUrlAction());
	}
	class OpenUrlAction implements ActionListener {
	    @Override public void actionPerformed(ActionEvent e) {
	      new dene();
	    }
	}
 }
 

