package org.example.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Work {

    @JsonProperty("key")
    private String key;

    @JsonProperty("title")
    private String title;

    @JsonProperty("edition_count")
    private int editionCount;

    @JsonProperty("authors")
    private List<Author> authors;

    @JsonProperty("has_full_text")
    private boolean hasFulltext;

    @JsonProperty("ia")
    private String ia;

    public Work() {
    }
}
