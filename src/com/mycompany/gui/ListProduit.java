/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entities.Service;
import com.mycompany.services.ServiceProduit;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MSI
 */
public class ListProduit extends Form{
    
    public ListProduit(Form previous) {
   getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
        
        setTitle("Liste des produits");
        setLayout(BoxLayout.y());
        
             
        Map<String, Object> parsedData = ServiceProduit.getInstance().getAllProduit();
        List<Map<String, Object>> dataList = (List<Map<String, Object>>) parsedData.get("root");
        
        int len = dataList.size();
         Container container = new Container(new BoxLayout(BoxLayout.Y_AXIS));
             for (int i = 0; i < len; i++) {
            Map<String, Object> dataItem = dataList.get(i);
            
            Label titreLabel = new Label("Nom : " + dataItem.get("nom"));
            Label typeLabel = new Label("Description : " + dataItem.get("description"));
            Label descriptionLabel = new Label("Prix : " + dataItem.get("prix"));
            
            Button delete = new Button("Supprimer produit");
                       

            
        delete.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent evt) {
        
        System.out.println(dataItem.get("id").getClass().getName());
        System.out.println("---------------------------------------------------------");
            double id = (double) dataItem.get("id");
            System.out.println("-------"+id+"-----------------");
        ServiceProduit.getInstance().deleteProduit((int) id);
        
    }
});
        Label tri= new Label("******************");
             tri.setAlignment(CENTER);
      
            container.addAll(titreLabel, typeLabel, descriptionLabel,delete,tri);
    
    
       
    
    }
             add(container);
}
    
}
