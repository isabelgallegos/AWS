/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author isabel
 */
@Embeddable
public class EmpleadosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "No_Empleado")
    private int noEmpleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EqMix")
    private int eqMix;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Inmobiliaria")
    private int inmobiliaria;
    

    public EmpleadosPK() {
    }

    public EmpleadosPK(int noEmpleado, int eqMix, int inmobiliaria) {
        this.noEmpleado = noEmpleado;
        this.eqMix = eqMix;
        this.inmobiliaria = inmobiliaria;
    }

    public int getNoEmpleado() {
        return noEmpleado;
    }

    public void setNoEmpleado(int noEmpleado) {
        this.noEmpleado = noEmpleado;
    }

    public int getEqMix() {
        return eqMix;
    }

    public void setEqMix(int eqMix) {
        this.eqMix = eqMix;
    }

    public int getInmobiliaria() {
        return inmobiliaria;
    }

    public void setInmobiliaria(int inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) noEmpleado;
        hash += (int) eqMix;
        hash += (int) inmobiliaria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadosPK)) {
            return false;
        }
        EmpleadosPK other = (EmpleadosPK) object;
        if (this.noEmpleado != other.noEmpleado) {
            return false;
        }
        if (this.eqMix != other.eqMix) {
            return false;
        }
        if (this.inmobiliaria != other.inmobiliaria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.EmpleadosPK[ noEmpleado=" + noEmpleado + ", eqMix=" + eqMix + ", inmobiliaria=" + inmobiliaria + " ]";
    }
    
}


    
