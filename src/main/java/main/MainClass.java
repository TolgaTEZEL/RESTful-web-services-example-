/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.Customer;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.ws.rs.QueryParam;
import dao.Database;
/**
 *
 * @author <<<<<<<
 */
@Path("/mainMenu")
public class MainClass {

  

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getTheList")
    public List<Customer> getAValue() throws SQLException {
      
        
        List<Customer> a = new ArrayList<>();
       Database.vericek((ArrayList<Customer>) a);
      

        return a;

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/adAra")
    public List<Customer> adAra(@QueryParam("name") String name) throws SQLException {
        List<Customer> b = new ArrayList<>();
      Database.vericek((ArrayList<Customer>) b);
        List<Customer> c = new ArrayList<>();
        b.stream().filter((b1) -> (b1.getName().equals(name))).forEach((b1) -> {
            c.add(b1);
        });
        return c;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/idAra")
    public List<Customer> idAra(@QueryParam("id") int id) throws SQLException {
        List<Customer> b = new ArrayList<>();
        Database.vericek((ArrayList<Customer>) b);
        List<Customer> c = new ArrayList<>();
        if (id == 0) {
            return b;

        } else {
            b.stream().filter((b1) -> (b1.getId() == id)).forEach((b1) -> {
                c.add(b1);
            });
            return c;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/maasAra")
    public List<Customer> maasAra(@QueryParam("maas") int maas) throws SQLException {
        List<Customer> b = new ArrayList<>();
        Database.vericek(b);
        List<Customer> c = new ArrayList<>();
        b.stream().filter((b1) -> (b.contains(maas))).forEach((b1) -> {
            c.add(b1);
        });
        return c;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/soyadAra")
    public List<Customer> soyadAra(@QueryParam("surname") String surname) throws SQLException {
        List<Customer> b = new ArrayList<>();
        Database.vericek(b);
        List<Customer> c = new ArrayList<>();
        b.stream().filter((b1) -> (b1.getName().equals(surname))).forEach((b1) -> {
            c.add(b1);
        });

        return c;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ikiliAra")
    public List<Customer> ikiliAra(@QueryParam("name") String name, @QueryParam("maas") int maas) throws SQLException {
        List<Customer> b = new ArrayList<>();
        Database.vericek(b);
        List<Customer> c = new ArrayList<>();
        System.out.println("name = " + name +"maas = " + maas);
        b.stream().filter((b1) -> (b1.getName().equals(name) && b1.getMaas() == maas)).forEach((b1) -> {
            c.add(b1);
        });

         return c;
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/maxToMin")
    public List<Customer> maasSirala() throws SQLException {

        List<Customer> a = new ArrayList<>();
         Database.vericek(a);
        a.sort(Comparator.comparing(Customer::getMaas).reversed());

        return a;

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/minToMax")
    public List<Customer> maasSira() throws SQLException {

        List<Customer> a = new ArrayList<>();
        Database.vericek(a);
        a.sort(Comparator.comparing(Customer::getMaas));

        return a;

    }
}
