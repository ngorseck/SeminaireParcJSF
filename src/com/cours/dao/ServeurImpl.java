package com.cours.dao;

import com.cours.entities.Serveur;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServeurImpl implements IServeur {
    private DB db = new DB();
    private ResultSet rs;
    private int ok;

    @Override
    public int add(Serveur serveur) {
        String sql = "INSERT INTO serveur VALUES(NULL, ?, ?, ?)";
        try {
            //initialisation des requetes
            db.initPrepar(sql);
            //passage de valeurs à la requête sql
            db.getPstm().setString(1, serveur.getNomServ());
            db.getPstm().setString(2, serveur.getAdripServ());
            db.getPstm().setString(3, serveur.getSalleServ());
            //execution
            ok = db.executeMaj();
            db.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int delete(int idServ) {
        String sql = "DELETE FROM serveur WHERE idServ = ?";
        try{
            db.initPrepar(sql);
            db.getPstm().setInt(1, idServ);
            ok = db.executeMaj();
            db.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int update(Serveur serveur) {
        String sql = "UPDATE serveur SET nomServ = ?, adripServ = ?, salleServ = ? WHERE idServ = ?";
        try {
            //initialisation des requetes
            db.initPrepar(sql);
            //passage de valeurs à la requête sql
            db.getPstm().setString(1, serveur.getNomServ());
            db.getPstm().setString(2, serveur.getAdripServ());
            db.getPstm().setString(3, serveur.getSalleServ());
            db.getPstm().setInt(4, serveur.getIdServ());
            //execution
            ok = db.executeMaj();
            db.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public Serveur get(int idServ) {
        String sql = "SELECT * FROM serveur WHERE idServ = ?";
        Serveur serveur = null;
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1,idServ);
            ResultSet rs = db.executeSelect();
            if(rs.next()){
                serveur = new Serveur();
                serveur.setIdServ(rs.getInt(1));
                serveur.setNomServ(rs.getString(2));
                serveur.setAdripServ(rs.getString(3));
                serveur.setSalleServ(rs.getString(4));
            }
            db.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return serveur;
    }

    @Override
    public List<Serveur> list() {
        String sql = "SELECT * FROM serveur";
        Serveur serveur = null;
        List<Serveur> serveurs = new ArrayList<Serveur>();
        try {
            db.initPrepar(sql);

            ResultSet rs = db.executeSelect();
            while(rs.next()){
                serveur = new Serveur();
                serveur.setIdServ(rs.getInt(1));
                serveur.setNomServ(rs.getString(2));
                serveur.setAdripServ(rs.getString(3));
                serveur.setSalleServ(rs.getString(4));
                serveurs.add(serveur);
            }
            db.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return serveurs;
    }
}
