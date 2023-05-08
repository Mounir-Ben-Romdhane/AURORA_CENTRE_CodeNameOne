/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Service;
import com.mycompany.gui.Home;
import com.mycompany.utils.Statics;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author MSI
 */
public class ServiceProduit {
    
    
    private ConnectionRequest serv;
    public ArrayList<Service> service;

    public static ServiceProduit instance = null;
    public boolean resultOK;
    boolean res = false;

    private ServiceProduit() {
        serv = new ConnectionRequest();
    }

        public static ServiceProduit getInstance() {
        if (instance == null) {
            instance = new ServiceProduit();
        }
        return instance;
    }
        
         
    public void deleteProduit(int id) {
       System.out.println(id);
        String url = Statics.BASE_URL + "/produit/api/deleteProduit?id="+id;

        serv.setUrl(url);
        serv.setPost(false);
        
        serv.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                    Dialog.show("Success","Produit supprimer avec succes!","OK",null);
                    new Home().show();
                    serv.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(serv);
        
    }
    
    
     public Map<String, Object> getAllProduit() {
        
    serv = new ConnectionRequest();
    String url = Statics.BASE_URL+"/produit/api/getProduit";
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
