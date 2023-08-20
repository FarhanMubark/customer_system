package com.example.week5relations.Repository;

import com.example.week5relations.Model.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Integer> {

            Details findDetailsById(Integer id);
}
