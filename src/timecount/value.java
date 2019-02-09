package timecount;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class value {
	
static private int Saat;
static private int Dakika;
static public int Saniye;
private boolean bln;
private boolean bln1;
private boolean bln2;
static private int ss;
static private int dd;
static private int total;

//****************calendar get instant variable from computer calendar****************
public String getCSGun(){
    Calendar calendar=new GregorianCalendar();
int gunofweek=calendar.get(Calendar.DAY_OF_WEEK);
return String.format("%s",gunofweek); 
}
public String getCGun(){
    Calendar calendar=new GregorianCalendar();
int gun=calendar.get(Calendar.DAY_OF_MONTH);
 return String.format("%s",gun);
 } 
  public String getCAy(){
      Calendar calendar=new GregorianCalendar();
 int ay=calendar.get(Calendar.MONTH); 
 return String.format("%s",ay+1);
 }
   public String getCSene(){
       Calendar calendar=new GregorianCalendar();
int sene=calendar.get(Calendar.YEAR);
 return String.format("%s",sene);
   }
 public String getCSaat(){
     Calendar calendar=new GregorianCalendar();
int saat=calendar.get(Calendar.HOUR_OF_DAY);
 return String.format("%s",saat);
 } 
  public String getCDakika(){
      Calendar calendar=new GregorianCalendar();
int dakika=calendar.get(Calendar.MINUTE);
 return String.format("%s",dakika);
 }
   public String getCSaniye(){
       Calendar calendar=new GregorianCalendar();
int saniye=calendar.get(Calendar.SECOND);
 return String.format("%s",saniye);
 }
//************end of calendar*******************
   
//**********get value from splinter and set to labels************
   public void setSaat(int saat){
	Saat=saat;
}
public int getSaat(){
	return Saat;
}
public void setDakika(int dakika){
	Dakika=dakika;
}
public int getDakika(){
	return Dakika;
}
public void setSaniye(int saniye){
	Saniye=saniye;
}
public int getSaniye(){
	return Saniye;
}

//*****************end of splinter value******************
public void setBoolean(boolean bln){
	this.bln=bln;
}
public boolean getBoolean(){
	return bln;
}
public void setBoolean_1(boolean bln1){
	this.bln1=bln1;
}
public boolean getBoolean_1(){
	return bln1;
}
public void setBoolean_2(boolean bln2){
	this.bln2=bln2;
}
public boolean getBoolean_2(){
	return bln2;
}
//************progressBar value***************************
public void setProgress(int value1,int value2,int value3){

	if(value1>0){
		 ss=value1*60*60;
	}
	if(value2>0){
		 dd=value2*60;
		}
	if(value1==0&value2==0&value3==0)
	{
		ss=0;
		dd=0;
		value3=0;
		}
	total = ss+dd+value3;
}
public int getProgress(){
	return total;
}
}
