--
-- create tables
--
CREATE TABLE ACCOUNT (
    account_id BIGSERIAL NOT NULL,
    username CHARACTER VARYING(255) NOT NULL,
    password CHARACTER VARYING(255) NOT NULL,
    PRIMARY KEY (account_id)
);

CREATE TABLE ACCOUNT_ROLE (
    account_id BIGINT NOT NULL,
    account_role CHARACTER VARYING(255) NOT NULL,
    PRIMARY KEY (account_id, account_role),
    FOREIGN KEY (account_id) REFERENCES ACCOUNT (account_id) ON DELETE CASCADE
);
