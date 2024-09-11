package com.zolotarev.currencyinfo.config;

import com.zolotarev.currencyinfo.mapper.CurrencyMapper;
import com.zolotarev.currencyinfo.mapper.CurrencyMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.Duration;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public CurrencyMapper currencyMapper() {
        return new CurrencyMapperImpl();
    }

    @Bean
    public CorsFilter corsFilter() {
        var corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        var corsConfiguration = new CorsConfiguration();

        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("X-Custom-Header");
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setExposedHeaders(List.of("X-OTHER-CUSTOM-HEADER"));
        corsConfiguration.setMaxAge(Duration.ofSeconds(30));
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(corsConfigurationSource);
    }

}
