/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.services.ServiceUser;

/**
 *
 * @author MSI
 */
public class Home extends Form{
    
    private Form current;
    private Resources theme;
    
     public Home() {
   
    
    //getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previos.showBack());
    
         
        current=this;
        setTitle("Welcome Admin");
        setLayout(BoxLayout.y());
       
        getToolbar().addCommandToSideMenu("Ajout Client", null, ev -> {
                    new AjoutUser(current);
                });
        getToolbar().addCommandToSideMenu("List Clients", null, ev -> {
                    new ListClients(current);
                });
        getToolbar().addCommandToSideMenu("Profile", null, ev -> {
                    new ProfilAdmin(current);
                });
         getToolbar().addCommandToSideMenu("LogOut", null, ev -> {
                    new SignInForm(theme);
                    Dialog.show("Success","Log out succesfully!","OK",null);
                });
        show();
        
      
        
    }
    
}
