CREATE TABLE vacation_dates
(
    id             BIGINT       NOT NULL,
    start_date     date         NOT NULL,
    end_date       date         NOT NULL,
    employee_email VARCHAR(255) NOT NULL,
    CONSTRAINT pk_vacation_dates PRIMARY KEY (id, employee_email)
);

CREATE TABLE vacation_days_per_years
(
    employee            VARCHAR(255) NOT NULL,
    year                VARCHAR(255) NOT NULL,
    total_vacation_days INT          NOT NULL,
    CONSTRAINT pk_vacation_days_per_years PRIMARY KEY (employee)
);

ALTER TABLE vacation_dates
    ADD CONSTRAINT FK_VACATION_DATES_ON_EMPLOYEE_EMAIL FOREIGN KEY (employee_email) REFERENCES vacation_days_per_years (employee);