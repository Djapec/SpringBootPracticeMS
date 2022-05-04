package rs.rbt.vacation.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rs.rbt.vacation.entity.UsedVacationDates;
import rs.rbt.vacation.entity.UsedVacationCompositeKey;
import rs.rbt.vacation.repository.UsedVacationDateRepository;
import rs.rbt.vacation.service.UsedVacationDateService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
public class UsedVacationDateServiceImpl implements UsedVacationDateService {
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");

    @Autowired
    private UsedVacationDateRepository usedVacationDateRepository;

    @Autowired
    private Shared shared;

    public void saveVacationDates(UsedVacationDates data) {
        try {
            this.usedVacationDateRepository.save(data);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void UsedVacationDateFileParser(MultipartFile file) throws IOException {
        List<CSVRecord> records = shared.readCsvFile(file);
        records.remove(0);

        for (CSVRecord record : records) {
            saveVacationDates(mapToUsedVacationDate(record));
        }
    }

    public UsedVacationDates mapToUsedVacationDate(CSVRecord record) {
        String employee = record.get(0);
        LocalDate startDate = LocalDate.parse(record.get(1), dateTimeFormatter);
        LocalDate endDate = LocalDate.parse(record.get(2), dateTimeFormatter);
        UsedVacationCompositeKey usedVacationCompositeKey = new UsedVacationCompositeKey(employee,startDate);

        return new UsedVacationDates(usedVacationCompositeKey,endDate);
    }
}

