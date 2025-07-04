package com.example.commerce.CakeShopcommerce.controller;

import com.example.commerce.CakeShopcommerce.domain.staff.Staff;
import com.example.commerce.CakeShopcommerce.domain.staff.dtoStaff.UpdateStaff;
import com.example.commerce.CakeShopcommerce.domain.staff.repository.JpaRepositoryStaff;
import com.example.commerce.CakeShopcommerce.domain.staff.dtoStaff.staffRegistrationData;
import com.example.commerce.CakeShopcommerce.infra.generics.GenericResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.commerce.CakeShopcommerce.domain.staff.dtoStaff.DataStaffDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/staff")
public class controllerStaff {

    @Autowired
    private JpaRepositoryStaff repository;

    @PostMapping
    public ResponseEntity registerStaff(@RequestBody @Valid staffRegistrationData data, UriComponentsBuilder builder) {
        var staff = new Staff(data);
        repository.save(staff);
        var uri = builder.path("/staff/{id}").buildAndExpand(staff.getId()).toUri();
        return ResponseEntity.created(uri).body(new GenericResponse("Funcionario cadastrado com sucesso", new DataStaffDTO(staff)));
    }

    @GetMapping
    public ResponseEntity<?> employeeList(@PageableDefault(size = 5, sort = "id") Pageable pag) {
        var page = repository.findAllByActiveTrue(pag).map(DataStaffDTO::new);
        if (page.isEmpty()) {
            return ResponseEntity.ok(new GenericResponse("Lista de funcionario vazia"));
        }
        return ResponseEntity.ok(page);
    }

    //     @GetMapping("/{id}")
//    public ResponseEntity<?> detailStaff(@PathVariable Long id){
//        var staff = repository.getReferenceById(id);
//        return ResponseEntity.ok(new DataStaffDTO(staff));
//    }
    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateStaff data) {
        try {
            var staff = repository.getReferenceById(data.id());
            staff.update(data);
            return ResponseEntity.ok(new GenericResponse("Dados do funcionario atualizado com sucesso",new DataStaffDTO(staff)));
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericResponse("Funcionario com Id "+data.id()+" nao encontrado"));
        }

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            var staff = repository.getReferenceById(id);
            staff.remove(id);
            return ResponseEntity.ok("Funcionario com Id " + id + " desativado com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario com Id " + id + " nao encontrado.");
        }
    }
}
