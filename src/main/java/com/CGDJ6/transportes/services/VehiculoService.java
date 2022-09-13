package com.CGDJ6.transportes.services;

import com.CGDJ6.transportes.entities.Usuario;
import com.CGDJ6.transportes.entities.Vehiculo;
import com.CGDJ6.transportes.repositories.UsuarioRepository;
import com.CGDJ6.transportes.repositories.VehiculoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehiculoService implements IVehiculoService{

    private VehiculoRepository vehiculoRepository;


    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<Vehiculo> listarVehiculo(String palabraClave) {
        if (palabraClave != null) {
            return vehiculoRepository.findAll(palabraClave);
        }
        return (List<Vehiculo>) vehiculoRepository.findAll();
    }

    /*
        @Override
    public List<Vehiculo> listarVehiculo() {


        return (List<Vehiculo>) vehiculoRepository.findAll();
    }*/




    @Override
    public void guardarVehiculo(Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);

    }

    @Override
    @Transactional
    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculoRepository.delete(vehiculo);

    }

    @Override
    public Vehiculo encontrarVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null);
    }




/*

    public List<Vehiculo> listarVehiculo( String palabraClave) {
        if (palabraClave != null){
            return vehiculoRepository.findAll(palabraClave);
        }
        return (List<Vehiculo>) vehiculoRepository.findAll();
    }
*/







}
