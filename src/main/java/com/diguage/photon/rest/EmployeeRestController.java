package com.diguage.photon.rest;

import com.diguage.photon.domain.Employee;
import com.diguage.photon.service.EmployeeService;
import com.diguage.photon.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id:\\d+}")
    public Object get(@PathVariable Long id) {
        return employeeService.get(id);
    }

    @GetMapping("/list")
    public Object find() {
        return employeeService.find();
    }

    @GetMapping("/save")
    public Object save() {
        String data = "[{\"empNo\":119010001,\"birthDate\":\"1953-09-01 16:00:00.000\",\"firstName\":\"Georgi\",\"lastName\":\"Facello\",\"hireDate\":\"1986-06-25 15:00:00.000\",\"gender\":\"M\"},\n" +
                " {\"empNo\":119010002,\"birthDate\":\"1964-06-01 16:00:00.000\",\"firstName\":\"Bezalel\",\"lastName\":\"Simmel\",\"hireDate\":\"1985-11-20 16:00:00.000\",\"gender\":\"F\"},\n" +
                " {\"empNo\":119010003,\"birthDate\":\"1959-12-02 16:00:00.000\",\"firstName\":\"Parto\",\"lastName\":\"Bamford\",\"hireDate\":\"1986-08-27 15:00:00.000\",\"gender\":\"M\"},\n" +
                " {\"empNo\":119010004,\"birthDate\":\"1954-04-30 16:00:00.000\",\"firstName\":\"Chirstian\",\"lastName\":\"Koblick\",\"hireDate\":\"1986-11-30 16:00:00.000\",\"gender\":\"M\"},\n" +
                " {\"empNo\":119010005,\"birthDate\":\"1955-01-20 16:00:00.000\",\"firstName\":\"Kyoichi\",\"lastName\":\"Maliniak\",\"hireDate\":\"1989-09-11 15:00:00.000\",\"gender\":\"M\"},\n" +
                " {\"empNo\":119010006,\"birthDate\":\"1953-04-19 16:00:00.000\",\"firstName\":\"Anneke\",\"lastName\":\"Preusig\",\"hireDate\":\"1989-06-01 15:00:00.000\",\"gender\":\"F\"},\n" +
                " {\"empNo\":119010007,\"birthDate\":\"1957-05-22 16:00:00.000\",\"firstName\":\"Tzvetan\",\"lastName\":\"Zielinski\",\"hireDate\":\"1989-02-09 16:00:00.000\",\"gender\":\"F\"},\n" +
                " {\"empNo\":119010008,\"birthDate\":\"1958-02-18 16:00:00.000\",\"firstName\":\"Saniya\",\"lastName\":\"Kalloufi\",\"hireDate\":\"1994-09-14 16:00:00.000\",\"gender\":\"M\"},\n" +
                " {\"empNo\":119010009,\"birthDate\":\"1952-04-18 16:00:00.000\",\"firstName\":\"Sumant\",\"lastName\":\"Peac\",\"hireDate\":\"1985-02-17 16:00:00.000\",\"gender\":\"F\"},\n" +
                " {\"empNo\":119010010,\"birthDate\":\"1963-05-31 16:00:00.000\",\"firstName\":\"Duangkaew\",\"lastName\":\"Piveteau\",\"hireDate\":\"1989-08-23 15:00:00.000\",\"gender\":\"F\"},\n" +
                " {\"empNo\":119010011,\"birthDate\":\"1953-11-06 16:00:00.000\",\"firstName\":\"Mary\",\"lastName\":\"Sluis\",\"hireDate\":\"1990-01-21 16:00:00.000\",\"gender\":\"F\"},\n" +
                " {\"empNo\":119010012,\"birthDate\":\"1960-10-03 16:00:00.000\",\"firstName\":\"Patricio\",\"lastName\":\"Bridgland\",\"hireDate\":\"1992-12-17 16:00:00.000\",\"gender\":\"M\"},\n" +
                " {\"empNo\":119010013,\"birthDate\":\"1963-06-06 16:00:00.000\",\"firstName\":\"Eberhardt\",\"lastName\":\"Terkki\",\"hireDate\":\"1985-10-19 16:00:00.000\",\"gender\":\"M\"},\n" +
                " {\"empNo\":119010014,\"birthDate\":\"1956-02-11 16:00:00.000\",\"firstName\":\"Berni\",\"lastName\":\"Genin\",\"hireDate\":\"1987-03-10 16:00:00.000\",\"gender\":\"M\"},\n" +
                " {\"empNo\":119010015,\"birthDate\":\"1959-08-18 16:00:00.000\",\"firstName\":\"Guoxiang\",\"lastName\":\"Nooteboom\",\"hireDate\":\"1987-07-01 15:00:00.000\",\"gender\":\"M\"},\n" +
                " {\"empNo\":119010016,\"birthDate\":\"1961-05-01 16:00:00.000\",\"firstName\":\"Kazuhito\",\"lastName\":\"Cappelletti\",\"hireDate\":\"1995-01-26 16:00:00.000\",\"gender\":\"M\"},\n" +
                " {\"empNo\":119010017,\"birthDate\":\"1958-07-05 16:00:00.000\",\"firstName\":\"Cristinel\",\"lastName\":\"Bouloucos\",\"hireDate\":\"1993-08-02 16:00:00.000\",\"gender\":\"F\"},\n" +
                " {\"empNo\":119010018,\"birthDate\":\"1954-06-18 16:00:00.000\",\"firstName\":\"Kazuhide\",\"lastName\":\"Peha\",\"hireDate\":\"1987-04-02 16:00:00.000\",\"gender\":\"F\"},\n" +
                " {\"empNo\":119010019,\"birthDate\":\"1953-01-22 16:00:00.000\",\"firstName\":\"Lillian\",\"lastName\":\"Haddadi\",\"hireDate\":\"1999-04-29 16:00:00.000\",\"gender\":\"M\"},\n" +
                " {\"empNo\":119010020,\"birthDate\":\"1952-12-23 16:00:00.000\",\"firstName\":\"Mayuko\",\"lastName\":\"Warwick\",\"hireDate\":\"1991-01-25 16:00:00.000\",\"gender\":\"M\"}]\n";
        List<Employee> employeeList = JsonUtil.fromJson(data,
                JsonUtil.buildCollectionType(ArrayList.class, Employee.class));
        return employeeService.save(employeeList);
    }

    @GetMapping("/update")
    public Object update() {
        return employeeService.update();
    }

    @GetMapping("/delete")
    public Object delete() {
        return employeeService.delete();
    }
}
