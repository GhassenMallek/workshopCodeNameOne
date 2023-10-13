/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.utils.Static;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author pc
 */
public class Service {
       public static Service instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
     private Service() {
         req = new ConnectionRequest();
    }

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }
    
     public boolean Auth(String login,String password) {
       
       String url = Static.BASE_URL +"login.php";
       
      
    
       req.setUrl(url);
       req.setPost(false);
       req.addArgument("login", login);
       req.addArgument("password", password);
       req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                   
                   String ch = new String(req.getResponseData(), "utf-8");
                    
                    if (ch.equalsIgnoreCase("ok")) {
                        resultOK=true;
                    } else {
                        resultOK=false;
                    }
                       
                    //   req.removeResponseListener(this);
                } catch (UnsupportedEncodingException ex) {
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
}
