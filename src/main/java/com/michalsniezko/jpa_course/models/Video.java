package com.michalsniezko.jpa_course.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
// @DiscriminatorValue("V")
//@PrimaryKeyJoinColumn(name = "video_id")
public class Video extends Resource {
    private int length;
}
