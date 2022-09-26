CREATE TABLE EXCHANGE_RATE
(
    ID               bigint generated by default as identity primary key,
    RATE_DATE        timestamp,
    RATE_VALUE       float,
    CURRENCY_PAIR_ID integer references CURRENCY_PAIR (ID)
);