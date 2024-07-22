package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BloodDonorController {

    @Autowired
    private BloodDonorRepository bloodDonorRepository;

    @GetMapping("/blood-donor-form")
    public String showForm(Model model) {
        model.addAttribute("bloodDonor", new BloodDonor());
        return "blood-donor-form";
    }

    @PostMapping("/submit-blood-donor")
    public String submitForm(@ModelAttribute BloodDonor bloodDonor, Model model) {
        bloodDonorRepository.save(bloodDonor);
        model.addAttribute("message", "Blood Donor registered successfully");
        return "result";
    }

    @GetMapping("/blood-donors")
    public String showDonors(Model model) {
        List<BloodDonor> bloodDonors = bloodDonorRepository.findAll();
        model.addAttribute("bloodDonors", bloodDonors);
        return "blood-donor-list";
    }
}

