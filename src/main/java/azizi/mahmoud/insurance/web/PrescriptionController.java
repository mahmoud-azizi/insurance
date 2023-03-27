package azizi.mahmoud.insurance.web;

import azizi.mahmoud.insurance.model.dto.PrescriptionDto;
import azizi.mahmoud.insurance.model.entity.PrescriptionEntity;
import azizi.mahmoud.insurance.service.api.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping("/write")
    public PrescriptionEntity writePrescription(@RequestBody PrescriptionDto prescriptionDto) throws Exception {
        return prescriptionService.writePrescription(prescriptionDto);
    }
}
