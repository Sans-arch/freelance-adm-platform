package com.github.sansarch.freelance_adm_platform.customer.adapters.outbound.repository;

import com.github.sansarch.freelance_adm_platform.customer.adapters.outbound.repository.model.CustomerModel;
import com.github.sansarch.freelance_adm_platform.customer.domain.entity.Customer;
import com.github.sansarch.freelance_adm_platform.customer.domain.entity.CustomerId;
import com.github.sansarch.freelance_adm_platform.customer.domain.exception.CustomerNotFoundException;
import com.github.sansarch.freelance_adm_platform.customer.domain.repository.CustomerRepository;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Email;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private final CustomerJpaRepository customerJpaRepository;

    public CustomerRepositoryImpl(CustomerJpaRepository customerJpaRepository) {
        this.customerJpaRepository = customerJpaRepository;
    }

    @Override
    public Customer save(Customer customer) {
        CustomerModel model = new CustomerModel(customer);
        var persisted = customerJpaRepository.save(model);
        return new Customer(
                CustomerId.from(persisted.getId()),
                persisted.getName(),
                new Email(persisted.getEmail()),
                persisted.getPhone(),
                new Document(persisted.getDocument(), persisted.getDocumentType())
        );
    }

    @Override
    public Customer findById(CustomerId id) {
        return customerJpaRepository.findById(id)
                .map(model -> new Customer(
                        CustomerId.from(model.getId()),
                        model.getName(),
                        new Email(model.getEmail()),
                        model.getPhone(),
                        new Document(model.getDocument(), model.getDocumentType())
                ))
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id.getValue()));
    }

    @Override
    public boolean existsByEmail(Email email) {
        return customerJpaRepository.existsByEmail(email.value());
    }

    @Override
    public void deleteById(CustomerId id) {
        customerJpaRepository.deleteById(id);
    }
}
