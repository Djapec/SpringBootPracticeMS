package rs.rbt.vacation.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rs.rbt.vacation.entity.VacationYear;
import rs.rbt.vacation.entity.VacationYearCompositeKey;
import rs.rbt.vacation.repository.VacationYearRepository;
import rs.rbt.vacation.service.VacationYearService;

import java.io.*;
import java.util.List;

@Slf4j
@Service
public class VacationYearServiceImpl implements VacationYearService {

    @Autowired
    private VacationYearRepository vacationYearRepository;

    @Autowired
    private Shared shared;

    public void saveVacationYear(VacationYear data){
        try {
            this.vacationYearRepository.save(data);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public void vacationYearFileParser(MultipartFile file) throws IOException {
        List<CSVRecord> records = shared.readCsvFile(file);

        String year = records.get(0).get(1);
        records.remove(0);
        records.remove(0);

        for (CSVRecord record : records) {
            saveVacationYear(mapToVacationYear(record, year));
        }
    }

    public VacationYear mapToVacationYear(CSVRecord record, String year){
        String employee = record.get(0);
        int totalVacationDays = Integer.parseInt(record.get(1));

        VacationYearCompositeKey vacationYearCompositeKey = new VacationYearCompositeKey(employee,year);

        return new VacationYear(vacationYearCompositeKey,totalVacationDays);
    }
}
