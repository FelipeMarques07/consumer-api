package br.com.felipe.consumerApi.repository;

import br.com.felipe.consumerApi.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

        Address findByCep(String cep);
}
