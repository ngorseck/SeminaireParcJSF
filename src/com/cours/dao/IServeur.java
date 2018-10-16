package com.cours.dao;

import com.cours.entities.Serveur;

import java.util.List;

public interface IServeur {
    public int add(Serveur serveur);
    public int delete(int idServ);
    public int update(Serveur serveur);
    public Serveur get(int idServ);
    public List<Serveur> list();
}
