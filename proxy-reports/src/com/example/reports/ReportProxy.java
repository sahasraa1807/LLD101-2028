package com.example.reports;

/**
 * Proxy class:
 * - checks access
 * - lazy loads the real report
 * - caches the real report instance
 */
public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;

    private RealReport realReport; // cached real object

    private final AccessControl accessControl = new AccessControl();

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    @Override
    public void display(User user) {

        System.out.println("[proxy] checking access for " + user.getName());

        if (!accessControl.canAccess(user, classification)) {
            System.out.println("ACCESS DENIED for user " + user.getName());
            return;
        }

        System.out.println("ACCESS GRANTED");

        // Lazy loading
        if (realReport == null) {
            System.out.println("[proxy] creating real report...");
            realReport = new RealReport(reportId, title, classification);
        } else {
            System.out.println("[proxy] using cached report...");
        }

        realReport.display(user);
    }
}