/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sspba.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class JsfUtils {
   
    
    public static void setObjectSession(String key, Object value){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute(key, value);
    }
    
    public static Object getObjectSession(String key){
       HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
       HttpServletRequest request = (HttpServletRequest) req;
       HttpSession session = (HttpSession) request.getSession();
       return session.getAttribute(key);
        
    }
    
    public static String ltrim(String testeTrim) {
        return testeTrim.replaceAll("^\\s+", "");
    }
     
    public static String rtrim(String testeTrim) {
        return testeTrim.replaceAll("\\s+$", "");
    }
}
