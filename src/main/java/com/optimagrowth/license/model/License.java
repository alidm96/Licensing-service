package com.optimagrowth.license.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.hateoas.RepresentationModel;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class License extends RepresentationModel<License> {

    int id;
    String licenseId;
    String description;
    String productName;
    String licenseType;
    String organizationId;

}
