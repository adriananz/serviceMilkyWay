/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograiv.milkyway.dao;


import cr.ac.una.prograiv.milkyway.domain.Tema;
import cr.ac.una.prograiv.milkyway.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Admin
 */
public class TemaDAO extends HibernateUtil implements IBaseDAO<Tema, Integer>{       
    @Override
    public void save(Tema o) {
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
    public Tema merge(Tema o) throws HibernateException {
        try {
            iniciaOperacion();
            o = (Tema) getSesion().merge(o);
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
    public void delete(Tema o) {
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
    public Tema findById(Integer id) {
        Tema tema = null;

        try {
            iniciaOperacion();
            tema = (Tema) getSesion().get(Tema.class, id);
        } finally {
            getSesion().close();
        }
        return tema;
    }
    @Override
    public List<Tema> findAll() {
        List<Tema> listaTema;
        try {
            iniciaOperacion();//HQL
            listaTema = getSesion().createQuery("from Tema").list();
        } finally {
            getSesion().close();
        }

        return listaTema;
    }
    
    
}