package rs.rbt.vacation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "VACATION_DAYS_PER_YEARS")
public class VacationYear {

    @EmbeddedId
    private VacationYearCompositeKey vacationYearCompositeKey;

    @Column(name = "total_vacation_days", nullable = false)
    private Integer totalVacationDays;

    public VacationYear() {}

    public VacationYear(VacationYearCompositeKey vacationYearCompositeKey, Integer totalVacationDays) {
        this.vacationYearCompositeKey = vacationYearCompositeKey;
        this.totalVacationDays = totalVacationDays;
    }
}
