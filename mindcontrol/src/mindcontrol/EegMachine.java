/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindcontrol;
import java.util.logging.Level;
import java.util.logging.Logger;
import neurosky.*;
import org.json.*;

/**
 *
 * @author siva
 */
public class EegMachine {
    
	public static ThinkGearSocket neuroSocket;
        public static Boolean running=false;
        public static boolean debugflag=false;
	public static int attention=10;
	public static int meditation=10;
        public static int blinkstrength=0;
        public static int manualblink=0;
        public static int delta=0,theta=0,low_alpha=0,high_alpha=0,low_beta=0,high_beta=0,low_gamma=0,mid_gamma=0;
        public static int[] raw;
        public static int filter=0,highpass=400,lowpass=-170;
        public EegMachine(){
            
        }
       
	public void setup() {
            if(running!=true){

	  neuroSocket = new ThinkGearSocket(this);
	  try {
	    neuroSocket.start();
            running=neuroSocket.isRunning();
	  } 
	  catch (Exception e) {
	    Debug.sendprintmsg("Is ThinkGear running??");
	  }
            }
            else{
                Debug.sendprintmsg("Thread already running");
            }
	
	}
/*
	public void draw() {
	  //background(0,0,0,50);
	  Debug.sendprintmsg("Attention: "+attention);
	  //Debug.sendprintmsg(width/2,height/2,attention*3,attention*3);
	  Debug.sendprintmsg("Meditation: "+meditation);
	  //Debug.sendprintmsg(width/2,height/2,meditation*3,meditation*3);
	}
*/
	public void poorSignalEvent(int sig) {
          if(debugflag)
	  Debug.sendprintmsg("SignalEvent,POOR SIGNAL: "+sig);
	}

	public void attentionEvent(int attentionLevel) {
          attention = attentionLevel;
	  if(debugflag)
          Debug.sendprintmsg("Attention Level: " + attentionLevel);
          if(Plot.isshow)
          Plot.updateattentionData(attentionLevel);
        }

	public void meditationEvent(int meditationLevel) {
	  meditation = meditationLevel;
          if(debugflag)
          Debug.sendprintmsg("Meditation Level: " + meditationLevel);
          if(Plot.isshow)
          Plot.updatemeditationData(meditationLevel);
        }

	public void blinkEvent(int blinkStrength) {
          blinkstrength=blinkStrength;
          if(debugflag)
	  Debug.sendprintmsg("blinkStrength: " + blinkStrength);
          if(Plot.isshow)
          Plot.updateblinkData(blinkStrength);
	}

	 public void eegEvent(int delta, int theta, int low_alpha, int high_alpha, int low_beta, int high_beta, int low_gamma, int mid_gamma) {
           EegMachine.delta=delta;
           EegMachine.theta=theta;
           EegMachine.low_alpha=low_alpha;
           EegMachine.high_alpha=high_alpha;
           EegMachine.low_beta=low_beta;
           EegMachine.high_beta=high_beta;
           EegMachine.low_gamma=low_gamma;
           EegMachine.mid_gamma=mid_gamma;
          if(debugflag){
	  Debug.sendprintmsg("delta Level: " + delta);
	  Debug.sendprintmsg("theta Level: " + theta);
	  Debug.sendprintmsg("low_alpha Level: " + low_alpha);
	  Debug.sendprintmsg("high_alpha Level: " + high_alpha);
	  Debug.sendprintmsg("low_beta Level: " + low_beta);
	  Debug.sendprintmsg("high_beta Level: " + high_beta);
	  Debug.sendprintmsg("low_gamma Level: " + low_gamma);
	  Debug.sendprintmsg("mid_gamma Level: " + mid_gamma);
          }
          if(Plot.isshow){
              Plot.updatedeltaData(delta);
              Plot.updatethetaData(theta);
              Plot.updatelow_alphaData(low_alpha);
              Plot.updatehigh_alphaData(high_alpha);
              Plot.updatelow_betaData(low_beta);
              Plot.updatehigh_betaData(high_beta);
              Plot.updatelow_gammaData(low_gamma);
              Plot.updatemid_gammaData(mid_gamma);
          }
          }
	
            
	public void rawEvent(int[] raw) {
         //calc manualblink
          for(int i=0;i<raw.length;i++)
          {
              if(raw[i]>=highpass)filter=1;
              if(raw[i]<=lowpass && filter==1){
                  //from highpass to lowpass reset filter and blink detected
                  filter=0;
                  feedmanualblink();
                  //Debug.sendprintmsg("manualblink: "+manualblink);
                  try {
                      Thread.sleep(150);
                  } catch (InterruptedException ex) {}
              } 
          }
         EegMachine.raw=raw;
         if(debugflag)
	 Debug.sendprintmsg("rawEvent Level: " + raw);
         if(Plot.isshow)
         Plot.updateeegData(raw);
	}	
        
        public void setBlinksensitivity(int x,int y){
            highpass=x;
            lowpass=y; 
        }
        public void feedmanualblink(){
            ++manualblink;
            if(manualblink==10)manualblink=0;
        }

	public void stop() {//only stops the last start thread
           if(running!=false){
	  neuroSocket.stop();
           running=neuroSocket.isRunning();
           }
           else{
           Debug.sendprintmsg("Already Thread stopped");
           }
	  //super.stop();
	}

    
}
