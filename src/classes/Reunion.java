package classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Reunion {

    @Id
    @GeneratedValue
    private int idReunion;
    private Date fechaInicio;
    private Date fechaFin;
    private int duracion;

    @ManyToOne
    private Usuario creador;

    @ManyToMany
    private List<Usuario> invitados;

    @ManyToMany
    private List<Calendario> calendarios;

    public Reunion() {
    }

    public Reunion(Date fechaInicio, int duracion, Usuario creador) {
        super();
        this.fechaInicio = fechaInicio;
        this.invitados = new ArrayList<>();
        this.duracion = duracion;
        this.fechaFin = getFechaFin();
        this.creador = creador;
    }

    public Date getFechaFin() {
        if (fechaFin != null) return fechaFin;
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaInicio);
        Date fin = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR_OF_DAY) + duracion, cal.get(Calendar.MINUTE)).getTime();
        return fin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Usuario getDuenio() {
        return creador;
    }

    public int getIdReunion() {
        return idReunion;
    }

    public List<Usuario> getInvitados() {
        return invitados;
    }

    public void addInvitado(Usuario u) {
    	
        this.invitados.add(u);
        
        
    }

    public void deleteInvitado(Usuario i) {

    }


}
