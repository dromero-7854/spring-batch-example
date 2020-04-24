package com.example.demo.batch.row.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.domain.FTDepositRequest;

public class FTDReqRowMapper implements RowMapper<FTDepositRequest> {

	public FTDepositRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
		FTDepositRequest ftdReq = new FTDepositRequest();
		ftdReq.setId(rs.getInt("id"));
		ftdReq.setState(rs.getString("state"));
		ftdReq.setClientID(rs.getString("client_id"));
		ftdReq.setAccount(rs.getString("account"));
		ftdReq.setFundsRequested(rs.getBoolean("funds_requested"));
		ftdReq.setFundsRequested(rs.getBoolean("funds_loaded"));
		ftdReq.setLastActivity(rs.getString("last_activity"));
		return ftdReq;
	}

}
