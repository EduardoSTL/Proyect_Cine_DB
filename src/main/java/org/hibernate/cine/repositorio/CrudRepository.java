package org.hibernate.cine.repositorio;

import org.hibernate.cine.exception.ActorNotFoundException;

import java.util.List;

public interface CrudRepository <T>{
    List<T> listar();
    T porId(Integer id);
    void guardar(T t) throws Exception;
    void editar(Integer id);
    void eliminar(Integer id) throws ActorNotFoundException;
}