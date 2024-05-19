package co.test.springbootrabbitmq.consumer;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import co.test.springbootrabbitmq.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessgeConsumer {

	/**
	 * Assigns a Consumer to receive the messages whenever there is one
	 *
	 * @param message
	 */
	@RabbitListener(queues="${rabbitmq.test.queue}", priority="0", autoStartup = "true")
	public void messageConsumer(String message) {
		try {
            log.info("Message received for test queue: {}", message);
            //Perform Business logic
        } catch (Exception ex) {
            log.error("Failed to process message from test queue: {}", ex.getMessage(), ex);
        }	
	}

	@RabbitListener(queues="${rabbitmq.test2.queue}", priority="1" ,autoStartup = "true")
	public void secondMessageConsumer(String message) {
		try {
			log.info("Message received for test2 queue: {}",message);
	    } catch (Exception ex) {
            log.error("Failed to process message from test2: {}", ex.getMessage(), ex);
        }
	}
	
	/**
	 * Assigns a Consumer to receive Json object received.
	 *
	 * @param user the user
	 */
	@RabbitListener(queues="${rabbitmq.json.queue}")
	public void jsonObjectReceived(User user) {
		try {
			log.info("Message received of json-> {}", user);
		} catch (AmqpException ex) {
            log.error("Failed to process message from json: {}", ex.getMessage(), ex);
		}
	}
	
	@RabbitListener(queues="${rabbitmq.json.email-queue}")
	public void jsonEmailReceived(User user) {
		try {
			log.info("Message received email from json-> {}", user.getEmail());
		} catch (AmqpException ex) {
            log.error("Failed to process message from json email: {}", ex.getMessage(), ex);
		}
	}
}
