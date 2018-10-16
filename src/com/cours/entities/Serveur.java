package com.cours.entities;

public class Serveur {
    //attributs
    private int idServ;
    private String nomServ;
    private String adripServ;
    private String salleServ;

    //constructeurs
    public Serveur(){

    }
    public Serveur(String nomServ, String adripServ, String salleServ){
        this.nomServ = nomServ;
        this.adripServ = adripServ;
        this.salleServ = salleServ;
    }
    //methodes
    public String getNomServ(){
        return this.nomServ;
    }
    public void setNomServ(String nomServ){
        this.nomServ = nomServ;
    }

    public String getAdripServ(){
        return this.adripServ;
    }
    public void setAdripServ(String adripServ){
        this.adripServ = adripServ;
    }

    public String getSalleServ(){
        return this.salleServ;
    }
    public void setSalleServ(String salleServ){
        this.salleServ = salleServ;
    }

    public int getIdServ() {
        return idServ;
    }

    public void setIdServ(int idServ) {
        this.idServ = idServ;
    }
}
