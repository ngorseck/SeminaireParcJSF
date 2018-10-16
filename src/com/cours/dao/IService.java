package com.cours.dao;

import com.cours.entities.Service;

import java.util.List;

public interface IService {
    public int add(Service service);
    public int delete(int idS);
    public int update(Service service);
    public Service get(int idS);
    public List<Service> list();
}
