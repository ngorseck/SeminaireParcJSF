package com.cours.entities;

public class Service {
    //attributs
    private int idS;
    private String nomS;
    private int port;
    private Serveur serveur = new Serveur();


    //contructeurs

    public Service() {
    }

    public Service(String nomS, int port, Serveur serveur) {
        this.nomS = nomS;
        this.port = port;
        this.serveur = serveur;
    }
    //methodes
    public String getNomS() {
        return nomS;
    }

    public void setNomS(String nomS) {
        this.nomS = nomS;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Serveur getServeur() {
        return serveur;
    }

    public void setServeur(Serveur serveur) {
        this.serveur = serveur;
    }

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }
}
