package uz.example.meditsina.services;

import uz.example.meditsina.domeins.Patient;

import java.util.List;

public interface PatientService {

    void save(Patient patient);

    Patient getOnePatient(Long id);

    List<Patient> getAllPatients();

    void update(Patient patient, Long id);

    void delete(Long id);
}
