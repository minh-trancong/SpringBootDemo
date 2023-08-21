-- Insert 5 records into the coin_detail table
INSERT INTO coin_detail (symbol, base_asset, quote_asset, price_change_percent, volume, quote_volume)
VALUES
    ('BTC', 'BTC', 'USD', 0.5, 1000, 50000),
    ('ETH', 'ETH', 'USD', 0.3, 2000, 60000),
    ('LTC', 'LTC', 'USD', -0.2, 1500, 45000),
    ('XRP', 'XRP', 'USD', -0.1, 1200, 48000),
    ('BCH', 'BCH', 'USD', 0.4, 1800, 54000);

-- Insert 5 records into the default_list table
INSERT INTO default_list (name, placeholder)
VALUES
    ('TOP_COIN_1', 'Top coin 1'),
    ('TOP_COIN_2', 'Top coin 2'),
    ('TOP_COIN_3', 'Top coin 3'),
    ('TOP_COIN_4', 'Top coin 4'),
    ('TOP_COIN_5', 'Top coin 5');

-- Insert 5 records into the coin_detail_default_list_mapping table
INSERT INTO coin_detail_default_list_mapping (default_list_id, symbol)
VALUES
    (1, 'BTC'),
    (3, 'ETH'),
    (2, 'LTC'),
    (2, 'XRP'),
    (1, 'BCH');