package com.example.moviedata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Movie {

    @Id @NotNull @Min(value = 3) @Column(unique = true)
    private Integer id;

     @NotEmpty @Size(min = 2)
    private String name;

    @NotEmpty @Column(nullable = false) @Pattern(regexp = "drama|action|comedy")
    private String genre;

    @NotEmpty @Positive @Pattern(regexp = "1|2|3|4|5")
    private String rating;

    @NotEmpty @Positive @Min(60)
    private String duration;

   @NotEmpty @Pattern(regexp = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$")
    private  String launchDate;

}
