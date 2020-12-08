package gr.codehub.consumer;

import gr.codehub.dto.CustomerDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ConsumerExample {


    public static void main(String[] args) {

        String applicationUrl ="http://localhost:1005/customer";

        RestTemplate restTemplate = new RestTemplate();


     //   HttpEntity<Foo> request = new HttpEntity<>(new Foo("bar"));

     //   ResponseEntity<List<CustomerDto>> response = restTemplate
   //              .exchange(applicationUrl, HttpMethod.GET, request, Foo.class);



   //     Foo foo = response.getBody();


    }


}



