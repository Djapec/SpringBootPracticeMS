package rs.rbt.vacation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import rs.rbt.vacation.service.impl.UsedVacationDateServiceImpl;
import rs.rbt.vacation.service.impl.VacationYearServiceImpl;

import java.io.IOException;

@Slf4j
@RestController
public class VacationController {

    @Autowired
    private VacationYearServiceImpl vacationYearService;

    @Autowired
    private UsedVacationDateServiceImpl vacationDateService;

    @PostMapping(value = "/years", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> VacationYear(@RequestPart("file") MultipartFile file) {
        try {
            this.vacationYearService.vacationYearFileParser(file);
        } catch (IOException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "used-vacation-dates", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> UsedVacationDates(@RequestPart("file") MultipartFile file) {
        try {
            this.vacationDateService.UsedVacationDateFileParser(file);
        } catch (IOException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}


//    test purpose only
//    @GetMapping(value="test",produces = "application/json")
//    public ResponseEntity<String> Test(){
//        System.out.println("Usao sam ovde");
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

