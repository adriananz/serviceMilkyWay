/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograiv.milkyway.dao;

import cr.ac.una.prograiv.milkyway.domain.Expertostema;
import cr.ac.una.prograiv.milkyway.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Admin
 */
public class ExpertostemaDAO extends HibernateUtil implements IBaseDAO<Expertostema, Integer>{       
    @Override
    public void save(Expertostema o) {
            try {
                iniciaOperacion();
                getSesion().save(o);
                getTransac().commit();
            } catch (HibernateException he) {
                manejaExcepcion(he);
                throw he;
            } finally {
                getSesion().close();
            }
    }
    @Override
    public Expertostema merge(Expertostema o) throws HibernateException {
        try {
            iniciaOperacion();
            o = (Expertostema) getSesion().merge(o);
            getTransac().commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return o;
    }
    @Override
    public void delete(Expertostema o) {
        try {
            iniciaOperacion();
            getSesion().delete(o);
            getTransac().commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            getSesion().close();
        }
    }
    @Override
    public Expertostema findById(Integer id) {
        Expertostema expertostema = null;

        try {
            iniciaOperacion();
            expertostema = (Expertostema) getSesion().get(Expertostema.class, id);
        } finally {
            getSesion().close();
        }
        return expertostema;
    }
    @Override
    public List<Expertostema> findAll() {
        List<Expertostema> listaExpertostema;
        try {
            iniciaOperacion();//HQL
            listaExpertostema = getSesion().createQuery("from Expertostema").list();
        } finally {
            getSesion().close();
        }

        return listaExpertostema;
    }
    
    
}