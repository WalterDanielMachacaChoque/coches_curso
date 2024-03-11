package com.project.coches.persistance.repository;

import com.project.coches.domain.pojo.CarBrandPojo;
import com.project.coches.domain.repository.ICarBrandRepository;
import com.project.coches.persistance.entity.CarBrandEntity;
import com.project.coches.persistance.mapper.ICarBrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de marca coche
 */

@RequiredArgsConstructor //Crea constructor con los atributos final
@Repository
public class CarBrandRepository implements ICarBrandRepository {

    /**
     * Crud de marca coche
     */
    private final ICarBrandCrudRepository iCarBrandCrudRepository;

    /**
     * Mapper de marca coche
     */
    private final ICarBrandMapper iCarBrandMapper;

    /**
     * Devuelve una lsita con todas las marcas de los coches
     * @return Lista con marcas de coches
     */
    @Override
    public List<CarBrandPojo> getAll() {
        return iCarBrandMapper.toMarcasCochePojo(iCarBrandCrudRepository.findAll());
    }

    /**
     * Devuelve una marca de Coche dado su ID
     * @param id Id de la marca coche
     * @return Optional del marca coche encontrado
     */
    @Override
    public Optional<CarBrandPojo> getCarBrand(Integer id) {
        return iCarBrandCrudRepository.findById(id).map(iCarBrandMapper::toMarcaCochePojo);
    }

    /**
     * Guarda una nueva marca coche
     * @param newCarBrand marca coche a guardar
     * @return Marca coche guardada
     */
    @Override
    public CarBrandPojo save(CarBrandPojo newCarBrand) {
        CarBrandEntity carBrandEntity = iCarBrandMapper.toMarcaCocheEntity(newCarBrand);
        return iCarBrandMapper.toMarcaCochePojo(iCarBrandCrudRepository.save(carBrandEntity));
    }

    /**
     * Elimina una marca coche dada su Id
     * @param idCarBrand Id de la marca coche a eliminar
     */
    @Override
    public void delete(Integer idCarBrand) {
        iCarBrandCrudRepository.deleteById(idCarBrand);
    }
}
