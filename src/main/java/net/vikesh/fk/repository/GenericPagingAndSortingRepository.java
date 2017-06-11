package net.vikesh.fk.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * Created by vikes on 11-06-2017.
 */
public interface GenericPagingAndSortingRepository<T, ID extends Serializable> extends GenericCrudRepository<T, ID> {

    Iterable<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);
}