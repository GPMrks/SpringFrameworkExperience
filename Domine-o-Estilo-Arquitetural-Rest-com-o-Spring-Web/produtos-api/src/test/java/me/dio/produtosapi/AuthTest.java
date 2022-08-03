package me.dio.produtosapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

//@SpringBootTest
//public class AuthTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void deveRetornarErroComCredenciaisInvalidas() throws Exception {
//
//
//    }

//@Test
//public void deveRetornarSucessoComCredenciaisValidas() throws Exception {
//        URI uri = new URI("/auth/signin");
//
//        String content = "{ \"username\" : \"karantes\" , \"senha\" : \"123456\"}";
//
//        mockMvc.perform(MockMvcRequestBuilders
//        .post(uri)
//        .content(content)
//        .contentType(MediaType.APPLICATION_JSON))
//        .andExpect(MockMvcResultMatchers
//        .status()
//        .is(200));
//        }
//}
