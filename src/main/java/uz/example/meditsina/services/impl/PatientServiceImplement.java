package uz.example.meditsina.services.impl;

import org.springframework.stereotype.Service;
import uz.example.meditsina.domeins.Patient;
import uz.example.meditsina.repositories.PatientRepository;
import uz.example.meditsina.services.PatientService;

import java.util.List;

@Service
public class PatientServiceImplement implements PatientService {
    private final PatientRepository patientRepository;

    public PatientServiceImplement(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Patient getOnePatient(Long id) {
        return patientRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public void update(Patient patient, Long id) {
        Patient newPatient = patientRepository.findById(id).orElseThrow();
        newPatient.setFullName(patient.getFullName());
        newPatient.setAdress(patient.getAdress());
        newPatient.setBirthday(patient.getBirthday());
        newPatient.setDiagnose(patient.getDiagnose());
        newPatient.setPhone(patient.getPhone());
        patientRepository.saveAndFlush(newPatient);
    }

    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }
}
