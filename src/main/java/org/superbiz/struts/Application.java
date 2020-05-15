package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean filterDispatch() {
        return buildFilterRegistration(2, new StrutsPrepareAndExecuteFilter(),
                asList("/", "/addUserForm.action", "/addUser.action", "/findUserForm.action", "/findUser.action", "/listAllUsers.action"));

    }

    @Bean
    public FilterRegistrationBean sitemeshFilter() {
        return buildSiteMeshFilterRegistration(1, new SiteMeshFilter(),
                singletonList("/*"));
    }

    private FilterRegistrationBean buildFilterRegistration(int order, StrutsPrepareAndExecuteFilter filter, List<String> urlPatterns) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.setUrlPatterns(urlPatterns);
        registration.setOrder(order);
        return registration;
    }

    private FilterRegistrationBean buildSiteMeshFilterRegistration(int order, SiteMeshFilter filter, List<String> urlPatterns) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.setUrlPatterns(urlPatterns);
        registration.setOrder(order);
        return registration;
    }
}
