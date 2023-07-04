package org.hibernate.cine.service;

import jakarta.persistence.EntityManager;
import org.hibernate.cine.entity.Actor;
import org.hibernate.cine.repositorio.ActorRepository;
import org.hibernate.cine.repositorio.CrudRepository;


import javax.swing.*;
import java.util.List;
import java.util.Optional;

public class ActorServiceImpl implements ActorService{

    private final EntityManager manager;
    private CrudRepository<Actor> repository;
    public ActorServiceImpl(EntityManager manager) {
        this.manager = manager;
        this.repository= new ActorRepository(manager);
    }


    @Override
    public List<Actor> listar() {
        return null;
    }

    @Override
    public Optional<Actor> porId(Integer id) {
        return Optional.empty();
    }

    @Override
    public void guardar(Actor actor) {

    }

    @Override
    public Actor editar(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }
}