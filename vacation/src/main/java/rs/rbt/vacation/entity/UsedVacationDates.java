package rs.rbt.vacation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "VACATION_DATES")
public class UsedVacationDates {

    @EmbeddedId
    private UsedVacationCompositeKey usedVacationCompositeKey;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    public UsedVacationDates(){};

    public UsedVacationDates(UsedVacationCompositeKey usedVacationCompositeKey, LocalDate endDate) {
        this.usedVacationCompositeKey = usedVacationCompositeKey;
        this.endDate = endDate;
    }
}
