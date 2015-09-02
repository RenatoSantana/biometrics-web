package br.gov.sspba.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class CheckRole {

	 public final boolean hasRole(String role) {
		    boolean hasRole = false;
		    UserDetails userDetails = getUserDetails();
		    if (userDetails != null) {
		    
		      Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) userDetails.getAuthorities();
		      if (isRolePresent(authorities, role)) {
		        hasRole = true;
		      }
		    } 
		    return hasRole;
		  }
		  /**
		   * Get info about currently logged in user
		   * @return UserDetails if found in the context, null otherwise
		   */
		  protected UserDetails getUserDetails() {
		    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    UserDetails userDetails = null;
		    if (principal instanceof UserDetails) {
		      userDetails = (UserDetails) principal;
		    }
		    return userDetails;
		  }
		  /**
		   * Check if a role is present in the authorities of current user
		   * @param authorities all authorities assigned to current user
		   * @param role required authority
		   * @return true if role is present in list of authorities assigned to current user, false otherwise
		   */
		  private boolean isRolePresent(Collection<GrantedAuthority> authorities, String role) {
		    boolean isRolePresent = false;
		    for (GrantedAuthority grantedAuthority : authorities) {
		      isRolePresent = grantedAuthority.getAuthority().equals(role);
		      if (isRolePresent) break;
		    }
		    return isRolePresent;
		  }
}
