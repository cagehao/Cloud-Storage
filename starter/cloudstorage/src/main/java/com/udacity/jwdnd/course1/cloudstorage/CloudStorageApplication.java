package com.udacity.jwdnd.course1.cloudstorage;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CloudStorageApplication {

	public static void main(String[] args) {

		SpringApplication.run(CloudStorageApplication.class, args);
		//Tomcat large file upload connection reset

	}


}
