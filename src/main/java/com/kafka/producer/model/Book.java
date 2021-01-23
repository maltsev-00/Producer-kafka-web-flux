package com.kafka.producer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @NotNull
    private UUID id;

    @Length(min = 3, max = 50,message = "Length min = 2, max = 50")
    private String name;

    @Size(min = 1,max = 3)
    private List<@Valid Author> authors;

    @Length(min = 5 ,max = 50)
    private String publisher;

    @NotEmpty(message = "Year can not be empty")
   // @JsonFormat(pattern = "yyyy")
    private String year;

    @Size(min = 1,max = 3, message = "Translators can be min = 1 , max = 3")
    private List<@NotBlank String> translators;

    @NotEmpty
    @Length(max = 50,message = "Length can be 50 max")
    private String description;

    @Size(min = 1,max = 3)
    private List<@NotBlank String> genre;

    @NotNull
    private Boolean isAvailable;

}
