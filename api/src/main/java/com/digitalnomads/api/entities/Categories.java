package com.digitalnomads.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Categories extends BaseEntity{
    @JsonInclude(JsonInclude.Include.NON_NULL)
     String id;
     String name;
     String price;
    @JsonProperty(value = "category_id")
    String categoryId;
}




