package com.me.myfinal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Example;
import org.hibernate.query.Query;


import com.me.myfinal.pojo.Apt;
import com.me.myfinal.pojo.User;



public class UserDAO extends DAO{

	public User authenticateUser(User user) {
		Criteria c = getSession().createCriteria(User.class);
		c.add(Example.create(user));
		User u = (User)c.uniqueResult();
		return u;
	}
	
	public User register(User u) throws Exception {
        try {
            begin();
            System.out.println("inside DAO");
            getSession().save(u);
            commit();
            return u;

        } catch (HibernateException e) {
            rollback();
            throw new Exception("Exception while creating user: " + e.getMessage());
        }
    }
	
	public User getUser(String id) {
		int userid = Integer.parseInt(id);
		try {
            begin();
            Query q = getSession().createQuery("from User where id= :id");
            q.setInteger("id", userid);
            User u=(User)q.uniqueResult();
            commit();
            return u;
        } catch (HibernateException e) {
            rollback();
            return null;
        }
	}
	public boolean addApt(String aptid, User u) {
		AptDAO aptDao = new AptDAO();
		Apt apt = aptDao.getApt(aptid);
    	u.getApt().add(apt);
    	try {
    		begin();
    		getSession().update(u);;
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
	
}
