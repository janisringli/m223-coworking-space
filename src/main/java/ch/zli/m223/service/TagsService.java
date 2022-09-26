package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;


import ch.zli.m223.model.Tags;

@ApplicationScoped
public class TagsService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Tags createTags(Tags tags) {
        entityManager.persist(tags);
        return tags;
    }

    @Transactional
    public void deleteTags(long id) {
        Tags tags =  entityManager.find(Tags.class, id);
        entityManager.remove(tags);
    }

    @Transactional
    public void update(Tags tags){
        entityManager.merge(tags);
    }

    public List<Tags> findAll() {
        var query = entityManager.createQuery("FROM Tags", Tags.class);
        return query.getResultList();
    }
}

