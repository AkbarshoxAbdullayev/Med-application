package uz.example.meditsina.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.example.meditsina.domeins.Patient;
import uz.example.meditsina.services.PatientService;

import java.util.List;

@Controller
public class MainController {
    private final PatientService patientService;

    public MainController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/")
    public String getHomePage(Model model){
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "home";
    }

    @PostMapping("/add/patient")
    public String savePatient(Model model, @RequestParam String fullName,
                              @RequestParam String adress,
                              @RequestParam String birthday,
                              @RequestParam String diagnose,
                              @RequestParam String phone){
        Patient patient = new Patient(fullName, adress, birthday, diagnose, phone);
        patientService.save(patient);
        return "redirect:/";
    }
    @GetMapping("/patient/update/{id}")
    public String updatePatient(Model model, @PathVariable("id") Long id){
        Patient patient = patientService.getOnePatient(id);
        model.addAttribute("patient", patient);
        model.addAttribute("name","Update patient form");
        return "edit";
    }
    @PostMapping("/update/patient/{id}")
    public  String updatePatientForm(@PathVariable("id") Long id,
                                     @RequestParam String fullName,
                                     @RequestParam String adress,
                                     @RequestParam String birthday,
                                     @RequestParam String diagnose,
                                     @RequestParam String phone){
        Patient patient = new Patient(fullName, adress, birthday, diagnose, phone);
        patientService.update(patient, id);
        return "redirect:/";
    }
    @GetMapping("/patient/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        patientService.delete(id);
        return "redirect:/";
    }
}
