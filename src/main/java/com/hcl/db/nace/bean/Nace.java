package com.hcl.db.nace.bean;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table
@ToString
public class Nace {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "nacecode")
    private String naceCode;
    @Column(name = "nacelevel")
    private String level;
    private String description;

}
