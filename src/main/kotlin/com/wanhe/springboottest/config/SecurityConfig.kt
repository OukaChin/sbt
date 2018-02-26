package com.wanhe.springboottest.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.encoding.ShaPasswordEncoder
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
open class SecurityConfig {
    @Autowired
    private lateinit var userDetailsService: UserDetailsService

    fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .antMatchers("/", "/index", "/webjars/**", "/js/**", "/css/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(LoginAuthenticationSuccessHandler())
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and().rememberMe().key("SJSF4WUFS0WEVU29U2UDU2J389")
    }

    @Autowired
    private fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(ShaPasswordEncoder(512))// SHA-512
    }

    private class LoginAuthenticationSuccessHandler : SavedRequestAwareAuthenticationSuccessHandler() {
        override fun onAuthenticationSuccess(request: HttpServletRequest, response: HttpServletResponse,
                                             auth: Authentication) {
            val session = request.session
            session.setAttribute("loginUser", auth.name)
            super.onAuthenticationSuccess(request, response, auth)
        }
    }
}