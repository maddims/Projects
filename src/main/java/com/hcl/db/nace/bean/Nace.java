package com.hcl.db.nace.bean;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Nace {

    private String level;
    private String description;
}
