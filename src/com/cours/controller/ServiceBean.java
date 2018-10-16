package com.cours.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.cours.dao.IService;
import com.cours.dao.ServiceImpl;
import com.cours.entities.Service;

@ManagedBean(name="servicebean")
@RequestScoped
public class ServiceBean {

	private Service service = new Service();
	private List<Service> services = new ArrayList<Service>();
	private int id;
	
	private String bvalider;
	private String bannuler;
	private String bmodifier;
	private String bsupprimer;
	private IService service_dao = new ServiceImpl();
	
	public ServiceBean(){
		bvalider = "Valider";
		bannuler = "Annuler";
		services = service_dao.list();
	}
	public String getAllService(){
		services = service_dao.list();
		
		return "/view/service/liste.xhtml";
	}
	
	public String removeService(){
		if(id != 0)
			service = service_dao.get(id);
		
		service_dao.delete(service.getIdS());
		service = new Service();
		services = service_dao.list();//actualisation de la liste apres suppression
		
		return "/view/service/liste.xhtml"; 
	}
	public String updateService(){
		service_dao.update(service);
		service = new Service();
		services = service_dao.list();//actualisation de la liste apres la mise a jour
			
		return "/view/service/liste.xhtml"; 
	}
	public String editService(){
		service = service_dao.get(id);
		//gestioon des boutons (hidden et visible: valider, annuler, modifier, supprimer)
		bvalider = null;
		bannuler = null;
		bmodifier = "Modifier";
		bsupprimer = "Supprimer";
		
		services = service_dao.list();
		
		return "/view/service/liste.xhtml";
	}
	public String addService(){
		service_dao.add(service);
		service = new Service();//vider les champs au niveau du formulaire apres ajout
		services = service_dao.list();
		
		return "/view/service/liste.xhtml";
	}
	
	public String resetService(){
		service = new Service();//vider les champs au niveau du formulaire apres ajout
		services = service_dao.list();
		
		return "/view/service/liste.xhtml";
		
	} 

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBvalider() {
		return bvalider;
	}

	public void setBvalider(String bvalider) {
		this.bvalider = bvalider;
	}

	public String getBannuler() {
		return bannuler;
	}

	public void setBannuler(String bannuler) {
		this.bannuler = bannuler;
	}

	public String getBmodifier() {
		return bmodifier;
	}

	public void setBmodifier(String bmodifier) {
		this.bmodifier = bmodifier;
	}

	public String getBsupprimer() {
		return bsupprimer;
	}

	public void setBsupprimer(String bsupprimer) {
		this.bsupprimer = bsupprimer;
	}
	public String getAllServices() {
		
		return "/view/service/liste.xhtml";
	}
}
