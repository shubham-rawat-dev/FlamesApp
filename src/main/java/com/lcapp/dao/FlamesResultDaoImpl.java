package com.lcapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.lcapp.dto.FlamesAppHistory;
import com.lcapp.dto.UserRegistrationDto;
@Repository
public class FlamesResultDaoImpl implements FlamesResultDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	BCryptPasswordEncoder bcrypt;
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
	@Override
	public void insertUserName(UserRegistrationDto obj) {
		System.out.println(obj.getPassword());
		System.out.println(bcrypt.encode(obj.getPassword()));
		String query1="insert into users(username,password,enabled)values (?,?,?)";
		jdbcTemplate.update(query1,obj.getUsername(),bcrypt.encode(obj.getPassword()),obj.isEnabled());
		String query2="insert into authorities(username,authority)values (?,?)";
		jdbcTemplate.update(query2,obj.getUsername(),"USER");
	}

}
