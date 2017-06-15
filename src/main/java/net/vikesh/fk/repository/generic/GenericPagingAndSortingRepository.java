package net.vikesh.fk.repository.generic;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by vikes on 11-06-2017.
 */

/**
 * GenericPagingAndSortingRepository which simply extends {@link PagingAndSortingRepository}.
 * @param <T>
 * @param <S>
 */
@NoRepositoryBean
public interface GenericPagingAndSortingRepository<T, S extends Serializable> extends PagingAndSortingRepository<T, S> {
}