/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.util.Date;



/**
 *
 * @author bhk
 */
public class Commande {
     private int id,user_id;

    
    String createdAt;
    private boolean isPaid;
    private String reference;

    public Commande() {
    }

    public Commande(String createdAt, String reference) {
        this.createdAt = createdAt;
        this.reference = reference;
    }

    public Commande(String reference) {
        this.reference = reference;
    }
    
    

    
    
    
    public Commande(int id, String createdAt, boolean isPaid, String reference) {
        this.id = id;
        this.createdAt = createdAt;
        this.isPaid = isPaid;
        this.reference = reference;
        
        
    }
    

    public Commande( String createdAt, boolean isPaid, String reference) {
   
        this.createdAt = createdAt;
        this.isPaid = isPaid;
        this.reference = reference;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", user_id=" + user_id + ", createdAt=" + createdAt + ", isPaid=" + isPaid + ", reference=" + reference + '}';
    }

  
   
   
    
    
   
}
