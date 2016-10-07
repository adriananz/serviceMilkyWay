/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograiv.milkyway.dao;



import cr.ac.una.prograiv.milkyway.domain.Categoria;
import cr.ac.una.prograiv.milkyway.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author chgari
 */
public class CategoriaDAO extends HibernateUtil implements IBaseDAO<Categoria, Integer>{       
    @Override
    public void save(Categoria o) {
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
    public Categoria merge(Categoria o) throws HibernateException {
        try {
            iniciaOperacion();
            o = (Categoria) getSesion().merge(o);
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
    public void delete(Categoria o) {
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
    public Categoria findById(Integer id) {
        Categoria categoria = null;

        try {
            iniciaOperacion();
            categoria = (Categoria) getSesion().get(Categoria.class, id);
        } finally {
            getSesion().close();
        }
        return categoria;
    }
    @Override
    public List<Categoria> findAll() {
        List<Categoria> listaCategorias;
        try {
            iniciaOperacion();//HQL
            listaCategorias = getSesion().createQuery("from Categoria").list();
        } finally {
            getSesion().close();
        }

        return listaCategorias;
    }
    
    
}
