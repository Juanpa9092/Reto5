
package reto3.reto3.servicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import reto3.reto3.modelo.Reservaciones;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto3.reto3.modelo.ContadorClientes;
import reto3.reto3.repositorios.RepositorioReservaciones;
import reto3.reto3.repositorios.StatusReservas;

/**
 *
 * @author juanp
 */
@Service
public class ServiciosReservaciones {
    @Autowired
    private RepositorioReservaciones metodosCrud;
    
    public List<Reservaciones> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Reservaciones> getReservaciones(int reservacionesId){
        return metodosCrud.getReservaciones(reservacionesId);
    }
    
    public Reservaciones save(Reservaciones reservaciones){
        if(reservaciones.getIdReservation()==null){
            return metodosCrud.save(reservaciones);
        }else{
            Optional<Reservaciones> e = metodosCrud.getReservaciones(reservaciones.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservaciones);
            }else{
                return reservaciones;
            }
        }
    }
    
    public Reservaciones update(Reservaciones reservaciones){
        if(reservaciones.getIdReservation()!=null){
            Optional<Reservaciones> e=metodosCrud.getReservaciones(reservaciones.getIdReservation());
            if(!e.isEmpty()){
                if(reservaciones.getStartDate()!=null){
                    e.get().setStartDate(reservaciones.getStartDate());
                }
                if(reservaciones.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservaciones.getDevolutionDate());
                }
                if(reservaciones.getStatus()!=null){
                    e.get().setStatus(reservaciones.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservaciones;
            }
        }else{
            return reservaciones;
        }
    }


    public boolean deleteReservaciones(int reservacionesId) {
        Boolean aBoolean = getReservaciones(reservacionesId).map(reservaciones -> {
            metodosCrud.delete(reservaciones);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public StatusReservas reporteStatusServicio (){
        List<Reservaciones>completed= metodosCrud.ReservacionStatusRepositorio("completed");
        List<Reservaciones>cancelled= metodosCrud.ReservacionStatusRepositorio("cancelled");
        
        return new StatusReservas(completed.size(), cancelled.size() );
    }
    
    public List<Reservaciones> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        
        } 
    }
    
    public List<ContadorClientes> reporteClientesServicio(){
            return metodosCrud.getClientesRepositorio();
        }

    
}
