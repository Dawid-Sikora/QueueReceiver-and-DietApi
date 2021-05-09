package pl.sikora.rabbitMQ.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer ID;

    private String topic;
    private String content;
    private String addressee;



}
