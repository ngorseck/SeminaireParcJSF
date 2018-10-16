package com.cours.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB {
    //pour l'ouverture de la connexion à la base
    private Connection connection;
    //pour la preparation des requetes
    private PreparedStatement pstm;
    //pour les requetes de type SELECT
    private ResultSet rs;
    //pour les requetes de type mise a jour
    private int ok;

    public void getConnection(){
        String url = "jdbc:mysql://localhost:3306/parcinfoseminaire";
        String user = "root";
        String password = "passer";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void initPrepar(String sql){
        try {
            getConnection();
            pstm = connection.prepareStatement(sql);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public int executeMaj(){
        try {
            ok = pstm.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }
    public ResultSet executeSelect(){
        try {
            rs = pstm.executeQuery();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }
    public PreparedStatement getPstm(){
        return pstm;
    }
    public void close() {
    	if(connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
}
