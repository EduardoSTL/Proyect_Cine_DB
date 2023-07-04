package org.hibernate.cine.repositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.cine.entity.Actor;
import org.hibernate.cine.exception.ActorNotFoundException;
import org.hibernate.cine.util.JpaUtil;

import java.awt.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static org.hibernate.cine.util.JpaUtil.entityManagerFactory;

public class ActorRepository implements CrudRepository<Actor>{

    private EntityManager manager;

    private EntityManager entityManager;

    public ActorRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Actor> listar() {
        manager = JpaUtil.getEntityManager();
        List<Actor> actores = manager.createQuery("select e from Actor e",
                Actor.class).getResultList();
        manager.close();
        return actores;
    }

    @Override
    public Actor porId(Integer id) {
        return manager.find(Actor.class,id);
    }

    @Override
    public void guardar(Actor actor) throws Exception {
        try {
            manager.getTransaction().begin();
            manager.persist(actor);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            manager.close();
        }
    }

    @Override
    public void editar(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Actor actor = entityManager.find(Actor.class, id);
        if (actor != null) {
            JTextField nombreField = new JTextField(actor.getNombre());
            JTextField nacionalidadField = new JTextField(actor.getNacionalidad());
            JTextField fechaNacimientoField = new JTextField(formatFecha(actor.getFechaNacimiento()));
            JTextField lugarNacimientoField = new JTextField(actor.getLugarNacimiento());
            JTextField fechaDefuncionField = new JTextField(formatFecha(actor.getFechaMuerte()));
            JTextField lugarFallecimientoField = new JTextField(actor.getLugarMuerte());

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(6, 2));
            panel.add(new JLabel("Nombre:"));
            panel.add(nombreField);
            panel.add(new JLabel("Nacionalidad:"));
            panel.add(nacionalidadField);
            panel.add(new JLabel("Fecha de nacimiento (yyyy/MM/dd):"));
            panel.add(fechaNacimientoField);
            panel.add(new JLabel("Lugar de nacimiento:"));
            panel.add(lugarNacimientoField);
            panel.add(new JLabel("Fecha de defunción (yyyy/MM/dd):"));
            panel.add(fechaDefuncionField);
            panel.add(new JLabel("Lugar de fallecimiento:"));
            panel.add(lugarFallecimientoField);

            int result = JOptionPane.showConfirmDialog(null, panel, "Editar Actor", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                String nombre = nombreField.getText();
                String nacionalidad = nacionalidadField.getText();
                String fechaNacimiento = fechaNacimientoField.getText();
                String lugarNacimiento = lugarNacimientoField.getText();
                String fechaDefuncion = fechaDefuncionField.getText();
                String lugarFallecimiento = lugarFallecimientoField.getText();

                if (!nombre.isEmpty()) {
                    actor.setNombre(nombre);
                }
                if (!nacionalidad.isEmpty()) {
                    actor.setNacionalidad(nacionalidad);
                }
                if (!fechaNacimiento.isEmpty()) {
                    Optional<LocalDateTime> fechaNac = parseFecha(fechaNacimiento);
                    fechaNac.ifPresent(actor::setFechaNacimiento);
                }
                if (!lugarNacimiento.isEmpty()) {
                    actor.setLugarNacimiento(lugarNacimiento);
                }
                if (!fechaDefuncion.isEmpty()) {
                    Optional<LocalDateTime> fechaDef = parseFecha(fechaDefuncion);
                    fechaDef.ifPresent(actor::setFechaMuerte);
                }
                if (!lugarFallecimiento.isEmpty()) {
                    actor.setLugarMuerte(lugarFallecimiento);
                }

                entityManager.getTransaction().begin();
                entityManager.merge(actor);
                entityManager.getTransaction().commit();

                entityManager.close();
            }
        }
    }

    private Optional<LocalDateTime> parseFecha(String fecha) {
        if (fecha != null && !fecha.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate fechaLocal = LocalDate.parse(fecha, formatter);
            return Optional.of(fechaLocal.atStartOfDay());
        }
        return Optional.empty();
    }

    private String formatFecha(Date fecha) {
        if (fecha != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            return formatter.format(fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        }
        return "";
    }

    public void eliminar(Integer id) throws ActorNotFoundException {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Actor actor = entityManager.find(Actor.class, id);
            if (actor != null) {
                entityManager.remove(actor);
            } else {
                throw new ActorNotFoundException("No se encontró ningún actor con el ID: " + id);
            }
            transaction.commit();
        } catch (ActorNotFoundException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el actor: " + e.getMessage());
        }
    }
}

