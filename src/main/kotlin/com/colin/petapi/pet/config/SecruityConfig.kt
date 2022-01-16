package com.colin.petapi.pet.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@PropertySource("classpath:application.properties")
class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Value("\${security.user.name}")
    private lateinit var userName: String

    @Value("\${security.user.password}")
    private lateinit var password: String

    @Bean
    fun encoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
            .withUser(userName)
            .password(encoder().encode(password))
            .roles("ADMIN")
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/pets").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST, "/pets").hasRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "/pets").hasRole("ADMIN")
            .antMatchers(HttpMethod.PUT, "/pets").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "/owners").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST, "/owners").hasRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "/owners").hasRole("ADMIN")
            .antMatchers(HttpMethod.PUT, "/owners").hasRole("ADMIN")
            .and()
            .csrf().disable()
            .formLogin().disable()
    }

}