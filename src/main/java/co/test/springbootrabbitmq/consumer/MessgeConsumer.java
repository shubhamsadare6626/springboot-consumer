package co.test.springbootrabbitmq.consumer;

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
	@RabbitListener(queues="${rabbitmq.test.queue}", priority="5", autoStartup = "true")
	public void messageConsumer(String message) {
		log.info("Message received of test : {}",message);
	}

	@RabbitListener(queues="${rabbitmq.test2.queue}", priority="2" ,autoStartup = "true")
	public void messageConsumerSecond(String message) {
		log.info("Message received of test2-> {}",message);
	}
	
	/**
	 * Assigns a Consumer to receive Json object received.
	 *
	 * @param user the user
	 */
	@RabbitListener(queues="${rabbitmq.json.queue}")
	public void jsonObjectReceived(User user) {
		log.info("Message received of json-> {}", user);
	}
	
	@RabbitListener(queues="${rabbitmq.json.email-queue}")
	public void jsonEmailReceived(User user) {
		log.info("Message received of json email-> {}", user.getEmail());
	}
}
