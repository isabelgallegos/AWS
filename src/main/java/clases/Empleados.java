/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author isabel
 */
@Entity
@Table(name = "empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e")
    , @NamedQuery(name = "Empleados.findByNoEmpleado", query = "SELECT e FROM Empleados e WHERE e.empleadosPK.noEmpleado = :noEmpleado")
    , @NamedQuery(name = "Empleados.findByEqMix", query = "SELECT e FROM Empleados e WHERE e.empleadosPK.eqMix = :eqMix")
    , @NamedQuery(name = "Empleados.findByInmobiliaria", query = "SELECT e FROM Empleados e WHERE e.empleadosPK.inmobiliaria = :inmobiliaria")
    , @NamedQuery(name = "Empleados.findByNombre", query = "SELECT e FROM Empleados e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empleados.findByNombreC", query = "SELECT e FROM Empleados e WHERE e.nombreC = :nombreC")
    , @NamedQuery(name = "Empleados.findByDepartamento", query = "SELECT e FROM Empleados e WHERE e.departamento = :departamento")
    , @NamedQuery(name = "Empleados.findByPuesto", query = "SELECT e FROM Empleados e WHERE e.puesto = :puesto")
    , @NamedQuery(name = "Empleados.findByPeriodo", query = "SELECT e FROM Empleados e WHERE e.periodo = :periodo")
    , @NamedQuery(name = "Empleados.findBySexo", query = "SELECT e FROM Empleados e WHERE e.sexo = :sexo")
    , @NamedQuery(name = "Empleados.findByFechaIngreso", query = "SELECT e FROM Empleados e WHERE e.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Empleados.findByNoSello", query = "SELECT e FROM Empleados e WHERE e.noSello = :noSello")
    , @NamedQuery(name = "Empleados.findByVacacionesPendientes", query = "SELECT e FROM Empleados e WHERE e.vacacionesPendientes = :vacacionesPendientes")
    , @NamedQuery(name = "Empleados.findByPassword", query = "SELECT e FROM Empleados e WHERE e.password = :password")
    , @NamedQuery(name = "Empleados.findByPermisos", query = "SELECT e FROM Empleados e WHERE e.permisos = :permisos")
    , @NamedQuery(name = "Empleados.findByEstatus", query = "SELECT e FROM Empleados e WHERE e.estatus = :estatus")})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadosPK empleadosPK;
    @Size(max = 100)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "NombreC")
    private String nombreC;
    @Size(max = 100)
    @Column(name = "Departamento")
    private String departamento;
    @Size(max = 100)
    @Column(name = "Puesto")
    private String puesto;
    @Size(max = 25)
    @Column(name = "Periodo")
    private String periodo;
    @Column(name = "sexo")
    private Character sexo;
    @Column(name = "FechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "NoSello")
    private Integer noSello;
    @Column(name = "VacacionesPendientes")
    private Integer vacacionesPendientes;
    @Size(max = 5)
    @Column(name = "password")
    private String password;
    @Size(max = 250)
    @Column(name = "permisos")
    private String permisos;
    @Size(max = 25)
    @Column(name = "Estatus")
    private String estatus;

    public Empleados() {
    }

    public Empleados(EmpleadosPK empleadosPK) {
        this.empleadosPK = empleadosPK;
    }

    public Empleados(int noEmpleado, int eqMix, int inmobiliaria) {
        this.empleadosPK = new EmpleadosPK(noEmpleado, eqMix, inmobiliaria);
    }

    public EmpleadosPK getEmpleadosPK() {
        return empleadosPK;
    }

    public void setEmpleadosPK(EmpleadosPK empleadosPK) {
        this.empleadosPK = empleadosPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getNoSello() {
        return noSello;
    }

    public void setNoSello(Integer noSello) {
        this.noSello = noSello;
    }

    public Integer getVacacionesPendientes() {
        return vacacionesPendientes;
    }

    public void setVacacionesPendientes(Integer vacacionesPendientes) {
        this.vacacionesPendientes = vacacionesPendientes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadosPK != null ? empleadosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.empleadosPK == null && other.empleadosPK != null) || (this.empleadosPK != null && !this.empleadosPK.equals(other.empleadosPK))) {
            return false;
        }
        
           
        if((this.nombreC == null && other.nombreC != null) || (this.nombreC != null && !this.nombreC.equals(other.nombreC))){
            return false;
        }
        if((this.password == null && other.password != null) || (this.password != null && !this.password.equals(other.password))){
            return false;
        }
        
        return true;
          
    }

    

    @Override
    public String toString() {
        return "clases.Empleados[ empleadosPK=" + empleadosPK + " ]";
    }
    
}
