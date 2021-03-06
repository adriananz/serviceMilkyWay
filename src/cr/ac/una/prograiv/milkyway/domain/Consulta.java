package cr.ac.una.prograiv.milkyway.domain;
// Generated Oct 7, 2016 8:30:21 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Consulta generated by hbm2java
 */
public class Consulta  implements java.io.Serializable {


     private int idConsulta;
     private Expertostema expertostema;
     private Usuario usuario;
     private int duracion;
     private int calificacion;
     private String feedback;
     private int usuarioIdUsuario;
     private Set<Factura> facturas = new HashSet<Factura>(0);
     private Set<Chat> chats = new HashSet<Chat>(0);

    public Consulta() {
    }

	
    public Consulta(int idConsulta, Expertostema expertostema, Usuario usuario, int duracion, int calificacion, int usuarioIdUsuario) {
        this.idConsulta = idConsulta;
        this.expertostema = expertostema;
        this.usuario = usuario;
        this.duracion = duracion;
        this.calificacion = calificacion;
        this.usuarioIdUsuario = usuarioIdUsuario;
    }
    public Consulta(int idConsulta, Expertostema expertostema, Usuario usuario, int duracion, int calificacion, String feedback, int usuarioIdUsuario, Set<Factura> facturas, Set<Chat> chats) {
       this.idConsulta = idConsulta;
       this.expertostema = expertostema;
       this.usuario = usuario;
       this.duracion = duracion;
       this.calificacion = calificacion;
       this.feedback = feedback;
       this.usuarioIdUsuario = usuarioIdUsuario;
       this.facturas = facturas;
       this.chats = chats;
    }
   
    public int getIdConsulta() {
        return this.idConsulta;
    }
    
    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }
    public Expertostema getExpertostema() {
        return this.expertostema;
    }
    
    public void setExpertostema(Expertostema expertostema) {
        this.expertostema = expertostema;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public int getDuracion() {
        return this.duracion;
    }
    
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public int getCalificacion() {
        return this.calificacion;
    }
    
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    public String getFeedback() {
        return this.feedback;
    }
    
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public int getUsuarioIdUsuario() {
        return this.usuarioIdUsuario;
    }
    
    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }
    public Set<Factura> getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }
    public Set<Chat> getChats() {
        return this.chats;
    }
    
    public void setChats(Set<Chat> chats) {
        this.chats = chats;
    }




}


