package com.cabin.cabin.Reto3.Service;

import com.cabin.cabin.Reto3.Interfaz.Message;
import com.cabin.cabin.Reto3.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(Integer id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }else{
            Optional<Message> e = messageRepository.getMessage(message.getIdMessage());
            if(e.isPresent()){
                return message;
            }else{
                return messageRepository.save(message);
            }
        }
    }
}
