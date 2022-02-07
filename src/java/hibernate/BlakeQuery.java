/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class BlakeQuery {
    private Session session = null;
    private List<Blake> blakeList = null;
    private Query q = null;
    
    public String getBlakeList(){
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            q=session.createQuery("from Blake");
            blakeList=(List<Blake>) q.list();
            session.close();
            tx.commit();
        }catch(HibernateException e){
            
        }
        return getListHTML(blakeList);
    }
    private String getListHTML(List<Blake> list){
        String wiersz;
        wiersz = ("<table><tr>");
        wiersz = wiersz.concat(
                "<td><b>TEXT</b></td>"
                +"<td><b>HASH</b></td>");
        wiersz = wiersz.concat("</tr>");
        
        for(Blake blk : list){
            wiersz = wiersz.concat("<tr>");
            wiersz = wiersz.concat("<td>" + blk.getText() + "</td>");
            wiersz = wiersz.concat("<td>" + blk.getHash()+ "</td>");
            wiersz = wiersz.concat("</tr>");
        }
        wiersz = wiersz.concat("</table>");
        return wiersz;
    }
    public void insert(Blake blake){
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(blake);
            tx.commit();
        }
        catch(Exception e){
            if(tx!=null)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
    public void delete(String text){
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Blake blake = (Blake) session.get(Blake.class,text);
            if(blake !=null){
                session.delete(blake);
            }
            tx.commit();  
        }
        catch(Exception e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
        public void update(Blake blake){
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(blake);
            tx.commit();
        }
        catch(Exception e){
            if(tx!=null)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
    public BlakeQuery(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();   
    }
    
}
