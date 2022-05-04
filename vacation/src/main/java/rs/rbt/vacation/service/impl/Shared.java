package rs.rbt.vacation.service.impl;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Component
public class Shared {

    public List<CSVRecord> readCsvFile(MultipartFile file) throws IOException {
        Reader in = new InputStreamReader(file.getInputStream());
        CSVParser csvParser = new CSVParser(in, CSVFormat.DEFAULT);
        List<CSVRecord> records = csvParser.getRecords();
        return  records;
    }
}
