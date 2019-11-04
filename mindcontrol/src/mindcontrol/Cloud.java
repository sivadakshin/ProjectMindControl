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
public interface Cloud {
    public String getCloudname();
    public void setCloudname(String name);
    public String getCloudconfig();
    public void setCloudconfig();
    public boolean isConfigured();
    public void run(String device);
    
}
