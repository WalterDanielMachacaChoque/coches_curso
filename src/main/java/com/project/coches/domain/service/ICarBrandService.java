package com.project.coches.domain.service;

import com.project.coches.domain.pojo.CarBrandPojo;

import java.util.List;
import java.util.Optional;

public interface ICarBrandService {

    /**
     * Devuelve una lsita con todas las marcas de los coches
     * @return Lista con marcas de coches
     */
    List<CarBrandPojo> getAll();

    /**
     * Devuelve una marca de Coche dado su ID
     * @param id Id de la marca coche
     * @return Optional del marca coche encontrado
     */
    Optional<CarBrandPojo> getCarBrand(Integer id);

    /**
     * Guarda una nueva marca coche
     * @param newCarBrand marca coche a guardar
     * @return Marca coche guardada
     */
    CarBrandPojo save(CarBrandPojo newCarBrand);

    /**
     * Actualiza una marcha coche
     * @param newCarBrand Marca coche a actualizar
     * @return Marca coche actualizada
     */
    Optional<CarBrandPojo> update(CarBrandPojo newCarBrand);

    /**
     * Elimina una marca coche dada su Id
     * @param idCarBrand Id de la marca coche a eliminar
     */
    boolean delete(Integer idCarBrand);
}
