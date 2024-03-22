package com.Programme.Service;

import com.Programme.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<Student,Object> template;


    public void sendMessageToKafka(Student student)
    {
      CompletableFuture<SendResult<Student, Object>> future=template.send("princeTopic-demo", student);

      future.whenComplete((result,ex)->{
          if(ex==null)
          {
              System.out.println("sent message=[" +student.toString()+ "] with offset=[" +result.getRecordMetadata().offset()+"]");
          }
          else
          {
              System.out.println("Unable to send message=[" +student.toString()+ "] due to :"+ex.getMessage());
          }
      });


    }



}
