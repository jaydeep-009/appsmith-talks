package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.TalksSearchDTO;
import com.example.demo.model.Talks;
import com.example.demo.model.User;
@Repository
public interface TalksRepository extends JpaRepository<Talks, Long>, JpaSpecificationExecutor<Talks> {

	default List<Talks> findTalksForSearch(Specification<Talks> talks) {
		return findAll(talks);
	}

	default Specification<Talks> getTalksSearchSpecification(TalksSearchDTO talksSearch) {
		return new Specification<Talks>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Talks> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<Predicate>();

				// find by title or description contains
				addSearchString(list, root, criteriaBuilder, talksSearch.getQueryParam());

				// find by speaker
				if (Objects.nonNull(talksSearch.getSpeaker()) && talksSearch.getSpeaker() > 0) {
					Join<Talks, User> userJoin= root.join("speaker", JoinType.LEFT);
					list.add(criteriaBuilder.equal(userJoin.get("id"), talksSearch.getSpeaker()));
				}

				// Filter data startDate and endDate
				if (Objects.nonNull(talksSearch.getStartDate()) && Objects.nonNull(talksSearch.getEndDate())) {
					list.add(criteriaBuilder.greaterThanOrEqualTo(root.get("startDate"), talksSearch.getStartDate()));
					list.add(criteriaBuilder.lessThanOrEqualTo(root.get("endDate"), talksSearch.getEndDate()));
				}

				Predicate[] p = new Predicate[list.size()];
				query.where(criteriaBuilder.and(list.toArray(p)));
				return query.getRestriction();
			}
		};
	}

	default void addSearchString(List<Predicate> list, Root<Talks> root, CriteriaBuilder criteriaBuilder, String searchString) {
		if (StringUtils.isNoneBlank(searchString)) {
			String[] queryStrings = searchString.split("\\s+");

			List<Predicate> queryStringOrList = new ArrayList<Predicate>();
			for (String q : queryStrings) {
				queryStringOrList.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("title").as(String.class)), "%" + q.toLowerCase() + "%"));
				queryStringOrList.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("description").as(String.class)), "%" + q.toLowerCase() + "%"));
			}

			list.add(criteriaBuilder.or(queryStringOrList.toArray(new Predicate[queryStringOrList.size()])));
		}
	}

}