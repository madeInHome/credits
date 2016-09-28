/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.madeinhome.beans;

import co.com.madeinhome.ejb.PersonFacadeLocal;
import co.com.madeinhome.model.Person;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Marco
 */
@ManagedBean
@ViewScoped
public class indexBean {
    
    @EJB
    private PersonFacadeLocal personFacadeLocal;
    
    private List<Person> listPersons;

    /**
     * Creates a new instance of indexBean
     */
    public indexBean() {
    }
    
    @PostConstruct
    private void init(){
        this.listPersons = personFacadeLocal.findAll();
    }

    public List<Person> getListPersons() {
        return listPersons;
    }

   
    
    
}
