package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;


import ch.zli.m223.model.Koffee;

@ApplicationScoped
public class KoffeeService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Koffee createKoffee(Koffee koffee) {
        entityManager.persist(koffee);
        return koffee;
    }

    @Transactional
    public void deleteKoffee(Long id) {
    Koffee koffee =  entityManager.find(Koffee.class, id);
        entityManager.remove(koffee);
    }

    @Transactional
    public void update(Koffee koffee){
        entityManager.merge(koffee);
    }
    public List<Koffee> findAll() {
        var query = entityManager.createQuery("FROM Koffee", Koffee.class);
        return query.getResultList();
    }
    public Koffee getKoffeeById(Long id){
        return entityManager.find(Koffee.class, id);
    }
}
