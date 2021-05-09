package pl.sikora.rabbitMQ;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sikora.rabbitMQ.dao.Message;
import pl.sikora.rabbitMQ.dao.MessageRepo;
import pl.sikora.rabbitMQ.services.MessageService;

@RestController
public class MessageReceiver {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private MessageService messageService;

    @Autowired
    public MessageReceiver(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/receiveMesssage")
    public Message getMessage() {
        Message message = (Message) rabbitTemplate.receiveAndConvert("queue");
        return saveMessage(message);
    }

    public Message saveMessage(Message message) {
        return messageService.save(message);
    }


}
