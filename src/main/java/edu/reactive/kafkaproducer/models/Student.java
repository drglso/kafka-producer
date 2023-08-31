package edu.reactive.kafkaproducer.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private Integer id;
    private String documentType;
    private String documentNumber;
    private String name;
    private Integer guardianID;
    private Integer teacherID;
    private Integer groupID;

    @Override
    public String toString() {
        return "{" +
                " 'id':" + id +
                ", 'documentType':" + '\'' + documentType + '\'' +
                ", 'documentNumber':" + documentNumber +
                ", 'name':" + '\'' + name + '\'' +
                ", 'guardianID':" + guardianID +
                ", 'teacherID':" + teacherID +
                ", 'groupID':" + groupID +
                "}";
    }
}
