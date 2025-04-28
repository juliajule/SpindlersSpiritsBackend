package com.example.WhiskyApp.specification;

import com.example.WhiskyApp.entity.Whisky;
import com.example.WhiskyApp.dto.WhiskySearchRequest;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class WhiskySpecification {

    public static Specification<Whisky> bySearchRequest(WhiskySearchRequest request) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (request.getQuery() != null && !request.getQuery().isEmpty()) {
                String likeQuery = "%" + request.getQuery().toLowerCase() + "%";
                predicates.add(cb.or(
                        cb.like(cb.lower(root.get("name")), likeQuery),
                        cb.like(cb.lower(root.get("distillery")), likeQuery)
                ));
            }

            if (request.getMinAge() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("age"), request.getMinAge()));
            }
            if (request.getMaxAge() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("age"), request.getMaxAge()));
            }

            if (request.getMinAlcoholPercentage() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("alcoholPercentage"), request.getMinAlcoholPercentage()));
            }
            if (request.getMaxAlcoholPercentage() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("alcoholPercentage"), request.getMaxAlcoholPercentage()));
            }

            if (request.getMinPrice() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("price"), request.getMinPrice()));
            }
            if (request.getMaxPrice() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("price"), request.getMaxPrice()));
            }

            if (request.getTastingDateFrom() != null) {
                predicates.add(cb.greaterThanOrEqualTo(
                        root.get("tasting").get("date"),
                        Date.valueOf(request.getTastingDateFrom())
                ));
            }
            if (request.getTastingDateTo() != null) {
                predicates.add(cb.lessThanOrEqualTo(
                        root.get("tasting").get("date"),
                        Date.valueOf(request.getTastingDateTo())
                ));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
