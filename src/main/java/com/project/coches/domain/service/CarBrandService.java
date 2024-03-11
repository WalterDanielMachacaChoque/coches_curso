package com.project.coches.domain.service;

import com.project.coches.domain.pojo.CarBrandPojo;
import com.project.coches.domain.repository.ICarBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * servicio de marca coche
 */
@RequiredArgsConstructor
@Service
public class CarBrandService implements ICarBrandService{

    /**
     * Repositorio de marca coche
     */
    private final ICarBrandRepository iCarBrandRepository;

    /**
     * Devuelve una lsita con todas las marcas de los coches
     * @return Lista con marcas de coches
     */
    @Override
    public List<CarBrandPojo> getAll() {
        return iCarBrandRepository.getAll();
    }

    /**
     * Devuelve una marca de Coche dado su ID
     * @param id Id de la marca coche
     * @return Optional del marca coche encontrado
     */
    @Override
    public Optional<CarBrandPojo> getCarBrand(Integer id) {
        return iCarBrandRepository.getCarBrand(id);
    }

    /**
     * Guarda una nueva marca coche
     * @param newCarBrand marca coche a guardar
     * @return Marca coche guardada
     */
    @Override
    public CarBrandPojo save(CarBrandPojo newCarBrand) {
        return iCarBrandRepository.save(newCarBrand);
    }

    /**
     * Actualiza una marca coche
     * @param newCarBrand Marca coche a actualizar
     * @return Optional con marca coche actualizada
     */
    @Override
    public Optional<CarBrandPojo> update(CarBrandPojo newCarBrand) {
        if (iCarBrandRepository.getCarBrand(newCarBrand.getId()).isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(iCarBrandRepository.save(newCarBrand));
    }

    /**
     * Elimina una marca coche dada su Id
     * @param idCarBrand Id de la marca coche a eliminar}
     * @return true si se elimino y false si es lo contrario
     */
    @Override
    public boolean delete(Integer idCarBrand) {
        if (iCarBrandRepository.getCarBrand(idCarBrand).isEmpty()) {
            return false;
        }

        iCarBrandRepository.delete(idCarBrand);
        return true;
    }
}
