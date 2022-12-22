package com.example.FulLstackbackend.Repository;

import com.example.FulLstackbackend.Model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepo extends JpaRepository<Register, Long> {
}
