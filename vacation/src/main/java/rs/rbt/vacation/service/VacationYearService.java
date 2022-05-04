package rs.rbt.vacation.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rs.rbt.vacation.entity.VacationYear;

@Service
public interface VacationYearService {

    public static void saveVacationYear(VacationYear data) {}

    public static void fileParser(MultipartFile file){}
}
