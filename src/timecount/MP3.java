/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package timecount;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MP3 {
    private final String filename;
    private Player player1; 
    private static int sing;
    static int val=0;
    // constructor that takes the name of an MP3 file
    public MP3(String filename) {
        this.filename = filename;
    }

    public void close() { 
    	if(player1 != null)
    		if(sing>val){
    		++val;
    	try {
			player1.play();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}//else
    		//player1.close(); 
    	}

    // play the MP3 file to the sound card
    public void play() {
        try {
            FileInputStream fis     = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player1 = new Player(bis);
        }
        catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }

        // run in new thread to play in background
        new Thread() {
            public void run() {
                try {player1.play();}
                catch (Exception e) { System.out.println(e);}}}.start();

    }

    // test client
  /*  public static void main(String[] args) {
    	
    	File folder = new File("E:/Intizar");
    	File[] listOfFiles = folder.listFiles();
    		sing=listOfFiles.length;
    	    for (int i = 0; i < listOfFiles.length; i++) {
    	      if (listOfFiles[i].isFile()) {
    	        System.out.println("File " + listOfFiles[i].getName());
    	      } else if (listOfFiles[i].isDirectory()) {
    	        System.out.println("Directory " + listOfFiles[i].getName());
    	      }
    	    }
    	    System.out.println(val+"  "+sing);
    	    
       String filename1 ="E:/Intizar/";
        MP3 mp3 = new MP3(filename1);
        mp3.play();
        

        // do whatever computation you like, while music plays
       /* int N = 4000;
        double sum = 0.0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += Math.sin(i + j);
            }
        }
        System.out.println(sum);*/

        // when the computation is done, stop playing it
        //mp3.close();
        
        // play from the beginning
       // mp3 = new MP3(filename1);
        //mp3.play();
    //}

}
