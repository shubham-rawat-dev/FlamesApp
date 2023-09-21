package com.lcapp.dao;

import java.util.List;

import com.lcapp.dto.FlamesAppHistory;
import com.lcapp.dto.UserRegistrationDto;

public interface FlamesResultDao {
public void insert(FlamesAppHistory obj);
public List<FlamesAppHistory> getAppHistory();
public void insertUserName(UserRegistrationDto obj);
}
