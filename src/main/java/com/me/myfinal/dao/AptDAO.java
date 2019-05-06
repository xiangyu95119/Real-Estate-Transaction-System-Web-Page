package com.me.myfinal.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;


import com.me.myfinal.pojo.Apt;
import com.me.myfinal.pojo.User;

public class AptDAO extends DAO{

	public Apt newApt(Apt u) throws Exception {
        try {
            begin();
            getSession().save(u);
            commit();
            return u;

        } catch (HibernateException e) {
            rollback();
            throw new Exception("Exception while creating apt: " + e.getMessage());
        }
    }
	public Apt getApt(String aptid) {
		int aptID = Integer.parseInt(aptid);
		try {
            begin();
            Query q = getSession().createQuery("from Apt where aptid= :aptid");
            q.setInteger("aptid", aptID);
            Apt u=(Apt)q.uniqueResult();
            commit();
            return u;
        } catch (HibernateException e) {
            rollback();
            return null;
        }
	}
	
	 public boolean deleteApt(String aptid) {
	    	Apt apt = new Apt();
	    	int id = Integer.parseInt(aptid);
	    	apt.setAptid(id);
	    	try {
	    		begin();
	    		getSession().delete(apt);
	    		commit();
	    		return true;
	    	}catch(HibernateException e){
	    		rollback();
	    		e.printStackTrace();
	    	}finally {
	    		close();
	    	}
	    	return false;
	    }
	 
	 public List<Apt> list(){
	    	
	    	try {
	            begin();
	            Query q = getSession().createQuery("from Apt");
	            List<Apt> apts = q.list();
	            commit();
	            return apts;
	        } catch (HibernateException e) {
	            rollback();
	            return null;
		}

	}

}
