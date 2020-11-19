package com.uniform.authservice.config;

import com.uniform.authservice.repository.AdUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CustomLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {

    @Autowired
    private AdUserRepository userRepository;

    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations userData, String username) {

        List<GrantedAuthority> authorities = new ArrayList<>();


        //List<String> roleList = userRepository.findPermissionWithAuthoritiesByLogin(username);

        //for test
        List<String> roleList = new ArrayList<>();
        roleList.add("create_user");

        roleList.forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission)));

        return authorities;
    }
}