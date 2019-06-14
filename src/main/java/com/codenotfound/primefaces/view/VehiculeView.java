package com.codenotfound.primefaces.view;

import com.codenotfound.primefaces.model.Vehicule;
import com.codenotfound.primefaces.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
//@ViewScoped
@SessionScoped
public class VehiculeView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Autowired
    private VehiculeRepository vehiculeRepository;
    private Vehicule vehicule;
    private String message;

    public String getMessage() {
        return message;
    }

    private List<Vehicule> vehicules;

    public void setVehicules(List<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public List<Vehicule> getVehicules() {
        return   vehicules=vehiculeRepository.findAll();
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public VehiculeView(){

        vehicule=new Vehicule();
       // vehicules=vehiculeRepository.findAll();

    }

    @PostConstruct
    public void init(){

    }

    public String addVehicule(){
        try {
            Vehicule v=vehiculeRepository.save(vehicule);
            if(v==null){
                System.out.println("Vehicule non enregistré");
            }
            else System.out.println("Vehicule enregistré");
             this.vehicule=new Vehicule();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "vehicule?faces-redirect-true";
    }

    public String editVehicule(Vehicule vehicule){
            this.vehicule = vehicule ;
            message=this.vehicule.getMatricule();
        System.out.println("message"+message);
           // return "vehiculeEdit";
        return "vehiculeEdit?faces-redirect=true";
        //return "vehicule?faces-redirect=true";
    }

    public String UpdateVehicule(){
        vehiculeRepository.save(vehicule);
        vehicule=new Vehicule();
        return "vehicule?faces-redirect=true";
    }
    public String deleteVehicule(Vehicule v){
        System.out.println("delete vehicule"+v.getMatricule());
        vehiculeRepository.delete(v);
        return "vehicule?faces-redirect=true";
    }
}
