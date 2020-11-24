package com.salesapp.authservice.config;


import com.salesapp.authservice.service.AuthClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthClientDetailsService authClientDetailsService;

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    // This should come from a environment variable in production
    private String privateKey = "MIIJKAIBAAKCAgEAubmb3zlCWuD3+fHx9aTyx039zoXIya6/LwQo4EX6XjRyHd1B\n" +
            "H18FUwuGJ2dwpmTQHRB79O3hbe1xSQf5JZoKupHo+PsoKBQJsBLhCnHI6NQI14rT\n" +
            "N4uKFVJiSCae6bihIt+Jw/F5MSmQdPM6MqEkmO4vkBuMVoNLFdJ9+uB8Hp9w0a0+\n" +
            "nyJR/5ccEkfflYPagyfsNgVXRn50EW1TujsZ+Uk66YFPNwdu3C9dPA+k9114K38O\n" +
            "CwTD/dJYBG+ZfEhRBiqo9Y0HdeD+RnGUK5nWmDsLgRV6fx23Oa+QvDyGcOLFCKHk\n" +
            "q95lPED+d82NZzmYqHrDVTqp164snodL15svqSxq1GAZQpGgopCDsNY0D1P49zEU\n" +
            "Id8BpuTH0wectzD/XhA64TSaB0htNfjAHQ1EHAY3v4vBBDfHkx6i4v6HEl/80LVH\n" +
            "qwFl2s9C0RSNurb2qTp65R1M8yl03U7vLbvwuCoMKOoZh3o1ph+wSqLln1VCoqz7\n" +
            "GpjkdnfL7y5jFTQXPP8lOhAXWS8KQOvwUkh2L2P442ZG0kf2uqDnaqpX47j9OlIO\n" +
            "tKSZnXbBzFtLrXrKrejhPtfochUOGtHXy6ZCpt4lW4rtOW8DRWEfJ/6SV+sLWJ5l\n" +
            "qOVZckgaaGcpa/oThW5cf6MkFgKXR5e4eOfJ6q3s4y+7FSZuFjX4IUe2kQMCAwEA\n" +
            "AQKCAgA+LbLOoAfkDw9WQbck601Qhn7jhoy7YOKm5fidZTA2G87cyrdDvnc031XR\n" +
            "mWLwgi3enScyz/U57VWRArdZ7GGNJs5dlRBToqm/pgJrkb6WnG49Yz/lh7T6AHPg\n" +
            "/fUUAHkKCNbBn/VYDTdMwCWKz8JF5PBNibuJNzmLG8aLmF5VjkGiISMm+cGEFV4T\n" +
            "jLaBAvzEDjiZuV4HvswzDWwLnD/M4sRzapRPsxBdbQoE0qQDIOrbfRUBgV3we1x2\n" +
            "V7qGDlv5+YxJcSa/Q0093kah9kYO/y2R0NQK/LLcADgvnP/RiUo34qOBGtq/um63\n" +
            "Qz0FAxZlyXvd697y02Aizt8IVu80XJsxZXQ+KGjJkrJ/ZFrliDpflBk3vrAdFygD\n" +
            "USsJ0n0sSifBydEuzdU7owigFnS4FdDEWhxZbMEJq83WFGhkQdsP4+c5LDYYcAo9\n" +
            "6SAQS/w/+m0X7H0QJMLMCAjBcOC5Hs8QUQqGFwCoYxtSFdBSjuOKbvSNA48rAsGf\n" +
            "PCihTr//mUW+7bnDfdRltJkMgy0GpPqslVN33uaFDQsrcWOQ/Vqtchj+RpmkPShj\n" +
            "Y99XfePHp6v9zv3xiz+3Srhc2Rr5xERHfLfuOzEcTGrsuuCR0TDJl8fe3TqLBui0\n" +
            "iX10dd5dS6qMJzNc9ybiRCI6pTfWicciinT9YZ6G7ss48Xxg2QKCAQEA7bls22XG\n" +
            "kA2AarkDuVSUxXpIRG1a4gJyksgy670njw33Y6GGK6Og4tUhbXbky8MuHsnW/q8R\n" +
            "p4nX50+gz9X+RLGbgq7fSlcapvr8F1rb/93NGWgYoMJ5Uu6UXEjNjMM8C3YIbmMW\n" +
            "wQWCshCI4OsdzGGzmhel/Aai1bvZaw5+2gXR0w+xTDDZEFMtrMb6yOsTG3X66CMD\n" +
            "Qz6/VJXVXKirpELGCkvcmNijZwjNjEhHDWyIY3rxn28mpa10g8GwYMdjyoyryvxN\n" +
            "AwJw94xxCdOyJiMtlYiXhu4ZkZAEIfHomb811DzTDF1jAIXPS5kCRu19wo8LZT6j\n" +
            "NKA7iUHkZFgy1wKCAQEAyADNf255iWMKHkbjlz1tka5lBBgbZ6QSJ334C76To95B\n" +
            "zPPxpWQdiDwiNyi/S93kD9wGmMC+/b+TX3e7o8thn6XeUhkjmjlFilbcSenxNTfT\n" +
            "hbHHNLcJ+3QQAAAMOmZpThVTgTLE8i/+a9GoPS8oZC7G1oIxvoCSeFf1NnrmAKHE\n" +
            "TFpTCrcIrtXWJ6prdX3DyLY6RXUzLlIrlX7iDvWDI9GJATOheyVYBfwIAuoEyiJU\n" +
            "8eC/gWZIJH3S+bK/9HOiA2+qedw8w5Cjt5SXaLS+yZQd6d5s6X41zFPFKv/t1wDK\n" +
            "vfryTl9SZ9LYQH8DK/UJD3hZHrhrMYurN/OrzeV5tQKCAQAo/SPL4IyQIgPWYvhF\n" +
            "aFQOiLsVMVXOSmW+8U32X7MGc34Ia71aoOgItH8DBNEGYSz+mga7+yusG5RiidRM\n" +
            "gbVJ2uXZbpWJl+M8j2IQFNaCE5hdnRlB/sY0inaCQvtOHguoXj2t6t/tgCm80iUH\n" +
            "wwJsTxxMoW85OVuyRqWCVAmDRiWbosULQhDrQ6xIcjajlgTBY2JTzFWvro4G457a\n" +
            "TyrpM6o59EKhCBmElnv6iCvYILKTlIs81klvn6zLWwYyaa7HKeIlKcONlUotJMYI\n" +
            "z7uT39ToR5j45uz5sD9GKxPUDqgVZDdvllqPqILJoiRGXoSkm013s4kodchOLlJX\n" +
            "Cu4ZAoIBAGE3gqwelxUg/xoYeyhYw5m8m32R+kA2kFyB7sBGsp1Eu9dT/HHYaEKA\n" +
            "eGE3fUTzZpgO62X0yuGs7YXKPXswsRNZHOfrMFMW46aK8ik7ffPQXxDtiVcmYcPI\n" +
            "dr6JR2hbv3QlCaITe4f9rD3ce1rCQW/xDNXYEzX2aTv2BUumEYbdGv3CKftbXO0f\n" +
            "JCnDvNgveatmaIy6m1Y4utbABkIfNM+EWoQrBKNHU7IVAA/qkMlwRroL9QqBHTAf\n" +
            "uR2GtaetTWM+NC9nzmGBPRNPNwm+Ub7KMIAtjeMxZhUb4wszu/h2ehY+lOljjDrL\n" +
            "UjKHipMjWHQcm7VDD1fV/DQGTcyXbsECggEBALTqlnussarkYucPR9OBxp8PCLCd\n" +
            "FtHlzHokF3PC3DC6xo1kWySPFILq1me4E2k3T3oqpWBTGP2Kz21SC9fcwsJW+ifo\n" +
            "7frCEddzh26sQYu4abFuJ7DP4qyl1MTgR9aVUZbD+EH/jUV25iF1LOWUmGIj4chY\n" +
            "Gh7EpZTIBCC1Un5jSjSc56ZBjQDO/DipzeQ0dlQTbE3ACWNJFRmNk446lCWqvMVK\n" +
            "jA5DVA7tXDbl6hSnKzdwStdE8UNE49SEk1ffBmkdGF4P46L6VhbxwkerhcM5d7kj\n" +
            "dWc7zoZyedRONJyvd6gozm0lOKy1Icq10KpGSi0yWL7scHNMusspYFzGD8M=";

    private String publicKey = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQC5uZvfOUJa4Pf58fH1pPLHTf3OhcjJrr8vBCjgRfpeNHId3UEfXwVTC4YnZ3CmZNAdEHv07eFt7XFJB/klmgq6kej4+ygoFAmwEuEKccjo1AjXitM3i4oVUmJIJp7puKEi34nD8XkxKZB08zoyoSSY7i+QG4xWg0sV0n364Hwen3DRrT6fIlH/lxwSR9+Vg9qDJ+w2BVdGfnQRbVO6Oxn5STrpgU83B27cL108D6T3XXgrfw4LBMP90lgEb5l8SFEGKqj1jQd14P5GcZQrmdaYOwuBFXp/Hbc5r5C8PIZw4sUIoeSr3mU8QP53zY1nOZioesNVOqnXriyeh0vXmy+pLGrUYBlCkaCikIOw1jQPU/j3MRQh3wGm5MfTB5y3MP9eEDrhNJoHSG01+MAdDUQcBje/i8EEN8eTHqLi/ocSX/zQtUerAWXaz0LRFI26tvapOnrlHUzzKXTdTu8tu/C4Kgwo6hmHejWmH7BKouWfVUKirPsamOR2d8vvLmMVNBc8/yU6EBdZLwpA6/BSSHYvY/jjZkbSR/a6oOdqqlfjuP06Ug60pJmddsHMW0utesqt6OE+1+hyFQ4a0dfLpkKm3iVbiu05bwNFYR8n/pJX6wtYnmWo5VlySBpoZylr+hOFblx/oyQWApdHl7h458nqrezjL7sVJm4WNfghR7aRAw== vanquanraf@example.com"; // This should come from a environment variable in production


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .passwordEncoder(passwordEncoder)
                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(authClientDetailsService);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .authenticationManager(authenticationManager)
                .tokenStore(tokenStore())
                .accessTokenConverter(tokenEnhancer());
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(tokenEnhancer());
    }

    /**
     * format token dạng jwt
     *
     * @return JwtAccessTokenConverter
     */
    @Bean
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(privateKey);
        //converter.setVerifierKey(publicKey);
        return converter;
    }

}
