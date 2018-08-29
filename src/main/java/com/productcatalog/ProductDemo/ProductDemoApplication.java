package com.productcatalog.ProductDemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import java.util.Collection;
import java.util.Collections;

@SpringBootApplication
public class ProductDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProductDemoApplication.class, args);
	}
        
@Override
     public void run(String...args)throws Exception
     {
     RestTemplate restTemplate = new RestTemplate();
     HttpHeaders headers = new HttpHeaders();
     headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
     String resourceURL = "http://cat-store-api.frostdigital.se/api";
     HttpEntity<String> entity = new HttpEntity<String>(headers);
     ResponseEntity<String> response = restTemplate.exchange(resourceURL, HttpMethod.GET,entity,String.class);
     if(response.getStatusCode()==HttpStatus.OK)  {
         System.out.println(response);
     }
     else{
     System.out.println("Error");
     }
     
     
     }
}
