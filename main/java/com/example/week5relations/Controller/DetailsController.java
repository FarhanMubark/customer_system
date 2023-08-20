package com.example.week5relations.Controller;

import com.example.week5relations.Api.ApiResponse;
import com.example.week5relations.DTO.DetailsDTO;
import com.example.week5relations.Model.Customer;
import com.example.week5relations.Service.DetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/details")
@RequiredArgsConstructor
public class DetailsController {
    private final DetailsService detailsService;

    @GetMapping
    public ResponseEntity getalldetaild(){
        return ResponseEntity.status(200).body(detailsService.getall());
    }
    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody @Valid DetailsDTO detailsDTO){
        detailsService.addDetails(detailsDTO);

        return ResponseEntity.status(200).body(new ApiResponse("details added"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDetails(@PathVariable int id){
        detailsService.deleteDetails(id);
        return ResponseEntity.status(200).body(new ApiResponse("details delted"));

    }

    @PutMapping("/update")
    public ResponseEntity updateDetails( @RequestBody @Valid DetailsDTO detailsDTO){
        detailsService.updateInfo(detailsDTO);
        return ResponseEntity.status(200).body(new ApiResponse("updated !"));
    }
}
