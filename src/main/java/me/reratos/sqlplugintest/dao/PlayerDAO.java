package me.reratos.sqlplugintest.dao;

import me.reratos.sqlplugintest.connection.Factory;
import me.reratos.sqlplugintest.model.PlayerModel;

import javax.persistence.EntityManager;

public class PlayerDAO {
    EntityManager em;

    public PlayerDAO() {
        em = Factory.getConnection();
    }

    public PlayerModel find(int id) {
        return em.find(PlayerModel.class, id);
    }

    public void persist(PlayerModel entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public PlayerModel merge(PlayerModel entity) {
        try {
            em.getTransaction().begin();
            entity = em.merge(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            return null;
        }
    }

    public void remove(PlayerModel entity) {
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
