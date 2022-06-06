package com.diguage.photon.service;

import com.diguage.photon.dao.EmployeeDao;
import com.diguage.photon.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class EmployeeService {
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional
    public Employee get(long id) {
        return employeeDao.get(id);
    }

    @Transactional
    public List<Employee> find() {
        Map<String, Object> param = new HashMap<>();
        return employeeDao.find(param, 0, 20);
    }

    @Transactional(timeout = 2000000, rollbackFor = Exception.class)
    public boolean save(List<Employee> employeeList) {
        boolean result = employeeDao.insertBatch(employeeList);
        if (!result) {
            // 这里使用 Error 是防止被回滚
            throw new Error("返回值为 false");
        }
        log.info("insert success.");
        return result;
    }

    public int delete() {
        return employeeDao.delete("Employee.delete");
    }

    public Object update() {
        List<Employee> employeeList = find();
        for (Employee employee : employeeList) {
            employee.setHireDate(new Date());
        }

        boolean result = employeeDao.updateBatch(employeeList);
        if (!result) {
            // 这里使用 Error 是防止被回滚
            throw new Error("返回值为 false");
        }
        log.info("update success.");
        return result;
    }
}
