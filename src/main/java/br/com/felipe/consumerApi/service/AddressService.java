package br.com.felipe.consumerApi.service;

import br.com.felipe.consumerApi.model.Address;
import br.com.felipe.consumerApi.repository.AddressRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void save (Map<String, String> cep){
        ObjectMapper mapper = new ObjectMapper();
        Address address = mapper.convertValue(cep, Address.class);
        addressRepository.save(address);
    }

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public Address findByCep(String cep) {
       return addressRepository.findByCep(cep);
    }
}
