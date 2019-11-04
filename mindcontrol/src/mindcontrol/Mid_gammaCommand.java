/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindcontrol;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siva
 */
public class Mid_gammaCommand implements Command {
String cmdname,time,threshold,operation;
private boolean configstatus;
//to prevent catching of the flag variable and avoiding system.out.println to syncronize use volatile.
private volatile boolean flag;
private int clock,mid_gamma;
private boolean clockflag,detectflag;
Mid_gammaCommand(){
      cmdname="mid_gamma";
      configstatus=false;
      flag=false;
      clock=0;
      mid_gamma=0;
      detectflag=false;
      clockflag=false;
}
    @Override
    public String getCmdname() {
   return cmdname;
    }

    @Override
    public void setCmdname(String cmdname) {
       this.cmdname=cmdname;
    }
    @Override
    public boolean getConfigstatus() {
   return configstatus;
    }

    @Override
    public void setConfigstatus(boolean configstatus ) {
       this.configstatus=configstatus;
    }

    @Override
    public String getCmdconfig() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void setFlag(boolean flag ) {
       this.flag=flag;
    }

   @Override
   public boolean getFlag() {
   return flag;
    }

    @Override
    public void setCmdconfig() {
        new Mid_gammaConfigView().getConfig(this);
    }

    @Override
    public void run(Trigger current) {
        boolean prev=false;
        while(!flag){
            try {
                mid_gamma=EegMachine.mid_gamma;
                //count clock if mid_gamma is detected and clock not running
                if(operation.equals("greater than (>)") && mid_gamma > Integer.parseInt(threshold)){detectflag=true;}
                else if(operation.equals("lesser than (<)") && mid_gamma < Integer.parseInt(threshold)){detectflag=true;}
                else if(operation.equals("equals (=)") && mid_gamma == Integer.parseInt(threshold)){detectflag=true;} 
                else {detectflag=false;if(prev!=detectflag)Debug.sendprintmsg("value not satisfied threshold condition");}
                prev=detectflag;
                if(detectflag && !clockflag){
                    clockflag=true;
                    new Thread() {
                        @Override public void run () {
                            Debug.sendprintmsg("clock started");
                            clocker();
                        }
                    }.start(); 
                }
                if(detectflag==true && clock==Integer.parseInt(time)){
                    try {
                        Debug.sendprintmsg("fired");
                        current.fire();
                        Thread.sleep(1200);
                    } //use thread.sleep(1500)instead of reset
                    catch (InterruptedException ex) {}
                }
                //System.out.println(1);
                Thread.sleep(100);
            } catch (InterruptedException ex) {}
        }
    }
    public void reset(){
        clock=0;
        clockflag=false;
        mid_gamma=0;
    }
    
    public void clocker(){
        int temp=0;
        clock=0;
        long createdMillis = System.currentTimeMillis();
        //stop clock if detectflag is false
        while(clock<Integer.parseInt(time) && detectflag==true){
            long nowMillis = System.currentTimeMillis();
            clock=(int)((nowMillis - createdMillis) / 1000);
            if(clock!=temp)
            //Debug.sendprintmsg(clock);
            temp=clock;
            //System.out.println((nowMillis - createdMillis) / 1000);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {}
            
		}
        //after clocking reset clock and blinkstrength
        Debug.sendprintmsg("clock stopped");
        reset();
        /*
    try {
        Thread.sleep(50);
    } catch (InterruptedException ex) {}
        */
    }    
}
