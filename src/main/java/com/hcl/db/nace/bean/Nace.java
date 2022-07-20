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

    @Column(name = "naceparent")
    private String parent;

    @Column(name = "naceorder")
    private String order;

    @Column(name = "thisitemincludes")
    private String thisItemIncludes;

    @Column(name = "thisitemalsoincludes")
    private String thisItemAlsoIncludes;
    private String rulings;
    @Column(name = "thisitemexcludes")
    private String thisItemExcludes;

    @Column(name = "referencetoisisrev")
    private String referenceToISICRev;

}
