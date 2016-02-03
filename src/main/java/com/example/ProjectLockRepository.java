package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

/**
 * Created by mszarlinski on 2016-02-03.
 */
@Repository
public class ProjectLockRepository {

    @Resource
    private EntityManager em;

    public ProjectLock findActiveByProjectId(final String projectId) {
        return (ProjectLock) em.createQuery("from ProjectLock pl where pl.project.id = :projectId and pl.active = true")
                .setParameter("projectId", projectId)
                .getSingleResult();
    }

    @Transactional
    public ProjectLock save(final ProjectLock projectLock) {
        em.persist(projectLock.getProject());
        em.persist(projectLock);
        return projectLock;
    }
}
