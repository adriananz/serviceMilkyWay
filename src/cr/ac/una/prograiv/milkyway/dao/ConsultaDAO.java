/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograiv.milkyway.dao;

import cr.ac.una.prograiv.milkyway.domain.Consulta;
import cr.ac.una.prograiv.milkyway.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;


/**
 *
 * @author Admin
 */
public class ConsultaDAO extends HibernateUtil implements IBaseDAO<Consulta, Integer>{       
    @Override
    public void save(Consulta o) {
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
    public Consulta merge(Consulta o) throws HibernateException {
        try {
            iniciaOperacion();
            o = (Consulta) getSesion().merge(o);
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
    public void delete(Consulta o) {
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
    public Consulta findById(Integer id) {
        Consulta consulta = null;

        try {
            iniciaOperacion();
            consulta = (Consulta) getSesion().get(Consulta.class, id);
        } finally {
            getSesion().close();
        }
        return consulta;
    }
    @Override
    public List<Consulta> findAll() {
        List<Consulta> listaConsultas;
        try {
            iniciaOperacion();//HQL
            listaConsultas = getSesion().createQuery("from Consulta").list();
        } finally {
            getSesion().close();
        }

        return listaConsultas;
    }
    
    
}