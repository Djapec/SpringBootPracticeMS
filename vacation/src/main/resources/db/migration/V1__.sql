CREATE TABLE vacation_dates
(
    id                  BIGINT       NOT NULL,
    email               VARCHAR(255) NOT NULL,
    total_vacation_days INT          NOT NULL,
    CONSTRAINT pk_vacation_dates PRIMARY KEY (id)
);