package com.lcapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lcapp.dto.FlamesAppHistory;

public class RowMapperImpl implements RowMapper<FlamesAppHistory> {

	@Override
	public FlamesAppHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
		FlamesAppHistory flamesAppHistory = new FlamesAppHistory();
		flamesAppHistory.setUserName(rs.getString(1));
		flamesAppHistory.setCrushName(rs.getString(2));
		flamesAppHistory.setAppResult(rs.getString(3));
		return flamesAppHistory;
	}

}
