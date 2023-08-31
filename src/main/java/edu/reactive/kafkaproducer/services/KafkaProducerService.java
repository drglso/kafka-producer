package edu.reactive.kafkaproducer.services;


import edu.reactive.kafkaproducer.models.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendKey(String topic, Student student) {
        var future = kafkaTemplate.send(topic, student.getId().toString(),
                student.toString());

        future.whenComplete((resultadoEnvio, excepcion) -> {
            if (excepcion != null) {
                LOGGER.error(excepcion.getMessage());
                future.completeExceptionally(excepcion);
            } else {
                future.complete(resultadoEnvio);
            }
            LOGGER.info("Student sent to Kafka topic: " + student);
        });
    }

    public void send(String topic, Student student) {
        var future = kafkaTemplate.send(topic, student.toString());

        future.whenComplete((resultadoEnvio, excepcion) -> {
            if (excepcion != null) {
                LOGGER.error(excepcion.getMessage());
                future.completeExceptionally(excepcion);
            } else {
                future.complete(resultadoEnvio);
            }
            LOGGER.info("Student sent to Kafka topic: " + student);
        });
    }
}