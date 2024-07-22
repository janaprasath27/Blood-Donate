package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BloodDonorService {

    @Autowired
    private BloodDonorRepository bloodDonorRepository;

    // Save a new blood donor
    public BloodDonor saveBloodDonor(BloodDonor bloodDonor) {
        return bloodDonorRepository.save(bloodDonor);
    }

    // Get all blood donors
    public List<BloodDonor> getAllBloodDonors() {
        return bloodDonorRepository.findAll();
    }

    // Find a blood donor by ID
    public Optional<BloodDonor> getBloodDonorById(Long id) {
        return bloodDonorRepository.findById(id);
    }

    // Update a blood donor
    public BloodDonor updateBloodDonor(Long id, BloodDonor updatedDonor) {
        return bloodDonorRepository.findById(id)
                .map(existingDonor -> {
                    existingDonor.setName(updatedDonor.getName());
                    existingDonor.setBloodType(updatedDonor.getBloodType());
                    existingDonor.setContactInfo(updatedDonor.getContactInfo());
                    return bloodDonorRepository.save(existingDonor);
                })
                .orElseThrow(() -> new RuntimeException("Donor not found with id: " + id));
    }

    // Delete a blood donor
    public void deleteBloodDonor(Long id) {
        bloodDonorRepository.deleteById(id);
    }
}
