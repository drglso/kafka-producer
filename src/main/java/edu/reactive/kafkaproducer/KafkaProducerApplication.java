package edu.reactive.kafkaproducer;

import edu.reactive.kafkaproducer.models.Student;
import edu.reactive.kafkaproducer.services.KafkaProducerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {
    private final KafkaProducerService kafkaProducerService;

    private static final String DEFAULT_TOPIC = "students-topic";

    public KafkaProducerApplication(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        producerData();
    }

    private void producerData() {

        kafkaProducerService.sendKey(DEFAULT_TOPIC, Student.builder()
                .documentType("CC")
                .documentNumber("123466")
                .groupID(1)
                .guardianID(10)
                .teacherID(5)
                .name("Juan Pablo Rodriguez Gomez")
                .id(125).build());

        kafkaProducerService.sendKey(DEFAULT_TOPIC, Student.builder()
                .documentType("TI")
                .documentNumber("987654")
                .groupID(2)
                .guardianID(55)
                .teacherID(4)
                .name("Juan Daniel Parra Quintero")
                .id(126).build());

        kafkaProducerService.sendKey(DEFAULT_TOPIC, Student.builder()
                .documentType("CD")
                .documentNumber("878787")
                .groupID(3)
                .guardianID(71)
                .teacherID(3)
                .name("Santiago Perez Amaya")
                .id(127).build());
    }

}
