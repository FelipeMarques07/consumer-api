package br.com.felipe.consumerApi.controller;

import br.com.felipe.consumerApi.model.Address;
import br.com.felipe.consumerApi.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity <List<Address>> listAddress(){
        List<Address> addresses = addressService.findAll();
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/address/{cep}")
    public ResponseEntity<Address> findAddressByCep(@PathVariable (value= "cep") String cep){
        Address address = addressService.findByCep(cep);
        return ResponseEntity.ok(address);
    }
}
