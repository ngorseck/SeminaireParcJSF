package com.cours.dao;

import com.cours.entities.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements IService {
    private DB db = new DB();
    private int ok;
    @Override
    public int add(Service service) {
        String sql = "INSERT INTO service VALUES(NULL, ?, ?, ?)";
        try {
            //initialisation des requetes
            db.initPrepar(sql);
            //passage de valeurs à la requête sql
            db.getPstm().setString(1, service.getNomS());
            db.getPstm().setInt(2, service.getPort());
            db.getPstm().setInt(3, service.getServeur().getIdServ());
            //execution
            ok = db.executeMaj();
            db.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int delete(int idS) {
        String sql = "DELETE FROM service WHERE idS = ?";
        try {
            //initialisation des requetes
            db.initPrepar(sql);
            //passage de valeurs à la requête sql
            db.getPstm().setInt(1, idS);
            //execution
            ok = db.executeMaj();
            db.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int update(Service service) {
        String sql = "UPDATE service SET nomS = ?, port = ?, idServ = ? WHERE idS = ?";
        try {
            //initialisation des requetes
            db.initPrepar(sql);
            //passage de valeurs à la requête sql
            db.getPstm().setString(1, service.getNomS());
            db.getPstm().setInt(2, service.getPort());
            db.getPstm().setInt(3, service.getServeur().getIdServ());
            db.getPstm().setInt(4, service.getIdS());
            //execution
            ok = db.executeMaj();
            db.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public Service get(int idS) {
        String sql = "SELECT * FROM service WHERE idS =?";
        Service service = null;
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1, idS);
            ResultSet rs = db.executeSelect();
            if(rs.next()){
                service = new Service();
                service.setIdS(rs.getInt("idS"));
                service.setNomS(rs.getString("nomS"));
                service.setPort(rs.getInt("port"));
                service.setServeur(new ServeurImpl().get(rs.getInt("idServ")));
            }
            db.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return service;
    }

    @Override
    public List<Service> list() {
        String sql = "SELECT * FROM service";
        Service service = null;
        List<Service> services = new ArrayList<Service>();
        try {
            db.initPrepar(sql);

            ResultSet rs = db.executeSelect();
            while(rs.next()){
                service = new Service();
                service.setIdS(rs.getInt("idS"));
                service.setNomS(rs.getString("nomS"));
                service.setPort(rs.getInt("port"));
                service.setServeur(new ServeurImpl().get(rs.getInt("idServ")));

                services.add(service);
            }
            db.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return services;
    }
}
