package uz.example.meditsina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.example.meditsina.domeins.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
