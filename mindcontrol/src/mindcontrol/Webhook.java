/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindcontrol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siva
 */
public class Webhook implements Cloud{
    String cloudname;
    public String key;
    public String events;
    @Override
    public String getCloudname()
    {
        return cloudname;
    }
    @Override
    public void setCloudname(String cloudname)
    {
    this.cloudname=cloudname;
    }
    @Override
    public String getCloudconfig()
    {
    return cloudname+"\n"+key+"\n"+events;    
    }
    @Override
    public void setCloudconfig()
    { 
        new WebhookView().getConfig(this);
        /*  
        try {
    Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Webhook.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
        System.out.println(cloudname+key+events);
    */
                }
    @Override
    public boolean isConfigured(){
        if(cloudname!=null && key!=null && events!=null)
            return true;
        else
            return false;
    }
    @Override
    public void run(String device){
        //do something
         String result=fetchHtml("https://maker.ifttt.com/trigger/"+device+"/with/key/"+key);
           Debug.sendprintmsg(result); 
    }
    public String fetchHtml(String urlString)
    {
        String line;
        StringBuffer html = new StringBuffer();

        try
        {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            // Fake the User-Agent
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_1) AppleWebKit/537.36 " +
                    "(KHTML, like Gecko) Chrome/32.0.1700.107 Safari/537.36");

            // Check the HTTP response code
            if(conn.getResponseCode() == 200)
            {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

                // Reading the HTML
                while((line = in.readLine()) != null)
                    html.append(line.trim());

                in.close();
            }
            else{
                System.out.println("url error cant retrieve html"+conn.getResponseCode());
            }

            // Close the connection
            conn.disconnect();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return html.toString();
    }
}
