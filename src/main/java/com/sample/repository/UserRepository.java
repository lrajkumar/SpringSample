package com.sample.repository;

import com.sample.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<User> findByRole() {
        Query query = entityManager.createNativeQuery("select * from tUser where user_role='Admin2'");

        return (List<User>) query.getResultList();
    }

    public List<User> findByRoleUsingCriteriaQuery(String role) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);

        Predicate isAdmin = criteriaBuilder.equal(userRoot.get("role"), role);
//        Predicate isReader = criteriaBuilder.equal(userRoot.get("role"), "Reader");
//        Predicate adminOrReader = criteriaBuilder.or(isAdmin, isReader);

        query.where(isAdmin);

        TypedQuery<User> userQuery = entityManager.createQuery(query);

        return userQuery.getResultList();

    }


}
