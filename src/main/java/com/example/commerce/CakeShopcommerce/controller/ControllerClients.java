package com.example.commerce.CakeShopcommerce.controller;


import com.example.commerce.CakeShopcommerce.domain.client.DTO.EmptyListResponse;
import com.example.commerce.CakeShopcommerce.domain.client.*;
import com.example.commerce.CakeShopcommerce.domain.client.DTO.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/client")
public class ControllerClients {
    @Autowired
    private ClientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registerClient(@RequestBody @Valid customerRegistrationData data, UriComponentsBuilder uriBuilder){
        var client = new Client(data);
        repository.save(client);
        var uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();
        return  ResponseEntity.created(uri).body(new Customerdetaildata(client));
    }

    @GetMapping
    public ResponseEntity<?>  listClient(@PageableDefault(size = 5, sort = {"id"})Pageable pag){
    var page = repository.findAllByActiveTrue(pag).map(dataCustomer::new);
        if (page.isEmpty()) {
            return ResponseEntity.ok(new EmptyListResponse("Lista de clientes vazia."));
        }
    return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detailCustomer(@PathVariable Long id){
        var client = repository.getReferenceById(id);
        return ResponseEntity.ok( new DataperfilCostumer(client));
    }


    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid updateClient data){
        var client = repository.getReferenceById(data.id());
        client.updateData(data);
        return ResponseEntity.ok(new DataperfilCostumer(client));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var client = repository.getReferenceById(id);
        client.excluir();
        return  ResponseEntity.noContent().build();
    }

}
