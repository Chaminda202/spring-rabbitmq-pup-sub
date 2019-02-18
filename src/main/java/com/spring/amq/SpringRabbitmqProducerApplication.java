package com.spring.amq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.amq.configuration.CongifDetails;

@SpringBootApplication
public class SpringRabbitmqProducerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitmqProducerApplication.class, args);
	}
	@Autowired
	private CongifDetails congifDetails;

	/*@Value("${rabbitmq.queue}")
	private String queue;
			
	@Value("${rabbitmq.exchange}")
	private String exchange;
	
	@Value("${rabbitmq.routingkey}")
	private String routingKey;*/
		
	@Bean
    Queue queue() {
        return new Queue(congifDetails.getQueue(), false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(congifDetails.getExchange());
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(congifDetails.getRoutingKey());
    }

}
