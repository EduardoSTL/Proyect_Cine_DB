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
        System.out.println("=====lISTAR ACTOR====");
        return repository.listar();
    }

    @Override
    public Optional<Actor> porId(Integer id) {
        System.out.println("=====BUSQUEDA DE ACTOR POR ID====");
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void guardar(Actor actor) {
        try {
            System.out.println("=====GUARDAR ACTOR====");
            manager.getTransaction().begin();
            repository.guardar(actor);
            manager.getTransaction().commit();
//            System.out.println("=====ACTOR GUARDADO====");
        }catch (Exception e){
//            System.out.println("=====ACTOR NO GUARDADO====");
            JOptionPane.showConfirmDialog(null,"Error en la entrada de datos","CLOSED_OPTION", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Actor editar(Integer id) {
        try {
            System.out.println("=====EDITAR EMPLEADO====");
            manager.getTransaction().begin();
            repository.editar(id);
            manager.getTransaction().commit();
//            System.out.println("=====EMPLEADO EDITADO====");
        }catch (Exception e){
//            System.out.println("=====EMPLEADO NO EDITADO====");
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        try {
            System.out.println("=====ELIMINAR ACTOR====");
            manager.getTransaction().begin();
            repository.eliminar(id);
            manager.getTransaction().commit();
//            System.out.println("=====ACTOR ELIMINADO====");
        }catch (Exception e){
//            System.out.println("=====ACTOR NO ELIMINADO====");
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}