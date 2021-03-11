package com.by.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
@JsonDeserialize(as = CanvasInstance.class)
public class CanvasInstance implements Serializable {
    private String listingName;
    private String instanceName;
    private String owner;
    private String displayName;
    private String description;
    private boolean shared;
    private String publishedToSome;
    private String mode;
    private String createdBy;
    private String dashboardType;
}
