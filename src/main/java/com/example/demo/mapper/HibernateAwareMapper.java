package com.example.demo.mapper;

/*
 *
 * @created 08/12/2020
 * @author ashok.kulhari@gmail.com
 *
 */

import org.hibernate.collection.spi.PersistentCollection;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.TargetType;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Mapper
public interface HibernateAwareMapper {

	@BeforeMapping
	default <T> Set<T> fixLazyLoadingSet(Collection<?> c, @TargetType Class<?> targetType) {
		if (!Util.wasInitialized(c)) {
			return Collections.emptySet();
		}
		return null;
	}

	@BeforeMapping
	default <T> List<T> fixLazyLoadingList(Collection<?> c, @TargetType Class<?> targetType) {
		if (!Util.wasInitialized(c)) {
			return Collections.emptyList();
		}
		return null;
	}

	class Util {
		static boolean wasInitialized(Object c) {
			if (!(c instanceof PersistentCollection)) {
				return true;
			}
			PersistentCollection pc = (PersistentCollection) c;
			return pc.wasInitialized();
		}
	}

}