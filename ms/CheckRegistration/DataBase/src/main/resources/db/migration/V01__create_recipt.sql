CREATE TABLE receipt
(
    id              serial primary key,
    qr_string       varchar(100) unique         not null,
    time            timestamp without time zone not null,
    sum             int                         not null,
    fiscal_number   bigint                      not null,
    fiscal_document bigint                      not null,
    fiscal_feature  bigint                      not null,
    type            smallint                    not null,
    create_at       timestamp with time zone    not null
)