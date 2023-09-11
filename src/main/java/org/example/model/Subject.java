package org.example.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Subject {

    @JsonProperty("key")
    private String key;

    @JsonProperty("name")
    private String name;

    @JsonProperty("subject_type")
    private String subjectType;

    @JsonProperty("work_count")
    private int workCount;

    @JsonProperty("works")
    private List<Work> works;

    public List<Work> getWorks() {
        return works;
    }
}
