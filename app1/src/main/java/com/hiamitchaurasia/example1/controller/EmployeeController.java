package com.hiamitchaurasia.example1.controller;

import jakarta.servlet.http.HttpServletResponse;
import com.hiamitchaurasia.example1.service.CsvExportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class EmployeeController {

    private final CsvExportService csvExportService;

    public EmployeeController(CsvExportService csvExportService) {
        this.csvExportService = csvExportService;
    }

    @RequestMapping(path = "/employees")
    public void getAllEmployeesInCsv(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"employees.csv\"");
        csvExportService.writeEmployeesToCsv(servletResponse.getWriter());
    }

}
