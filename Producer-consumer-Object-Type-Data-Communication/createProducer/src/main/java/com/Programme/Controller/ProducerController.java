package com.Programme.Controller;

import com.Programme.Entity.Student;
import com.Programme.Service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class ProducerController {


    /*
       Here if we transfer message from postman to partition i.e Student Data and we have to create entity so the package name of both the Consumer and Producer
       Entity must be same and also we have to provide serialized properties in Producer so that in partition message is stored in serialized way and in consumer we have to provide
       provide deserialized so that the consumer get data in deserialized manner.
     */

    @Autowired
    private ProducerService sendMessage;

    @PostMapping("/producer")
    public ResponseEntity<String> producerSendMessageToKafka(@RequestBody Student student)
    {
        if(student!=null)
        {
            try{
                sendMessage.sendMessageToKafka(student);
                return ResponseEntity.status(HttpStatus.OK).body("Message Published Successfully............");
            }
            catch (Exception ex)
            {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }

        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Provide some message..........");
        }
    }




}
