package br.com.alura.mvc.mudi;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
		protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/home/**").permitAll()
			.anyRequest().authenticated()
		.and()
		.formLogin(form -> form
            .loginPage("/login")
//            .defaultSuccessUrl("/home", true)
            .defaultSuccessUrl("/usuario/pedido", true)
            .permitAll()
        )
		.logout(logout -> {
			logout.logoutUrl("/logout")
				.logoutSuccessUrl("/home");
		}).csrf().disable();
	}
	
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//				.username("admin")
//				.password("admin")
//				.roles("ADM")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
	
	
//create table alura.users(
//    username varchar(50) not null primary key,
//    password varchar(200) not null,
//    enabled boolean not null
//);
//
//create table alura.authorities (
//    username varchar(50) not null,
//    authority varchar(50) not null,
//    constraint fk_authorities_users foreign key(username) references users(username)
//);
//create unique index ix_auth_username on alura.authorities (username,authority);	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
//		UserDetails user =
//				 User.builder()
//					.username("admin")
//					.password(encoder.encode("admin"))
//					.roles("ADM")
//					.build();
		
		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(encoder)
			//.withUser("admin").password(encoder.encode("admin")).roles("USER", "ADMIN").
			//.withUser(user) // ao usar pela primeira vez Descomentar!
			;		
	}	
}