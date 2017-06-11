package net.vikesh.fk.repository;

import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * Created by vikes on 11-06-2017.
 */
public interface GenericCrudRepository<T, ID extends Serializable> extends Repository<T, ID> {

    <S extends T> S save(S entity);

    T fineOne(ID primaryKey);

    Iterable<T> findAll();

    Long count();

    void delete(T entity);

    boolean exists(ID primaryKey);
}
