package com.lcapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lcapp.dto.FlamesAppHistory;
@Repository
public class FlamesResultDaoImpl implements FlamesResultDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public void insert(FlamesAppHistory flamesObject) {
		String query="insert into flames(userName,crushName,result) values (?,?,?) ";
		
		jdbcTemplate.update(query,flamesObject.getUserName(),flamesObject.getCrushName(),flamesObject.getAppResult());
		System.out.println("inserted");
	}
	@Override
	public List<FlamesAppHistory> getAppHistory() {
		
		String query="select * from flames";
		List<FlamesAppHistory> appHistory = jdbcTemplate.query(query,new RowMapperImpl());
		return appHistory;
	}

}
