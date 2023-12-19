package com.ooqn.entity.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CtsTeam {
    
    @Id
    @Column(length = 32)
    private String id;

    private String username;

    private String nickname;

    private String description;

    private Date createDate;

    private Date updateDate;

}
