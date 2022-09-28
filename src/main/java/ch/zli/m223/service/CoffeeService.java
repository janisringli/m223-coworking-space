package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;


import ch.zli.m223.model.Coffee;

@ApplicationScoped
public class CoffeeService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Coffee createCoffee(Coffee coffee) {
        entityManager.persist(coffee);
        return coffee;
    }

    @Transactional
    public void deleteCoffee(Long id) {
    Coffee coffee =  entityManager.find(Coffee.class, id);
        entityManager.remove(coffee);
    }

    @Transactional
    public void update(Coffee Coffee){
        entityManager.merge(Coffee);
    }
    public List<Coffee> findAll() {
        var query = entityManager.createQuery("FROM Coffee", Coffee.class);
        return query.getResultList();
    }
    public Coffee getCoffeeById(Long id){
        return entityManager.find(Coffee.class, id);
    }
}
