/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import java.util.Map;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

import com.mycompany.services.ServiceCommande;
import com.mycompany.services.ServiceReclamation;

import java.util.List;

/**
 *
 * @author bhk
 */
public class ListCommandeForm extends Form {
    

     public ListCommandeForm(Form previous) {
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
         setTitle("Liste des commandes");
         setLayout(BoxLayout.y());
       Map<String, Object> parsedData = ServiceCommande.getInstance().getAllOrder();
    List<Map<String, Object>> dataList = (List<Map<String, Object>>) parsedData.get("root");
    int len = dataList.size();
         Container container = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    for (int i = 0; i < len; i++) {
        Map<String, Object> dataItem = dataList.get(i);
       // Label idLabel = new Label("ID: " + dataItem.get("id"));
        //Label iduserLabel = new Label("User: " + dataItem.get("user"));
        Label createdAtLabel = new Label("createdAt: " + dataItem.get("createdAt"));
        Label isPaidLabel = new Label("isPaid: " + dataItem.get("isPaid"));
        Label referenceLabel = new Label("reference: " + dataItem.get("reference"));
        Label tri= new Label("******************");
             tri.setAlignment(CENTER);
             Button btnSupprimer = new Button("Supprimer ");
     
                btnSupprimer.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent evt) {


                       double id = (double) dataItem.get("id");
                   ServiceCommande.getInstance().deleteCommande((int) id);


               }
           });
                
        container.addAll(createdAtLabel, isPaidLabel, referenceLabel,btnSupprimer,tri);
                
    }
    add(container);   
     }
}
