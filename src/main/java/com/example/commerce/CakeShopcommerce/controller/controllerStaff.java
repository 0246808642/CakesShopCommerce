package com.example.commerce.CakeShopcommerce.controller;
import com.example.commerce.CakeShopcommerce.domain.staff.Staff;
import com.example.commerce.CakeShopcommerce.domain.staff.dtoStaff.EmptyListStaffResponse;
import com.example.commerce.CakeShopcommerce.domain.staff.repository.JpaRepositoryStaff;
import com.example.commerce.CakeShopcommerce.domain.staff.dtoStaff.staffRegistrationData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.commerce.CakeShopcommerce.domain.staff.dtoStaff.DataStaffDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/staff")
public class controllerStaff {

    @Autowired
    private JpaRepositoryStaff repository;

    @PostMapping
    public ResponseEntity registerStaff(@RequestBody @Valid staffRegistrationData data, UriComponentsBuilder builder){
        var staff = new Staff(data);
        repository.save(staff);
        var uri = builder.path("/staff/{id}").buildAndExpand(staff.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DataStaffDTO(staff));
    }

    @GetMapping
    public ResponseEntity<?> employeeList(@PageableDefault(size = 5, sort = "id") Pageable pag){
    var page = repository.findAllByActiveTrue(pag).map(DataStaffDTO::new);
        if(page.isEmpty()){
            return ResponseEntity.ok(new EmptyListStaffResponse("Lista de funcionario vazia"));
        }
        return  ResponseEntity.ok(page);
    }
//     @GetMapping("/{id}")
//    public ResponseEntity<?> detailStaff(@PathVariable Long id){
//        var staff = repository.getReferenceById(id);
//        return ResponseEntity.ok(new DataStaffDTO(staff));
//    }
}
