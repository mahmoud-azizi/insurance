package azizi.mahmoud.insurance.web;

import azizi.mahmoud.insurance.model.dto.PatientDto;
import azizi.mahmoud.insurance.model.entity.PatientEntity;
import azizi.mahmoud.insurance.service.api.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/register")
    public PatientEntity registerEmployee(@RequestBody PatientDto patientDto) throws Exception {
        return patientService.register(patientDto);
    }
}
