package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;


import ch.zli.m223.model.Account;

@ApplicationScoped
public class AccountService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Account createUser(Account account) {
        entityManager.persist(account);
        return account;
    }

    @Transactional
    public void deleteUser(long id) {
        Account account =  entityManager.find(Account.class, id);
        entityManager.remove(account);
    }

    @Transactional
    public void update(Account account){
        entityManager.merge(account);
    }

    public List<Account> findAll() {
        var query = entityManager.createQuery("FROM Account", Account.class);
        return query.getResultList();
    }
}
