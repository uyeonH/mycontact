package com.fastcampus.javaallinone.project3.mycontact.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Block {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    private String reason;

    private boolean block;

    private LocalDate startDate;

    private LocalDate endDate;


    
}
