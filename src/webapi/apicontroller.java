/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapi;

import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.net.ssl.SSLContext;
import json.*;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Shehab
 */
public class apicontroller {
    private mainGui gui;

    public apicontroller(mainGui gui) {
        this.gui = gui;
        gui.getjButton1().addActionListener(new gettemp());
    }
    class gettemp implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
 try {

                // This code ignores SSL certificates when dealing with HTTPS
                SSLContext sslcontext = SSLContexts.custom()
                        .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                        .build();
                SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext);
                CloseableHttpClient httpclient = HttpClients.custom()
                        .setSSLSocketFactory(sslsf)
                        .build();
                Unirest.setHttpClient(httpclient);

                String json = Unirest.get("http://api.oceandrivers.com/v1.0/getAemetStation/aeropuertopalma/lastdata/").asString().getBody();
                temprature result = new Gson().fromJson(json, temprature.class);
               // Float res = result.getResult();
               // gui.getjLabel3().setText(res.toString());
               
               
              // CurrencyResponse result = new Gson().fromJson(json, CurrencyResponse.class);

                // Get USD from text field
               // float usd = Float.parseFloat(gui.getTxtUSD().getText());
                
                // Get Rate from JSON response
                float rate = result.getResult();
                
                // Convert by multiplying USD with its actual rate
                //float egp = 10 * rate;

                // Finally, setting the result
                gui.getjLabel3().setText(rate + "");
                
            } catch (Exception e) {
                System.out.println("EXCEPTION: " + e.getMessage());
            }

        }
    }
   
    
}
