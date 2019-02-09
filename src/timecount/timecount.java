package timecount;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
//--------------------------------------------
import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
public class timecount extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    hakinda hknd=new hakinda();
    Object lock=new Object();
    help hlp=new help();
    isimbulamadim isim = new isimbulamadim();
    closing close = new closing();
    crnmr crn = new crnmr();
    value value = new value();

    int val=0;
    String day;
    JLabel lblsaat1 = new JLabel("New label");
    JMenuBar menuBar = new JMenuBar();
    JMenu mnNewMenu = new JMenu("Dosya");
    JMenuItem mntmNewMenuItem_1 = new JMenuItem("Çıkış");
    JMenu mnNewMenu_1 = new JMenu("Yardım");
    JMenuItem mntmNewMenuItem_2 = new JMenuItem("Yardım");
    JMenuItem mntmNewMenuItem_3 = new JMenuItem("Hakkında");
    JPanel panel = new JPanel();
    JLabel lblkronometre = new JLabel("");
    JPanel panel_1 = new JPanel();
    JLabel lbltarih = new JLabel("Tarih");
    JLabel lbltarih1 = new JLabel("New label");
    JLabel lblsaat = new JLabel("Saat");
    JButton btnNewButton = new JButton("Başlat");
    JPanel panel_2 = new JPanel();
    JSpinner spinner = new JSpinner();
    JSpinner spinner_1 = new JSpinner();
    JSpinner spinner_2 = new JSpinner();
    JPanel panel_3 = new JPanel();
    JRadioButton rdbtnNewRadioButton = new JRadioButton("PC Kapat");
    JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Oturum Kapat");
    JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Yeniden Başlat");
    ButtonGroup group=new ButtonGroup();
    JLabel lblSaat = new JLabel("Saat");
    JLabel lblDadkika = new JLabel("Dakika");
    JLabel lblSaniye = new JLabel("Saniye");
    String filename1 ="Sound.wav";
    MP3 mp3 = new MP3(filename1);
    private final JProgressBar progressBar = new JProgressBar();
	
	/**
	 * Launch the application.
     * @param args
	 */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                    timecount frame = new timecount();
                    try {
                            frame.setVisible(true);

                    } catch (Exception e) {
                    }
            }
        });	
    }
	/**
	 * Create the frame.
	 */
    public timecount() {
        isim.start();
        value.setBoolean(true);
        value.setBoolean_1(true);
        value.setBoolean_2(true);
        rdbtnNewRadioButton.setToolTipText("Bilgisayarı Kapat");
        //rdbtnNewRadioButton.setSelected(true);
        progressBar.setStringPainted(true);
        progressBar.setString(value.getSaat()+"  :  "+value.getDakika()+"  :  "+value.getSaniye());
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        setTitle("Ugur *.*");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 405, 261);
        setResizable(false);
        //------------------	
        this.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                if (e.getNewState() == ICONIFIED) {
                    try {
                      final TrayIcon trayIcon = new TrayIcon(new ImageIcon("dunya.gif").getImage());

                        trayIcon.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                               SystemTray.getSystemTray().remove(trayIcon);
                               setVisible(true);
                               setState(JFrame.NORMAL);
                            }
                        });
                        trayIcon.setToolTip("UGUR BT Version 1.0");
                        SystemTray.getSystemTray().add(trayIcon);		                 
                        setVisible(false);		                
                    } catch (AWTException e1) {
                    }
                }
            }
        });
		//------------------
        setJMenuBar(menuBar);	
        menuBar.add(mnNewMenu);
        mntmNewMenuItem_1.setIcon(new ImageIcon("imagesc.png"));
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
                @SuppressWarnings("deprecation")
                public void actionPerformed(ActionEvent arg0) {
                           crn.stop();
                           close.stop();
                           isim.stop();
                        System.exit(0);	
                }
        });
        mnNewMenu.add(mntmNewMenuItem_1);
        menuBar.add(mnNewMenu_1);
        mntmNewMenuItem_2.setIcon(new ImageIcon("imagesh.png"));
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                        hlp.setVisible(true);
                }
        });
        mnNewMenu_1.add(mntmNewMenuItem_2);
        mntmNewMenuItem_3.setIcon(new ImageIcon("imagesi.png"));
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                        hknd.setVisible(true);	
                }
        });
        mnNewMenu_1.add(mntmNewMenuItem_3);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        panel.setBounds(5, 95, 274, 66);
        panel.setBorder(new TitledBorder(null, "Kronometre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setLayout(null);
        lblkronometre.setToolTipText("Kronometre : Kapanış zamanını girin başlat düğmesine basın");

        lblkronometre.setHorizontalAlignment(SwingConstants.CENTER);
        lblkronometre.setFont(new Font("Tahoma", Font.BOLD, 38));
        lblkronometre.setBounds(10, 11, 254, 55);
        panel.add(lblkronometre);

        panel_1.setBounds(281, 5, 109, 196);
        panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), ".......", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
        panel_1.setLayout(null);
        lbltarih.setFont(new Font("Tahoma", Font.PLAIN, 14));

        lbltarih.setBounds(30, 28, 46, 14);
        panel_1.add(lbltarih);
        lbltarih1.setToolTipText(valueofday());
        lbltarih1.setFont(new Font("Tahoma", Font.PLAIN, 14));

        lbltarih1.setBounds(10, 53, 92, 14);
        panel_1.add(lbltarih1);
        lblsaat.setFont(new Font("Tahoma", Font.PLAIN, 14));

        lblsaat.setBounds(30, 94, 46, 14);
        panel_1.add(lblsaat);
        lblsaat1.setFont(new Font("Tahoma", Font.PLAIN, 14));

        lblsaat1.setBounds(15, 120, 92, 14);
        panel_1.add(lblsaat1);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {							
                if(value.getBoolean()==false){
                    value.setBoolean_1(false);
                    if(value.getBoolean_2()==false){
                        btnNewButton.setText("Durdur");
                        synchronized (lock) {
                            lock.notify();
                            int spnr=(Integer)spinner.getValue();
                            value.setSaat(spnr);
                            int spnr_1=(Integer)spinner_1.getValue();
                            value.setDakika(spnr_1);
                            int spnr_2=(Integer)spinner_2.getValue();
                            value.setSaniye(spnr_2);
                            val=0;
                            progressBar.setValue(0);
                            progressBar.setMaximum(0);
                            value.setProgress(0,0,0);
                            value.setProgress(spnr, spnr_1, spnr_2);
                            progressBar.setStringPainted(true);
                            progressBar.setMaximum(value.getProgress());
                            progressBar.setMinimum(0);
                            progressBar.setString(value.getSaat()+"  :  "+value.getDakika()+"  :  "+value.getSaniye());	
                            value.setBoolean_1(true);
                            value.setBoolean_2(true);
                        }
                    }
                }
                else if(spinner.getValue().equals(0)&&spinner_1.getValue().equals(0)&&spinner_2.getValue().equals(0)){
                    JOptionPane.showMessageDialog(null,"Lütfen kapanış zamanını giriniz.","Uyarı" ,JOptionPane.OK_OPTION);	
                }
                else if(value.getBoolean()==true){
                    btnNewButton.setText("Durdur");
                    int spnr=(Integer)spinner.getValue();
                    value.setSaat(spnr);
                    int spnr_1=(Integer)spinner_1.getValue();
                    value.setDakika(spnr_1);
                    int spnr_2=(Integer)spinner_2.getValue();
                    value.setSaniye(spnr_2);
                    value.setProgress(spnr, spnr_1, spnr_2);	
                    progressBar.setStringPainted(true);
                    progressBar.setMaximum(value.getProgress());
                    progressBar.setMinimum(0);
                    progressBar.setString(value.getSaat()+"  :  "+value.getDakika()+"  :  "+value.getSaniye());
                    value.setBoolean(false);
                    close.start();
                    crn.start();
                }						
            }
        });
        btnNewButton.setBounds(10, 162, 92, 23);
        panel_1.add(btnNewButton);
        panel_2.setBounds(5, 5, 274, 89);
        panel_2.setBorder(new TitledBorder(null, "Kapanış Zamanı", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setLayout(null);
        spinner.setToolTipText("Saati Kur");

        spinner.setModel(new SpinnerNumberModel(0, 0, 23, 1));
        spinner.setFont(new Font("Tahoma", Font.BOLD, 38));
        spinner.setBounds(10, 29, 78, 49);
        panel_2.add(spinner);
        spinner_1.setToolTipText("Dakikayı Kur");

        spinner_1.setModel(new SpinnerNumberModel(0, 0, 59, 1));
        spinner_1.setFont(new Font("Tahoma", Font.BOLD, 38));
        spinner_1.setBounds(98, 29, 78, 49);
        panel_2.add(spinner_1);
        spinner_2.setToolTipText("Saniyeyi Kur");

        spinner_2.setModel(new SpinnerNumberModel(0, 0, 59, 1));
        spinner_2.setFont(new Font("Tahoma", Font.BOLD, 38));
        spinner_2.setBounds(186, 29, 78, 49);
        panel_2.add(spinner_2);

        panel_3.setBounds(5, 164, 274, 37);
        panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
        panel_3.setLayout(null);

        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        rdbtnNewRadioButton.setBounds(6, 7, 69, 23);
        panel_3.add(rdbtnNewRadioButton);
        rdbtnNewRadioButton_1.setToolTipText("Oturumu kapatır");

        rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
        rdbtnNewRadioButton_1.setBounds(77, 7, 95, 23);
        panel_3.add(rdbtnNewRadioButton_1);
        rdbtnNewRadioButton_2.setToolTipText("Bilgisayarı yeniden başlatır");

        rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
        rdbtnNewRadioButton_2.setBounds(174, 7, 95, 23);
        panel_3.add(rdbtnNewRadioButton_2);

        group.add(rdbtnNewRadioButton);
        group.add(rdbtnNewRadioButton_1);
        group.add(rdbtnNewRadioButton_2);
        contentPane.setLayout(null);
        contentPane.add(panel);
        progressBar.setValue(1);
        progressBar.setForeground(Color.GREEN);
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 38));
        progressBar.setBounds(10, 21, 254, 40);
        panel.add(progressBar);
        contentPane.add(panel_1);
        contentPane.add(panel_2);

        lblSaat.setBounds(10, 11, 46, 17);
        panel_2.add(lblSaat);

        lblDadkika.setBounds(98, 14, 46, 14);
        panel_2.add(lblDadkika);

        lblSaniye.setBounds(186, 14, 46, 14);
        panel_2.add(lblSaniye);
        contentPane.add(panel_3);

            lblsaat1.setText( value.getCSaat()+" : "+value.getCDakika()+" : "+value.getCSaniye());
            lbltarih1.setText(value.getCGun()+" / "+value.getCAy()+" / "+value.getCSene());
    }
	
    public String valueofday(){
        if(Integer.parseInt(value.getCSGun())==1)
                day="Pazar";
        else if(Integer.parseInt(value.getCSGun())==2)
                day="Pazartesi";
        else if(Integer.parseInt(value.getCSGun())==3)
                day="Salı";
        else if(Integer.parseInt(value.getCSGun())==4)
                day="Çarşamba";
        else if(Integer.parseInt(value.getCSGun())==5)
                day="Perşembe";
        else if(Integer.parseInt(value.getCSGun())==6)
                day="Cuma";
        else if(Integer.parseInt(value.getCSGun())==7)
                day="Cumartesi";
        return day;
    }
	
    class isimbulamadim extends Thread{
	public void run(){
            while(true){
		try {
                    sleep(1000);
		} catch (InterruptedException e) {
                    e.printStackTrace();
		}
		lblsaat1.setText( value.getCSaat()+" : "+value.getCDakika()+" : "+value.getCSaniye());
		lbltarih1.setText(value.getCGun()+" / "+value.getCAy()+" / "+value.getCSene());	
            }
        }
    }
	
    class crnmr extends Thread{	
        public void run(){
            while(value.getSaat()!=0||value.getDakika()!=0||value.getSaniye()!=0){
                while(value.getSaat()>=0){
                    if(value.getBoolean_1()==false)
                        btnNewButton.setText("Başlat");
                    if(value.getBoolean_1()==false)
                        break;
                    int saat=value.getSaat(),sa;
                    while(value.getDakika()>=0){
                        if(value.getBoolean_1()==false)
                            btnNewButton.setText("Başlat");
                        if(value.getBoolean_1()==false)
                            break;
                            int dakika=value.getDakika(),dak;
                            while(value.getSaniye()>0){
                                if(value.getBoolean_1()==false)
                                    btnNewButton.setText("Başlat");
                                if(value.getBoolean_1()==false)
                                    break;
                                int saniye=value.getSaniye(),san;
                                san=--saniye;
                                value.setSaniye(san);
                                btnNewButton.setText("Durdur");
                                progressBar.setStringPainted(true);
                                progressBar.setMaximum(value.getProgress());
                                progressBar.setMinimum(0);
                                progressBar.setValue(++val);
                                progressBar.setString(value.getSaat()+"  :  "+value.getDakika()+"  :  "+value.getSaniye()); 
                                try {
                                    if(value.getBoolean_1()==false)
                                        btnNewButton.setText("Başlat");					            	
                                        Thread.sleep(1000);
                                        if(value.getBoolean_1()==false)
                                        btnNewButton.setText("Başlat");
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    }
                            }
                        dak=--dakika;
                        value.setDakika(dak);
                        value.setSaniye(60);
                        mp3.play();
                    }
                    sa=--saat;
                    value.setSaat(sa);
                    value.setDakika(59);
                }
                value.setBoolean_2(false);
                btnNewButton.setText("Başlat");
            }
        }
    }

    class closing extends Thread{
        public void run(){ 
            while(true){
                if(value.getSaat()==0 & value.getDakika()==0 & value.getSaniye()==0){
                    if(rdbtnNewRadioButton.isSelected()){
                        try{	
                            Runtime.getRuntime().exec("Shutdown.exe /s /t 00");
                            System.exit(0);
                        }catch(IOException ex){
                            Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE,null,ex);
                        }
                    }
                else if(rdbtnNewRadioButton_1.isSelected()){
                    try {
                        Runtime.getRuntime().exec("Shutdown.exe /l");
                        System.exit(0);
                    } catch (IOException ex) {
                        Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(rdbtnNewRadioButton_2.isSelected()){                                
                    try {
                        Runtime.getRuntime().exec("Shutdown.exe /r /t 00");
                        System.exit(0);
                    } catch (IOException ex) {
                        Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                }
            else{
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            }
        }
    }	
}