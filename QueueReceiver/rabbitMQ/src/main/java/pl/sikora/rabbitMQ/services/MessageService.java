package pl.sikora.rabbitMQ.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sikora.rabbitMQ.dao.Message;
import pl.sikora.rabbitMQ.dao.MessageRepo;

import java.util.Optional;

@Service
public class MessageService {

    private MessageRepo messageRepo;

    @Autowired
    public MessageService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    public Message save(Message message){
        return messageRepo.save(message);
    }

}
