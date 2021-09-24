package com.truecaller.model;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CustomUserDetail implements UserDetails {

   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Long id;
    private final String username;
    private final boolean status;
    private List<String> userRoles;

    public CustomUserDetail(Long id, String password, String username, boolean status, List<String> userRoles) {
        this.id = id;
        this.username = username;
        this.status = status;
        this.userRoles = userRoles;
       
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isEnabled() {
        return status;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    public List<String> getUserRoles() {
        return userRoles;
    }

    

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @JsonIgnore
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

}
