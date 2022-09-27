package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;


import ch.zli.m223.model.Roles;

@ApplicationScoped
public class RolesService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Roles createRoles(Roles roles) {
        entityManager.persist(roles);
        return roles;
    }

    @Transactional
    public void deleteRoles(Long id) {
        Roles roles =  entityManager.find(Roles.class, id);
        entityManager.remove(roles);
    }

    @Transactional
    public void update(Roles roles){
        entityManager.merge(roles);
    }
    public List<Roles> findAll() {
        var query = entityManager.createQuery("FROM Roles", Roles.class);
        return query.getResultList();
    }
//FIXME: Add missing method

    // public Roles getRolesById(Long id){
    //     return entityManager.find(Roles.class, id);
    // }
}
