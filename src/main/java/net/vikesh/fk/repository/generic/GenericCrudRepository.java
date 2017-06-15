package net.vikesh.fk.repository.generic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by vikes on 11-06-2017.
 */

/**
 * {@link GenericCrudRepository} that simply extends {@link CrudRepository}. Add generic methods.
 *
 * @param <T>
 * @param <S>
 */
@NoRepositoryBean
public interface GenericCrudRepository<T, S extends Serializable> extends CrudRepository<T, S> {
}
