package rs.rbt.vacation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.rbt.vacation.entity.UsedVacationCompositeKey;
import rs.rbt.vacation.entity.VacationYear;
import rs.rbt.vacation.entity.VacationYearCompositeKey;


@Repository
public interface VacationYearRepository extends CrudRepository<VacationYear, VacationYearCompositeKey> {
}
