package rs.rbt.vacation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.rbt.vacation.entity.UsedVacationDates;
import rs.rbt.vacation.entity.UsedVacationCompositeKey;

@Repository
public interface UsedVacationDateRepository extends CrudRepository<UsedVacationDates, UsedVacationCompositeKey> {}
