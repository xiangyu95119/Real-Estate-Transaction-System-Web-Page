package com.me.myfinal.controller;

import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.me.myfinal.dao.DAOFactory;
import com.me.myfinal.dao.AptDAO;
import com.me.myfinal.dao.UserDAO;
import com.me.myfinal.pojo.Apt;
import com.me.myfinal.pojo.User;




@Controller
public class UserController {
	@Autowired
	DAOFactory daoFactory;
	
	 @RequestMapping(value = "/user/create.htm", method = RequestMethod.GET)
	    public String showCreateForm() {

	        return "user-create-form";
	    }
	    
	 @RequestMapping(value = "/user/create.htm", method = RequestMethod.POST)
	    public String handleCreateForm(HttpServletRequest request, UserDAO userDao, ModelMap map) throws Exception {
	            HttpSession session = request.getSession();
	            String userName = request.getParameter("userName");
	            String useremail = request.getParameter("useremail");
	            String password = request.getParameter("password");
	            String userRole = request.getParameter("userRole");
	            User user = new User();
	            user.setUserEmail(useremail);
	            user.setPassword(password);
	            user.setUserName(userName);
	            user.setStatus(0);
	            user.setUserRole(userRole);
	            userDao.register(user);
	            return "user-created";
	    }
	
	
	@RequestMapping(value = "/user/login.htm", method = RequestMethod.GET)
	public String showLoginForm(ModelMap model) {
		User u = new User();
		model.addAttribute("user",u);
		return "user-form";
	}
	
	@RequestMapping(value = "/user/login.htm", method = RequestMethod.POST)
	public String showSuccessPage(@ModelAttribute User command, ModelMap model, HttpServletRequest request){
		UserDAO userDAO = daoFactory.createUserDAO();
		
		User authenticatedUser = userDAO.authenticateUser(command);
		if ((authenticatedUser != null)&&(authenticatedUser.getUserRole().equals("admin"))) {
			HttpSession httpsession=request.getSession(true);
            httpsession.setAttribute("userid", authenticatedUser.getId());
            httpsession.setAttribute("username", authenticatedUser.getUserName());
            return "user-success-admin";
		}
		if ((authenticatedUser != null)&&(authenticatedUser.getUserRole().equals("user"))) {
			HttpSession httpsession=request.getSession(true);
            httpsession.setAttribute("userid", authenticatedUser.getId());
            httpsession.setAttribute("username", authenticatedUser.getUserName());
            return "user-success-user";
		}
		else {
			model.addAttribute("errormessage","username/password is incorrect");
            return "error-page";
		}	
	}
	 @RequestMapping(value = "/admin/newApt.htm", method = RequestMethod.GET)
	    public String showNewAptForm() {

	        return "newApt";
	    }
	    	
	@RequestMapping(value = "/admin/newApt.htm", method = RequestMethod.POST)
	public String handleEditeForm(HttpServletRequest request, AptDAO aptDao, ModelMap map) throws Exception {
        HttpSession session = request.getSession();
        String aptName = request.getParameter("aptName");
        String location = request.getParameter("location");
        String price= request.getParameter("price");
        
        Apt apt = new Apt();
        apt.setAptName(aptName);
        apt.setLocation(location);
        apt.setPrice(price);
        aptDao.newApt(apt);
        
        return "apt-created";
}
	
	 @RequestMapping(value = "/admin/editApt.htm", method = RequestMethod.GET)
		public ModelAndView handleCreateForm(HttpServletRequest request, AptDAO aptDao, ModelMap map) throws Exception {
	        HttpSession session = request.getSession();
	        List<Apt> apts = aptDao.list();
			return new ModelAndView("editApt", "apts", apts);           
	}
	 
	 @RequestMapping(value = "/admin/deleteApt.htm", method = RequestMethod.GET)
		public ModelAndView EditAptForm(HttpServletRequest request) throws Exception {  
		    AptDAO aptDao= daoFactory.createAptDAO();
		    String id = request.getParameter("name");
	        boolean deleteApt=aptDao.deleteApt(id);
	        if(deleteApt)return new ModelAndView("deleteApt");   
	        return null;
	}
	 
	 @RequestMapping(value = "/user/findApt.htm", method = RequestMethod.GET)
		public ModelAndView handleFindForm(HttpServletRequest request, AptDAO aptDao, ModelMap map) throws Exception {
	        HttpSession session = request.getSession();
	        List<Apt> apts = aptDao.list();
			return new ModelAndView("findApt", "apts", apts);           
	}
	 
	 @RequestMapping(value = "/user/addApt.htm", method = RequestMethod.GET)
		public ModelAndView AddAptForm(HttpServletRequest request) throws Exception {  
		    UserDAO userDao= daoFactory.createUserDAO();
		    String aptid = request.getParameter("name");
		    String userid = request.getParameter("userid");
		    User u = userDao.getUser(userid);
		    Set<Apt> apts =u.getApt();
	        boolean AddApt=userDao.addApt(aptid, u);
	        if(AddApt)return new ModelAndView("aptlist","apts",apts);   
	        return null;
	}
	
	 @RequestMapping(value = "/user/aptlist.htm", method = RequestMethod.GET)
	 public ModelAndView AptListForm(HttpServletRequest request) throws Exception {  
		 HttpSession session = request.getSession();
		 UserDAO userDao= daoFactory.createUserDAO();
		 String userid = request.getParameter("userid");
		 
		 System.out.println("*** User ID: " + userid);
		 
		 User u = userDao.getUser(userid);
		 Set<Apt> apts =u.getApt();
		 return new ModelAndView("aptlist", "apts", apts); 
		 }
	 
	 @RequestMapping(value = "/user/deleteApt.htm", method = RequestMethod.GET)
		public ModelAndView DeleteAptForm(HttpServletRequest request) throws Exception {  
		    UserDAO userDao= daoFactory.createUserDAO();
		    AptDAO aptDao = daoFactory.createAptDAO();
		    String aptid = request.getParameter("name");
		    String userid = request.getParameter("userid");
		    User u = userDao.getUser(userid);
		    Apt a =  aptDao.getApt(aptid);
		    Set<Apt> apts =u.getApt();
		    apts.remove(a);
		    u.setApt(apts);
	        return new ModelAndView("aptlist","apts",apts);   
	        
	}
}
