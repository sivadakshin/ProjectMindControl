/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindcontrol;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siva
 */
public class Plot {
    public static LiveChart livechart;
    public static boolean isshow=false;
    public static void plot(){
    }
    public static void setupchart(){
          livechart=new LiveChart();
            livechart.start();
    }
    //only if chart is shown you can update it with values
     public static void showchart(){
        if(livechart!=null){
          
            livechart.show();
            isshow=true;
            /*
             try{Thread.sleep(1000);}catch(Exception e){}
              new Thread((new Runnable() {
        @Override
        public void run() {
            for(int i=0;i<20;i++){
                test(i);
                try{Thread.sleep(200);}catch(Exception e){}
            }
         }
      })).start();
              */
        }
        else{
            Debug.sendprintmsg("livechat is null");
        }
        }  public static void test(int meditationLevel) {
	  Debug.sendprintmsg("Meditation Level: " + meditationLevel);
          updatemeditationData(meditationLevel);
	}
     
public static void updatemeditationData(int data)
{
    livechart.updatemeditationData(data);
}
public static void updateattentionData(int data)
{
    livechart.updateattentionData(data);
}
public static void updateeegData(int[] data)
{
      new Thread((new Runnable() {
        @Override
        public void run() {
            try {
                livechart.updateeegData(Arrays.copyOfRange(data, 0, 128));
                Thread.sleep(250);
                livechart.updateeegData(Arrays.copyOfRange(data, 128,256));
                Thread.sleep(250);
                livechart.updateeegData(Arrays.copyOfRange(data, 256, 384));
                Thread.sleep(250);
                livechart.updateeegData(Arrays.copyOfRange(data, 384, 512));
                //livechart.updateeegData(data);
            } catch (InterruptedException ex) {
                Logger.getLogger(Plot.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
      })).start();
}
public static void updatedeltaData(int data)
{
    livechart.updatedeltaData(data);
}
public static void updatethetaData(int data)
{
    livechart.updatethetaData(data);
}
public static void updatelow_alphaData(int data)
{
    livechart.updatelow_alphaData(data);
}
public static void updatehigh_alphaData(int data)
{
    livechart.updatehigh_alphaData(data);
}
public static void updatelow_betaData(int data)
{
    livechart.updatelow_betaData(data);
}
public static void updatehigh_betaData(int data)
{
    livechart.updatehigh_betaData(data);
}
public static void updatelow_gammaData(int data)
{
    livechart.updatelow_gammaData(data);
}
public static void updatemid_gammaData(int data)
{
    livechart.updatemid_gammaData(data);
}
public static void updateblinkData(int data)
{
    livechart.updateblinkData(data);
}
}
