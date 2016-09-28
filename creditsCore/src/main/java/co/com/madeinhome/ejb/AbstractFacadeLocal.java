/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.madeinhome.ejb;

import java.util.List;

/**
 *
 * @author Marco
 * @param <T>
 */
public interface AbstractFacadeLocal<T> {
    
    void create(T entity);

    void edit(T entity);

    void remove(T entity);

    T find(T entity);

    List<T> findAll();

    List<T> findRange(int[] range);

    int count();
    
}
