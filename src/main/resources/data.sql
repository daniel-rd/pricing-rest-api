insert into PRODUCTS VALUES (35455,'Pantalón');
insert into BRANDS VALUES (1, 'ZARA');
insert into BRANDS VALUES (2, 'PULL&BEAR');
insert into prices (id, start_date, end_date, price, curr, priority, brand_id, product_id)
values (1, {ts '2020-06-14T00.00.00Z'}, {ts '2020-12-31T23.59.59Z'}, '35.50','EUR', 0,  1, 35455);
insert into prices (id, start_date, end_date, price, curr, priority, brand_id, product_id)
values (2, {ts '2020-06-14T15.00.00Z'}, {ts '2020-06-14T18.30.00Z'}, '25.45','EUR', 1,  1, 35455);
insert into prices (id, start_date, end_date, price, curr, priority, brand_id, product_id)
values (3, {ts '2020-06-15T00.00.00Z'}, {ts '2020-06-15T11.00.00Z'}, '30.50','EUR', 1,  1, 35455);
insert into prices (id, start_date, end_date, price, curr, priority, brand_id, product_id)
values (4, {ts '2020-06-15T16.00.00Z'}, {ts '2020-12-31T23.59.59Z'}, '38.95','EUR', 1,  1, 35455);