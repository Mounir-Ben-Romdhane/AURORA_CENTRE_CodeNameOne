/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entities.Service;
import com.mycompany.services.ServiceService;

import java.util.Map;
import java.util.List;


/**
 *
 * @author mfmma
 */
public class ListServiceFront extends Form {
    
    private Form current;
//    
//     public ListServiceForm(Form previous) {
//         
//         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
//             
//        Map<String, Object> parsedData = ServiceService.getInstance().getAllServices();
//        List<Map<String, Object>> dataList = (List<Map<String, Object>>) parsedData.get("root");
//        
//        int len = dataList.size();
//         Container container = new Container(new BoxLayout(BoxLayout.Y_AXIS));
//             for (int i = 0; i < len; i++) {
//            Map<String, Object> dataItem = dataList.get(i);
//            
//            Label titreLabel = new Label("Titre: " + dataItem.get("titreS"));
//            Label typeLabel = new Label("Type: " + dataItem.get("typeS"));
//            Label descriptionLabel = new Label("Description: " + dataItem.get("descriptionS"));
//            //Label dateLabel = new Label("Date: " + dataItem.get("date_reclamation"));
//            container.addAll(titreLabel, typeLabel, descriptionLabel);
//    }
//    add(container);
//       
//    }

    
    public ListServiceFront(Form previous) {
        current=this;
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
        
        setTitle("Liste des services");
        setLayout(BoxLayout.y());
        
             
        Map<String, Object> parsedData = ServiceService.getInstance().getAllServices();
        List<Map<String, Object>> dataList = (List<Map<String, Object>>) parsedData.get("root");
        
        int len = dataList.size();
         Container container = new Container(new BoxLayout(BoxLayout.Y_AXIS));
             for (int i = 0; i < len; i++) {
            Map<String, Object> dataItem = dataList.get(i);
            
            Label titreLabel = new Label("Titre: " + dataItem.get("titreS"));
            Label typeLabel = new Label("Type: " + dataItem.get("typeS"));
            Label descriptionLabel = new Label("Description: " + dataItem.get("descriptionS"));
            

        
    

            Label tri= new Label("******************");
             tri.setAlignment(CENTER);
      
            container.addAll(titreLabel, typeLabel, descriptionLabel,tri);
    }
    add(container);
       
    
    }
   
}
