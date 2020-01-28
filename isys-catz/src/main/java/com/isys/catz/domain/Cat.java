package com.isys.catz.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class Cat {
    private String name;
    private Color color;
}
