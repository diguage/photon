package com.diguage.photon.dao;

import com.diguage.photon.domain.Employee;
import com.ibatis.sqlmap.client.SqlMapExecutor;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.util.CollectionUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDao extends SqlMapClientTemplate {
    /**
     * 在 HikariCP 下，批量插入报错
     */
    public boolean insertBatch(final List<Employee> employeeList) {
        try {
            logger.debug("start to save data");
            // 执行回调
            return this.execute(new SqlMapClientCallback<Boolean>() {
                // 实现回调接口
                @Override
                public Boolean doInSqlMapClient(SqlMapExecutor executor)
                        throws SQLException {
                    // 开始批处理
                    executor.startBatch();
                    for (Employee ele : employeeList) {
                        // 插入操作
                        executor.insert("Employee.save", ele);
                    }
                    // 执行批处理
                    int count = executor.executeBatch();
                    logger.info("return count=" + count + ", param list size="
                            + employeeList.size() + ", result=" + (count == employeeList.size()));
                    return count == employeeList.size();
                }
            });
        } catch (Exception e) {
            logger.error("Employee insertBatch error", e);
            throw e;
        }
    }

    public Employee get(long id) {
        return (Employee) queryForObject("Employee.get", id);
    }

    public List<Employee> find(Map<String, Object> params, int start, int limit) {
        Map<String, Object> queryParams = new HashMap<String, Object>(params);
        queryParams.put("rowStart", start);
        queryParams.put("rowEnd", start + limit);
        return (List<Employee>) queryForList("Employee.find", queryParams);
    }

    /**
     * 批量更新没有报错
     */
    public boolean updateBatch(List<Employee> employeeList) {
        try {
            if (CollectionUtils.isEmpty(employeeList)) {
                logger.info("update list is empty.");
                return false;
            }
            logger.debug("start to save data");
            // 执行回调
            return this.execute(new SqlMapClientCallback<Boolean>() {
                // 实现回调接口
                @Override
                public Boolean doInSqlMapClient(SqlMapExecutor executor)
                        throws SQLException {
                    // 开始批处理
                    executor.startBatch();
                    for (Employee ele : employeeList) {
                        // 插入操作
                        executor.update("Employee.update", ele);
                    }
                    // 执行批处理
                    int count = executor.executeBatch();
                    logger.info("return count=" + count + ", param list size="
                            + employeeList.size() + ", result=" + (count == employeeList.size()));
                    return count == employeeList.size();
                }
            });
        } catch (Exception e) {
            logger.error("Employee updateBatch error", e);
            throw e;
        }
    }
}
