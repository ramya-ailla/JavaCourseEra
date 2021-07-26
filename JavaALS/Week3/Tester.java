package Week3;
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer ob = new LogAnalyzer();
        ob.readFile("src/Week3/short-test_log");
        ob.printAll();
    }

    public void testUniqueIP(){
        LogAnalyzer ob = new LogAnalyzer();
        ob.readFile("src/Week3/short-test_log");
        System.out.println("number of unique IP addresses = "+ob.countUniqueIPs());
    }

    public void testPrintAllHigherThanNum(){
        LogAnalyzer ob = new LogAnalyzer();
        ob.readFile("src/Week3/weblog1_log");
        ob.printAllHigherThanNum(400);
    }

    public void testUniqueIPVisitsOnDay(){
        LogAnalyzer ob = new LogAnalyzer();
        ob.readFile("src/Week3/weblog1_log");
        ArrayList<String> uniqueIPs = ob.uniqueIPVisitsOnDay("Mar 17");
        System.out.println("number of visitors on Mar 17 - "+uniqueIPs.size());
        //ob.uniqueIPVisitsOnDay("Sep 14");
    }

    public void countUniqueIPsInRange(){
        LogAnalyzer ob = new LogAnalyzer();
        ob.readFile("src/Week3/weblog1_log");
        System.out.println("Unique IPs in range of status 300 1nd 399 "+ ob.countUniqueIPsInRange(399,300));
    }

    public void testCountVisitsPerIP(){
        LogAnalyzer ob = new LogAnalyzer();
        ob.readFile("src/Week3/short-test_log");
        System.out.println("COUNT VISITS PER IP "+ ob.countVisitsPerIP());
    }

    public void testMostNumberVisitsByIP(){
        LogAnalyzer o = new LogAnalyzer();
        o.readFile("src/Week3/weblog1_log");
        HashMap<String,Integer> countIPs = o.countVisitsPerIP();
        int maxVisits = o.mostNumberVisitsByIP(countIPs);
        System.out.println(maxVisits);
    }
    public void testIPsMostVisits() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("src/Week3/weblog1_log");
        HashMap<String, Integer> ipCounts = la.countVisitsPerIP();
        ArrayList<String> ipList = la.iPsMostVisits(ipCounts);
        System.out.println("Ips with most visits = " + ipList);
    }

    public void testIPsForDays() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("src/Week3/weblog1_log");
        HashMap<String, ArrayList<String>> ipsPerDay = la.iPsForDays();
        System.out.println("Ips per day = " + ipsPerDay);

    }

    public void testDayWithMostIPVisits() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("src/Week3/weblog1_log");
        HashMap<String, ArrayList<String>> ipsPerDay = la.iPsForDays();
        String day = la.dayWithMostIPVisits(ipsPerDay);
        System.out.println("Day with most ip visit = " + day);
    }

    public void testIPsWithMostVisitsOnDay() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("src/Week3/weblog1_log");
        HashMap<String, ArrayList<String>> ipsPerDay = la.iPsForDays();
        ArrayList<String> ipList = la.iPsWithMostVisitsOnDay(ipsPerDay, "Mar 17");
        System.out.println("IP with most visits on Mar 17 = " + ipList);
    }
    public static void main(String[] args) {
        Tester o = new Tester();
        //o.testLogAnalyzer();
        //o.testUniqueIP();
        //o.testPrintAllHigherThanNum();
        //o.testUniqueIPVisitsOnDay();
        //o.countUniqueIPsInRange();
        //o.testCountVisitsPerIP();
        //o.testMostNumberVisitsByIP();
        //o.testIPsMostVisits();
        //o.testIPsForDays();
       // o.testDayWithMostIPVisits();
        o.testIPsWithMostVisitsOnDay();
    }
}
