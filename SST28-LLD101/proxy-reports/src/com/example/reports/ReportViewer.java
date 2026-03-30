package com.example.reports;

/**
 * Client class that opens reports.
 * Uses the Report abstraction.
 */
public class ReportViewer {

    public void open(Report report, User user) {
        System.out.println("Viewer opening report for " + user.getName());
        report.display(user);
    }
}