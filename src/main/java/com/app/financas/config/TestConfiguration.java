package com.app.financas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.app.financas.services.DBService;

@Configuration
@Profile("test")
public class TestConfiguration {
	
	@Autowired
	private DBService dbs;
	
	@Bean //anotação para ser executado o método assim que subir a aplicação
	public void init() {
		this.dbs.initDados();
	}

}
