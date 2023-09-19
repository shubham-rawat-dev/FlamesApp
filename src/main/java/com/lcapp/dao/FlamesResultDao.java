package com.lcapp.dao;

import java.util.List;

import com.lcapp.dto.FlamesAppHistory;

public interface FlamesResultDao {
public void insert(FlamesAppHistory obj);
public List<FlamesAppHistory> getAppHistory();
}
