
DROP TABLE IF EXISTS cmf_ftd_request;

CREATE TABLE cmf_ftd_request (
  id INT AUTO_INCREMENT PRIMARY KEY,
  state VARCHAR(250) NOT NULL,
  client_id VARCHAR(250) NULL,
  account VARCHAR(250) NULL,
  funds_requested BOOLEAN NULL,
  funds_loaded BOOLEAN NULL,
  last_activity VARCHAR(250) NULL
);

INSERT INTO cmf_ftd_request(state, client_id, account, funds_requested, funds_loaded) VALUES
  ('INITIAL', '', '', false, false);

