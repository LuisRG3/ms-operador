package com.compra.operador.data.utils;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.LinkedList;
import java.util.List;

public class SearchCriteria <CompraDetalle> implements Specification<CompraDetalle> {

    private final List<SearchStatement> list = new LinkedList<>();
    public void add(SearchStatement criteria) {
        list.add(criteria);
    }

    @Override
    public Predicate toPredicate(Root<CompraDetalle> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
