package rs.rbt.vacation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Embeddable
public class UsedVacationCompositeKey implements Serializable {

    @Column(name = "employee_email", nullable = false)
    private String employeeEmail;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    public UsedVacationCompositeKey(String employeeEmail, LocalDate startDate) {
        this.employeeEmail = employeeEmail;
        this.startDate = startDate;
    }

    public UsedVacationCompositeKey() {}
}
