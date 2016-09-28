/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.madeinhome.ejb;

import co.com.madeinhome.model.Payment;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marco
 */
@Local
public interface PaymentFacadeLocal extends AbstractFacadeLocal<Payment>{

}
