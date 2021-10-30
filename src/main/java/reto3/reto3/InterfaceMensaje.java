/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package reto3.reto3;

import reto3.reto3.modelo.Mensaje;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author juanp
 */
public interface InterfaceMensaje extends CrudRepository<Mensaje, Integer>{
    
}
