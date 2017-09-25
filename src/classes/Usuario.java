package classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private int id;
    private String nombre;


    @OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST)
    private List<Calendario> calendarios;

    public Usuario(String nombre) {
        this.nombre = nombre;
        calendarios = new ArrayList<>();
        crearCalendario();
    }

    public void agregarReunion(Reunion r, Calendario c) {
        if(!estaOcupado(r)) {
            if (calendarios.contains(c)) {
                c.agregarReunion(r);
            }
        }
    }


    public void compartir(Usuario u, Calendario c ) {
        u.agregarCalendario(c);
    }

    public void agregarCalendario(Calendario c) {
        this.calendarios.add(c);
    }

    public void crearCalendario() {
        Calendario c = new Calendario(this);
        calendarios.add(c);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public List<Calendario> getCalendarios() {
        return calendarios;
    }

    public boolean equals(Object obj) {
        return ((Usuario) obj).getId() == id;
    }

    public int getId() {
        return id;
    }



    public boolean estaOcupado(Reunion r){
         for (Calendario c : this.calendarios) {
             for (Reunion reunion : c.getReuniones()) {
                 if ((r.getFechaInicio().compareTo(reunion.getFechaInicio()) > 0) && (r.getFechaFin().compareTo(reunion.getFechaFin()) < 0)) {
                     return true;
                 }
             }
         }
         return false;
    }
}
