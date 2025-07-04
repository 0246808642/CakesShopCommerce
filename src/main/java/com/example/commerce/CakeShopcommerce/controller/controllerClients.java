package com.example.commerce.CakeShopcommerce.controller;


import com.example.commerce.CakeShopcommerce.domain.client.*;
import com.example.commerce.CakeShopcommerce.domain.client.dtoClient.*;
import com.example.commerce.CakeShopcommerce.domain.client.repository.ClientRepository;
import com.example.commerce.CakeShopcommerce.infra.generics.GenericResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/client")
public class controllerClients {
    @Autowired
    private ClientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registerClient(@RequestBody @Valid customerRegistrationData data, UriComponentsBuilder uriBuilder){
        var client = new Client(data);
        repository.save(client);
        var uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();
        return  ResponseEntity.created(uri).body(new GenericResponse("Cliente cadastrado com sucesso",new Customerdetaildata(client)));
    }

    @GetMapping
    public ResponseEntity<?>  listClient(@PageableDefault(size = 5, sort = {"id"})Pageable pag){
    var page = repository.findAllByActiveTrue(pag).map(dataCustomer::new);
        if (page.isEmpty()) {
            return ResponseEntity.ok(new GenericResponse("Lista de clientes vazia."));
        }
    return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}") // busca por id
    public ResponseEntity<?> detailCustomer(@PathVariable Long id){
        try {
            var client = repository.getReferenceById(id);
            return ResponseEntity.ok(new GenericResponse("Dados detalhados do cliente "+ id,new DataPerfilCostumer(client)));
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericResponse("Cliente de id "+id+" nao encontrado"));
        }

    }


    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid updateClient data){
        try {
            var client = repository.getReferenceById(data.id());
            client.updateData(data);
            return ResponseEntity.ok(new GenericResponse("Dados atualizados com sucesso",new DataPerfilCostumer(client)));
        }catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericResponse("Cliente de id " + data.id() + " nao encontrado"));
        }

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        try {
            var client = repository.getReferenceById(id);
            client.remove();
            return  ResponseEntity.ok(new GenericResponse("Cliente de id "+id+" desativado com sucesso"));
        }catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericResponse("Cliente de id " + id + " nao encontrado"));
        }

    }


}
