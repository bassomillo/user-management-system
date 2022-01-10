package com.bassomillo.service;

import com.bassomillo.dao.DeptDao;
import com.bassomillo.entity.Dept;

import java.util.List;

public class DeptService {
    DeptDao deptDao = new DeptDao();
    public List<Dept> getAllDept() {
        return deptDao.getAllDept();
    }
}
