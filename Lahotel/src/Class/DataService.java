/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author terkg
 */
public class DataService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("database/Movie.odb");
    private EntityManager em;

    public DataService() {
        this.emf = Persistence.createEntityManagerFactory("database/lahotel.odb");
        this.em = emf.createEntityManager();
        //System.out.println("DataBase is Connecting..");
    }

    public void closeConnection() {
        this.em.close();
        this.emf.close();
    }
    public void createAccout(Account account){
        this.em.getTransaction().begin();
        this.em.persist(account);
        this.em.getTransaction().commit();
    }
    public void transactionBegin() {
        this.em.getTransaction().begin();
    }

    public void transactionCommit() {
        this.em.getTransaction().commit();
    }
}
