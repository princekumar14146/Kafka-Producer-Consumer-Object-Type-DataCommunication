package com.Programme.consumer;

import com.Programme.Entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerConfig {


    @KafkaListener(topics = "princeTopic-demo", groupId = "sk-group-1")
    public void consumer1(Student student)
    {
       log.info("Consumer1 consume the message========================={}" ,student.toString());
    }






}
