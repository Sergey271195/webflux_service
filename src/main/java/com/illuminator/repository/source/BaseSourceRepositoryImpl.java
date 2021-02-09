package com.illuminator.repository.source;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;

@Repository
@Transactional
public class BaseSourceRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
        implements BaseSourceRepository<T, ID> {

    private EntityManager entityManager;
    private JpaEntityInformation entityInformation;

    public BaseSourceRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
        this.entityInformation = entityInformation;
    }


    @Override
    public Optional<T> findByMetrikaId(Serializable metrikaId) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cQuery = builder.createQuery(getDomainClass());
        Root<T> root = cQuery.from(getDomainClass());
        cQuery.select(root)
                .where(builder.equal(root.get("metrikaId"), metrikaId));
        TypedQuery<T> query = entityManager.createQuery(cQuery);
        return Optional.of(query.getSingleResult());
    }
}
