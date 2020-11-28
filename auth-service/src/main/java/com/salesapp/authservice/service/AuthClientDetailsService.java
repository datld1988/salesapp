package com.salesapp.authservice.service;

import com.salesapp.authservice.domain.AdApp;
import com.salesapp.authservice.repository.AdAppRepository;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AuthClientDetailsService implements ClientDetailsService {
    private final AdAppRepository adAppRepository;

    public AuthClientDetailsService(AdAppRepository adAppRepository) {
        this.adAppRepository = adAppRepository;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) {
        AdApp adApp = adAppRepository.findByClientId(clientId).orElseThrow(IllegalArgumentException::new);
        BaseClientDetails details = new BaseClientDetails();
        details.setClientId(clientId);
        details.setClientSecret(adApp.getClientSecret());
        details.setAuthorizedGrantTypes(Arrays.asList(adApp.getAuthorizedGrantTypes().split(",")));
        details.setScope(Arrays.asList(adApp.getScope().split(",")));

        return details;
    }
}
