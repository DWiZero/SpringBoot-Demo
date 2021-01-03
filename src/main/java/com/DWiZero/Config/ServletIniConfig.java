package com.DWiZero.Config;

import com.DWiZero.Filter.RequestAddFilter;
import com.DWiZero.Application;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ServletComponentScan
public class ServletIniConfig extends SpringBootServletInitializer
{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean
    public FilterRegistrationBean contextFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(requestFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("requestAddFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public RequestAddFilter requestFilter() {
        return new RequestAddFilter();
    }

}
