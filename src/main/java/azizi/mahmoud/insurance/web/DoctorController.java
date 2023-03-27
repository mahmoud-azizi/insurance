package azizi.mahmoud.insurance.web;

import azizi.mahmoud.insurance.model.dto.DoctorDto;
import azizi.mahmoud.insurance.model.entity.DoctorEntity;
import azizi.mahmoud.insurance.service.api.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/register")
    public DoctorEntity registerDoctor(@RequestBody DoctorDto doctorDto) throws Exception {
        return doctorService.register(doctorDto);
    }
}
