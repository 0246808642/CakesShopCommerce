package com.example.commerce.CakeShopcommerce.controller;
import com.example.commerce.CakeShopcommerce.domain.staff.dtoStaff.EmptyListStaffResponse;
import com.example.commerce.CakeShopcommerce.domain.staff.repository.JpaRepositoryStaff;
import com.example.commerce.CakeShopcommerce.domain.staff.dtoStaff.staff.EmptyListStaffResponse;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.commerce.CakeShopcommerce.domain.staff.dtoStaff.DataStaffDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class controllerStaff {

    @Autowired
    private JpaRepositoryStaff repository;

    @GetMapping
    public ResponseEntity<?> employeeList(@PageableDefault(size = 5, sort = "id") Pageable pag){
    var page = repository.findAllByActiveTrue(pag).map(DataStaffDTO::new);
        if(page.isEmpty()){
            return ResponseEntity.ok(new EmptyListStaffResponse("Lista de funcionario vazia"));
        }
        return  ResponseEntity.ok(page);
    }
}
