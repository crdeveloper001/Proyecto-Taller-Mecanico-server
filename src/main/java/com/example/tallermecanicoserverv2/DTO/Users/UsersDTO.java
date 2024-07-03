package com.example.tallermecanicoserverv2.DTO.Users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Users")
public class UsersDTO {

    @JsonProperty("_id")
    private int _id;

    @JsonProperty("Name")
    private String Name;

    @JsonProperty("Surname")
    private String Surname;

    @JsonProperty("Phone")
    private int Phone;

    @JsonProperty("CurrentEmail")
    private String Email;

    @JsonProperty("CurrentPassword")
    private String Password;

    @JsonProperty("CurrentPosition")
    private String CurrentPosition;

    @JsonProperty("Role")
    private String Role;



}
