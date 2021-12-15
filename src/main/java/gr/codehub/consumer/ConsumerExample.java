package gr.codehub.consumer;

import gr.codehub.dto.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
public class ConsumerExample {


    public static void main(String[] args) {

        String applicationUrl ="http://localhost:1005/customer";
        RestTemplate restTemplate = new RestTemplate();

        List<CustomerDto> response = restTemplate
                .getForObject(applicationUrl,  List.class) ;

        log.info("response {}",response);

    }


}



