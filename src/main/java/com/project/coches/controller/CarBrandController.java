package com.project.coches.controller;

import com.project.coches.domain.pojo.CarBrandPojo;
import com.project.coches.domain.service.ICarBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador rest de marca coche
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/marcas-coches")
public class CarBrandController {

    /**
     * Servicio de marca coche
     */
    private final ICarBrandService iCarBrandService;

    @GetMapping()
    public ResponseEntity<List<CarBrandPojo>> getAll() {
        return ResponseEntity.ok(iCarBrandService.getAll());
        // return ResponseEntity.status(HttpStatus.)
        //        .body(iBrandCarService.getAll()); ALTEeRNATIVA PARA CREAR RESPONSE_ENTITY

        // return new ResponseEntity<>(iBrandCarService.getAll(), HttpStatus.OK); ALTERNATIVA PARA CREAR RESPONSE_ENTITY
    }

    /**
     * Devuelve una marca coche dado su ID
     * @param id id de la marca coche a buscar
     * @return HttpCode Ok si lo encuentra, HttpCode Not Found de lo contrario
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<CarBrandPojo> getCarBrand(@PathVariable Integer id){
        return ResponseEntity.of(iCarBrandService.getCarBrand(id));
    }

    @PostMapping
    public ResponseEntity<CarBrandPojo> save(@RequestBody CarBrandPojo CarBrandPojoNew) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iCarBrandService.save(CarBrandPojoNew));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Actualiza una nueva marca coche
     * @param carBrandPojoUpdate Marca coche actualizada
     * @return HttpCode Ok si la actualiza correctamente
     */
    @PatchMapping
    public ResponseEntity<CarBrandPojo> update(@RequestBody CarBrandPojo carBrandPojoUpdate){
        return ResponseEntity.of(iCarBrandService.update(carBrandPojoUpdate));
    }

    /**
     * Elimina una marca coche dado su id
     * @param id id de la marca coche a eliminar
     * @return HttpCode Ok si lo elimina, HttpCode NotFound si no la encuentra
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iCarBrandService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
