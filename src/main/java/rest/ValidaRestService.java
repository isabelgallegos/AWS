/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

/**
 *
 * @author isabel
 */
import clases.Login;
//import clases.Numeros;
//import clases.Numeros;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/valida")
public class ValidaRestService {

    // Librería de MySQL
    public String driver = "com.mysql.jdbc.Driver";

    // Nombre de la base de datos
    public String database = "eqa1_v2"; // Prueba 

    // Host
    public String hostname = "eq.cji9kodartdr.us-west-2.rds.amazonaws.com";

    // Puerto
    public String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    //public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";// Prueba
    public String urlReal = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";// Real

    // Nombre de usuario
    public String username = "root";

    // Clave de usuario
    public String password = "";

    @GET
    @Path("/validar/{param}/{param2}")
    public Boolean validarUsuarioGet(@PathParam("param") String user, @PathParam("param2") String pass) {
        
        Connection conn;
        ResultSet rs ;
        PreparedStatement pst;
        String consulta;
        Boolean acceso = false;
        try {
            conn = DriverManager.getConnection(urlReal, username, password);//
            consulta = "SELECT * FROM Empleados WHERE NombreC LIKE '" + user + "' AND password LIKE '" + pass + "'";
            pst = conn.prepareStatement(consulta);
            rs = pst.executeQuery();
            if (rs.next()) {
                user = rs.getString("NombreC");
                pass = rs.getString("password");
                acceso = true;
            } else {
                acceso = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error: " + e);
            System.out.println();
        }
        return acceso;

    }

    @POST
        @Path("/validar")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.TEXT_PLAIN)
        public String  validarUsuarioPost(String json) { 
            Gson gson = new Gson();
            Login log = gson.fromJson(json, Login.class);     
            String responseString = String.valueOf(log.getNombreC()+log.getPassword());
            
            System.out.println();
    
        return responseString;
 
	}
    
     @PUT
        @Path("/validar")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.TEXT_PLAIN)
        public String  validarUsuarioPut(String json) { 
            Gson gson = new Gson();
            Login log = gson.fromJson(json, Login.class);     
            String responseString = String.valueOf(log.getNombreC()+log.getPassword());
            
            System.out.println();
    
        return responseString;
 
	}
}

    //@POST
    //@Path("/validar")
    //@Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.TEXT_PLAIN)
    //public Boolean validarUsuarioPost(String json) {
      //  Gson gson = new Gson();
       // Login log = gson.fromJson(json, Login.class);
       // Connection conn;
        //ResultSet rs;
        //PreparedStatement pst;
        //String consulta;
        //boolean acceso = false;
        //try {
          //  conn = DriverManager.getConnection(urlReal, username, password);//
            //consulta = "SELECT * FROM Empleados WHERE nombreC='" + log.getNombreC()  + "' AND password ='" + log.getPassword() + "'";
            //pst = conn.prepareStatement(consulta);
            //rs = pst.executeQuery();
            //if (rs.next()) {
              //  acceso = true;
           // } else {
             //   acceso = false;
           // }
        //} catch (SQLException e) {
          //  e.printStackTrace();
            //System.out.println("Error: " + e);
        //}
        //return acceso;

    //}   
    
    
    
   // @PUT
    //@Path("/validar")
    //@Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.TEXT_PLAIN)
    //public Boolean validarUsuarioPut(String json) {
      //  Gson gson = new Gson();
        //Login log = gson.fromJson(json, Login.class);
        //Connection conn;
        //ResultSet rs;
        //PreparedStatement pst;
        //String consulta;
        //boolean acceso = false;
        //try {
          //  conn = DriverManager.getConnection(urlReal, username, password);//
           // consulta = "SELECT * FROM Empleados WHERE nombreC LIKE '" + log.getNombreC() + "' AND password LIKE '" + log.getPassword() + "'";
           // pst = conn.prepareStatement(consulta);
            //rs = pst.executeQuery();
           // if (rs.next()) {
             //   acceso = true;
           // } else {
             //   acceso = false;
           // }
        //} catch (SQLException e) {
          //  e.printStackTrace();
            //System.out.println("Error: " + e);
       // }
        //return acceso;

   // }

//}
