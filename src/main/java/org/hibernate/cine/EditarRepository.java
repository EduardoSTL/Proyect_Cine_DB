package org.hibernate.cine;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class EditarRepository {

    public static void main(String[] args) {
        JTextField nombreField = new JTextField();
        JTextField nacionalidadField = new JTextField();
        JTextField fechaNacimientoField = new JTextField();
        JTextField lugarNacimientoField = new JTextField();
        JTextField fechaDefuncionField = new JTextField();
        JTextField lugarFallecimientoField = new JTextField();

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

            Actor actor = new Actor();

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

            // Realizar las operaciones necesarias con los datos del actor

            // ...
        }
    }

    private static Optional<LocalDateTime> parseFecha(String fecha) {
        if (fecha != null && !fecha.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate fechaLocal = LocalDate.parse(fecha, formatter);
            return Optional.of(fechaLocal.atStartOfDay());
        }
        return Optional.empty();
    }

    private static class Actor {
        private String nombre;
        private String nacionalidad;
        private LocalDateTime fechaNacimiento;
        private String lugarNacimiento;
        private LocalDateTime fechaMuerte;
        private String lugarMuerte;

        // Getters y Setters

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getNacionalidad() {
            return nacionalidad;
        }

        public void setNacionalidad(String nacionalidad) {
            this.nacionalidad = nacionalidad;
        }

        public LocalDateTime getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public String getLugarNacimiento() {
            return lugarNacimiento;
        }

        public void setLugarNacimiento(String lugarNacimiento) {
            this.lugarNacimiento = lugarNacimiento;
        }

        public LocalDateTime getFechaMuerte() {
            return fechaMuerte;
        }

        public void setFechaMuerte(LocalDateTime fechaMuerte) {
            this.fechaMuerte = fechaMuerte;
        }

        public String getLugarMuerte() {
            return lugarMuerte;
        }

        public void setLugarMuerte(String lugarMuerte) {
            this.lugarMuerte = lugarMuerte;
        }
    }
}

