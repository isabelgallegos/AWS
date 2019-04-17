/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.service;

import clases.Empleados;
import clases.EmpleadosPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author isabel
 */
@Stateless
@Path("clases.empleados")
public class EmpleadosFacadeREST extends AbstractFacade<Empleados> {

    @PersistenceContext(unitName = "edu.uci.quinto_ServicioWebLogin_war_1.0-DOGPU")
    private EntityManager em;

    private EmpleadosPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;noEmpleado=noEmpleadoValue;eqMix=eqMixValue;inmobiliaria=inmobiliariaValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        clases.EmpleadosPK key = new clases.EmpleadosPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> noEmpleado = map.get("noEmpleado");
        if (noEmpleado != null && !noEmpleado.isEmpty()) {
            key.setNoEmpleado(new java.lang.Integer(noEmpleado.get(0)));
        }
        java.util.List<String> eqMix = map.get("eqMix");
        if (eqMix != null && !eqMix.isEmpty()) {
            key.setEqMix(new java.lang.Integer(eqMix.get(0)));
        }
        java.util.List<String> inmobiliaria = map.get("inmobiliaria");
        if (inmobiliaria != null && !inmobiliaria.isEmpty()) {
            key.setInmobiliaria(new java.lang.Integer(inmobiliaria.get(0)));
        }
        return key;
    }

    public EmpleadosFacadeREST() {
        super(Empleados.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Empleados entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Empleados entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        clases.EmpleadosPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Empleados find(@PathParam("id") PathSegment id) {
        clases.EmpleadosPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Empleados> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Empleados> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
