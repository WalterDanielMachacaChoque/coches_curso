package com.project.coches.domain.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * Pojo de marca Coche
 */
@Getter
@Setter
public class CarBrandPojo {

    /**
     * id de la marca
     */
    private Integer id;

    /**
     * descripcion de la marca
     */
    private String description;
}
