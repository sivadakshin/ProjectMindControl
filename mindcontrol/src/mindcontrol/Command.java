/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindcontrol;

/**
 *
 * @author siva
 */
public interface Command {
   public String getCmdname();
   public void setCmdname(String cmd);
   public String getCmdconfig();
   public void setCmdconfig();
   public boolean getConfigstatus();
   public void setConfigstatus(boolean configstatus);
   public boolean getFlag();
   public void setFlag(boolean flag);
   public void run(Trigger obj);
   
}
