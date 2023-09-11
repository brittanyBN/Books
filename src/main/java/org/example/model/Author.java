package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Author {

    @JsonProperty("name")
    private String name;

    @JsonProperty("key")
    private String key;

    public Author() {
    }
}
