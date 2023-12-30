package com;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class Listener implements HttpSessionListener {
	
		int cUser = 0;
		int tUser = 0;
		@Override
		public void sessionCreated(HttpSessionEvent se) {
			
			//System.out.println("session created");
			cUser++;
			tUser++;
			ServletContext cx = se.getSession().getServletContext();
			cx.setAttribute("cUser", cUser+"");
			cx.setAttribute("tUser", tUser+"");
		}
		
		@Override
		public void sessionDestroyed(HttpSessionEvent se) {
			//System.out.println("session destroyed");
			cUser--;
			ServletContext cx = se.getSession().getServletContext();
			cx.setAttribute("cUser", cUser);
		}
}
