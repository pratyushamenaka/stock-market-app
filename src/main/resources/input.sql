
INSERT INTO Stock_Type(stock_type_id, stock_type_name, stock_type_desc) VALUES(stock_type_primary_key_seq.nextval,'BTC','Bit Coin');
INSERT INTO Stock_Type(stock_type_id, stock_type_name, stock_type_desc) VALUES(stock_type_primary_key_seq.nextval,'ETC','Etherium Coin');
INSERT INTO Stock_Type(stock_type_id, stock_type_name, stock_type_desc) VALUES(stock_type_primary_key_seq.nextval,'LTC','Lithirium Coin');

--BTC
INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval,(SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'BTC'), 'BTC', '20180507', '0915', 34.98);
INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval, (SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'BTC'), 'BTC', '20180507', '1045', 36.13);
INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval, (SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'BTC'), 'BTC', '20180507', '1230', 37.01);
INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval, (SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'BTC'), 'BTC', '20180507', '1400', 35.98);
INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval, (SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'BTC'), 'BTC', '20180507', '1530', 33.56);

--ETC
INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval, (SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'ETC'), 'ETC', '20180507', '0900', 1.45);
INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval, (SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'ETC'), 'ETC', '20180507', '1030', 1.87);
INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval, (SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'ETC'), 'ETC', '20180507', '1245', 1.55);
INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval, (SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'ETC'), 'ETC', '20180507', '1515', 2.01);
INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval, (SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'ETC'), 'ETC', '20180507', '1700', 2.15);

--LTC
INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval, (SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'LTC'), 'LTC', '20180507', '0930', 14.32);
INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval, (SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'LTC'), 'LTC', '20180507', '1115', 14.87);
INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval, (SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'LTC'), 'LTC', '20180507', '1245', 15.03);
INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval, (SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'LTC'), 'LTC', '20180507', '1400', 14.76);
INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval, (SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'LTC'), 'LTC', '20180507', '1700', 14.15);


-- Added 20180508 date script to validate http://localhost:9090/stock-market/calculate-profit-for-day/20180508 call when date is passed as input parameter

/*INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval, (SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'BTC'), 'BTC', '20180508', '1220', 10.50);
INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval, (SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'BTC'), 'BTC', '20180508', '1115', 14.87);

INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval, (SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'LTC'), 'LTC', '20180508', '1115', 14.87);
INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval, (SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'LTC'), 'LTC', '20180508', '0600', 05.10);


INSERT INTO Stock_Information(stock_id, stock_type_id, currency, stock_date, stock_time, stock_price)
VALUES(stock_primary_key_seq.nextval, (SELECT stock_type_id FROM stock_type WHERE stock_type_name = 'ETC'), 'ETC', '20180508', '0915', 11.47);

*/
COMMIT