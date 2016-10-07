/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograiv.milkyway.dao;

import cr.ac.una.prograiv.milkyway.domain.Chat;
import cr.ac.una.prograiv.milkyway.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Admin
 */
public class ChatDAO extends HibernateUtil implements IBaseDAO<Chat, Integer>{       
    @Override
    public void save(Chat o) {
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
    public Chat merge(Chat o) throws HibernateException {
        try {
            iniciaOperacion();
            o = (Chat) getSesion().merge(o);
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
    public void delete(Chat o) {
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
    public Chat findById(Integer id) {
        Chat chat = null;

        try {
            iniciaOperacion();
            chat = (Chat) getSesion().get(Chat.class, id);
        } finally {
            getSesion().close();
        }
        return chat;
    }
    @Override
    public List<Chat> findAll() {
        List<Chat> listaChats;
        try {
            iniciaOperacion();//HQL
            listaChats = getSesion().createQuery("from Chat").list();
        } finally {
            getSesion().close();
        }

        return listaChats;
    }
    
    
}