/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Service;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;



/**
 *
 * @author mfmma
 */
public class ServiceService {
    
    private ConnectionRequest serv;
    public ArrayList<Service> service;

    public static ServiceService instance = null;
    public boolean resultOK;

    private ServiceService() {
        serv = new ConnectionRequest();
    }

        public static ServiceService getInstance() {
        if (instance == null) {
            instance = new ServiceService();
        }
        return instance;
    }
    
    
    
    public boolean ajoutService(Service service){
        
        String typeS=service.getTypeS();
        String descriptionS=service.getDescriptionS();
        String titreS=service.getTitreS();
        String dateS = service.getDateS();
        
        String url = Statics.BASE_URL+"api/addServiceApi/?titreS="+service.getTitreS()+"&descriptionS="+service.getDescriptionS()
                + "&typeS="+service.getTypeS()+"&dateS="+service.getDateS();

        serv.setUrl(url);
        serv.setPost(false);
        
       serv.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = serv.getResponseCode() == 200; //Code HTTP 200 OK
                serv.removeResponseListener(this);
            }
        });
        
 
        
        //Execution de la request
        NetworkManager.getInstance().addToQueueAndWait(serv);
        return resultOK;

}
     
    
    public Map<String, Object> getAllServices() {
        
    serv = new ConnectionRequest();
    String url = Statics.BASE_URL+"api/getService";
    serv.setUrl(url);
    serv.setPost(false);
    final Map<String, Object>[] response = new Map[]{null};
    serv.addResponseListener(new ActionListener<NetworkEvent>() {
        @Override
        public void actionPerformed(NetworkEvent evt) {
            JSONParser j = new JSONParser();
            serv.removeResponseListener(this);
            String json = new String(serv.getResponseData()) + "";
            try {
                response[0] = j.parseJSON(new CharArrayReader(json.toCharArray()));
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    });
    NetworkManager.getInstance().addToQueueAndWait(serv);
    return response[0];
}
    
}
