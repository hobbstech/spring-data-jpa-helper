package tech.hobbs.springdatajpahelper.specification;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CustomSpecificationTemplateImpl<T> implements Specification<T> {

    private final SearchCriteria searchCriteria;

    CustomSpecificationTemplateImpl(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (searchCriteria.getOperation().equalsIgnoreCase(">")) {

            return builder.greaterThanOrEqualTo(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());

        } else if (searchCriteria.getOperation().equalsIgnoreCase("<")) {

            return builder.lessThanOrEqualTo(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());

        } else if (searchCriteria.getOperation().equalsIgnoreCase(":")) {

            if (root.get(searchCriteria.getKey()).getJavaType().equals(String.class)) {

                return builder.like(root.get(searchCriteria.getKey()), "%" + searchCriteria.getValue() + "%");

            } else {

                return builder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());

            }
        }
        return null;
    }
}
