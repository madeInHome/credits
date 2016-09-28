/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.madeinhome.ejb.impl;

import co.com.madeinhome.ejb.*;
import co.com.madeinhome.model.PaymentPeriod;
import co.com.madeinhome.utils.Constant;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marco
 */
@Stateless
public class PaymentPeriodFacade extends AbstractFacade<PaymentPeriod> implements PaymentPeriodFacadeLocal {

    @PersistenceContext(unitName = Constant.NOMBRE_CONEXION)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaymentPeriodFacade() {
        super(PaymentPeriod.class);
    }
    
}
