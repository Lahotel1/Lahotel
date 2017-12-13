/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author terkg
 */
public class DataService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("database/lahotel.odb");
    private EntityManager em;

    public DataService() {
        this.emf = Persistence.createEntityManagerFactory("database/lahotel.odb");
        this.em = emf.createEntityManager();
        //System.out.println("DataBase is Connecting..");
    }
  
    public List<Room> getRoomFormDay(String day,String month,String year )
    {
        String sql = "SELECT c FROM Room c Where c.day = '" + day + "' AND c.month = '" + month +"' AND c.year = '" + year + "'";
        TypedQuery<Room> query = em.createQuery(sql, Room.class);
        List<Room> results = query.getResultList();
        return results;
    }
    public List<Account> getAllAccount(){
        String sql = "SELECT c FROM Account c";
        TypedQuery<Account> query = em.createQuery(sql, Account.class);
        List<Account> results = query.getResultList();
        return results;
    }
    public void closeConnection() {
        this.em.close();
        this.emf.close();
    }
    
    public Account getAccount(String username){
        String sql = "SELECT c FROM Account c Where c.username = '" + username + "'";
        TypedQuery<Account> query = em.createQuery(sql, Account.class);
        List<Account> results = query.getResultList();
        
        return results.get(0);
    }
    public void createAccout(Account account){
        this.em.getTransaction().begin();
        this.em.persist(account);
        this.em.getTransaction().commit();
    }
    public void createRoom(Room room){
        this.em.getTransaction().begin();
        this.em.persist(room);
        this.em.getTransaction().commit();
    }
    public void transactionBegin() {
        this.em.getTransaction().begin();
    }

    public void transactionCommit() {
        this.em.getTransaction().commit();
    }
}
