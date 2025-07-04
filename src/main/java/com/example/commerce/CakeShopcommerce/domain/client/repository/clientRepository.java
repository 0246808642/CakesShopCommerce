package com.example.commerce.CakeShopcommerce.domain.client.repository;

import com.example.commerce.CakeShopcommerce.domain.client.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Page<Client> findAllByActiveTrue(Pageable pag);
}
