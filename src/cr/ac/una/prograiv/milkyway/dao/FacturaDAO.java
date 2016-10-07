/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograiv.milkyway.dao;

import cr.ac.una.prograiv.milkyway.domain.Factura;
import cr.ac.una.prograiv.milkyway.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Admin
 */
public class FacturaDAO extends HibernateUtil implements IBaseDAO<Factura, Integer>{       
    @Override
    public void save(Factura o) {
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
    public Factura merge(Factura o) throws HibernateException {
        try {
            iniciaOperacion();
            o = (Factura) getSesion().merge(o);
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
    public void delete(Factura o) {
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
    public Factura findById(Integer id) {
        Factura factura = null;

        try {
            iniciaOperacion();
            factura = (Factura) getSesion().get(Factura.class, id);
        } finally {
            getSesion().close();
        }
        return factura;
    }
    @Override
    public List<Factura> findAll() {
        List<Factura> listaExpertostema;
        try {
            iniciaOperacion();//HQL
            listaExpertostema = getSesion().createQuery("from Factura").list();
        } finally {
            getSesion().close();
        }

        return listaExpertostema;
    }
    
    
}
