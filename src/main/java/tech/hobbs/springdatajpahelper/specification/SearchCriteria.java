package tech.hobbs.springdatajpahelper.specification;

import lombok.Data;

@Data
class SearchCriteria {

    private final String key;
    private final String operation;
    private final Object value;

    private SearchCriteria(String key, String operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    static SearchCriteria createSearchCriteria(String key, String operation, Object value) {
        return new SearchCriteria(key, operation, value);
    }

}
