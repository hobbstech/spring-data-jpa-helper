package io.github.hobbstech.springdatajpahelper.specification;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @param <T> The Entity class type that is being used, to which the specification is to be created for.
 * @author wilson
 * @version 1.0.0
 * @since 1.0.0
 */
public class CustomSpecificationTemplateImpl<T> implements Specification<T> {

    private final SearchCriteria searchCriteria;

    CustomSpecificationTemplateImpl(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    /**
     * @param root    @see org.springframework.data.jpa.domain.Specification
     * @param query   @see org.springframework.data.jpa.domain.Specification
     * @param builder @see org.springframework.data.jpa.domain.Specification
     *
     *                <p>This method created a predication for a where clause.
     *                This determines the action and predicate to be created
     *                basing the the operation that is set in the search criteria</p>
     */
    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (searchCriteria.getOperation().equalsIgnoreCase(Operations.GREATER_THAN.sign)) {

            return builder.greaterThanOrEqualTo(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());

        } else if (searchCriteria.getOperation().equalsIgnoreCase(Operations.LESS_THAN.sign)) {

            return builder.lessThanOrEqualTo(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());

        } else if (searchCriteria.getOperation().equalsIgnoreCase(Operations.EQUALS.sign)) {

            if (root.get(searchCriteria.getKey()).getJavaType().equals(String.class)) {

                return builder.like(root.get(searchCriteria.getKey()), "%" + searchCriteria.getValue() + "%");

            } else {

                return builder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());

            }
        }
        return null;
    }
}
