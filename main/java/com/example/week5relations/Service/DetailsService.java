package com.example.week5relations.Service;

import com.example.week5relations.Api.ApiException;
import com.example.week5relations.DTO.DetailsDTO;
import com.example.week5relations.Model.Customer;
import com.example.week5relations.Model.Details;
import com.example.week5relations.Repository.CustomerRepository;
import com.example.week5relations.Repository.DetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailsService {

    private final CustomerRepository customerRepository;
    private final DetailsRepository detailsRepository;
    public void addDetails(DetailsDTO detailsDTO){
        Customer customer = customerRepository.findCustomerById(detailsDTO.getCustomer_id());
        if (customer==null){
            throw new ApiException("No Customer found");
        }
        Details details= new Details(null, detailsDTO.getGender(), detailsDTO.getAge(),detailsDTO.getEmail(), customer);

        detailsRepository.save(details);
    }

    public List<Details> getall(){
        return detailsRepository.findAll();
    }

    public void deleteDetails(int id){
        Details details = detailsRepository.findDetailsById(id);

        if (details==null){
            throw new ApiException("No customer fiund");
        }

        detailsRepository.delete(details);

    }

    public void updateInfo(DetailsDTO detailsDTO){
    Details details = detailsRepository.findDetailsById(detailsDTO.getCustomer_id());

    if (details==null){
        throw new ApiException("Not found");
    }
        details.setGender(detailsDTO.getGender());
        details.setEmail(detailsDTO.getEmail());
        details.setAge(detailsDTO.getAge());
        detailsRepository.save(details);
    }


}
