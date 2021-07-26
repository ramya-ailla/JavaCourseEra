package Week3;
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr = new FileResource(filename);
         for(String line: fr.lines()){

             LogEntry le = WebLogParser.parseEntry(line);
             records.add(le);
         }
     }
     public int countUniqueIPs(){
         ArrayList<String> uniqueIPs = new ArrayList<>();
         for(LogEntry record:records){
             if(!uniqueIPs.contains(record.getIpAddress())){
                 uniqueIPs.add(record.getIpAddress());
             }
         }
         return uniqueIPs.size();
     }
     public void printAllHigherThanNum(int num){
         for(LogEntry entry:records){
             int entryStatus = entry.getStatusCode();
             if(entryStatus > num){
                 System.out.println(entry);
             }
         }
     }
     public ArrayList<String> uniqueIPVisitsOnDay(String someDay){
         ArrayList <String> uniqueIPsInADay = new ArrayList<>();
         for(LogEntry entry:records){
             String visitDay = entry.getAccessTime().toString();

             if(visitDay.contains(someDay)){
                 if(!uniqueIPsInADay.contains(entry.getIpAddress())){
                     uniqueIPsInADay.add(entry.getIpAddress());
                 }
             }
         }
         return uniqueIPsInADay;
     }
     public int countUniqueIPsInRange(int high,int low){
         ArrayList<String> uniqueIPs = new ArrayList<>();
         for(LogEntry entry:records){
             int currStatusCode = entry.getStatusCode();
             if(currStatusCode >= low && currStatusCode <= high){
                 if(!uniqueIPs.contains(entry.getIpAddress())){
                     uniqueIPs.add(entry.getIpAddress());
                 }
             }
         }
         return uniqueIPs.size();
     }

    public HashMap<String, Integer> countVisitsPerIP(){
         HashMap<String,Integer> counts = new HashMap<>();
         for(LogEntry entry:records){
             String currIP = entry.getIpAddress();
             if(counts.containsKey(currIP)){
                 int freq = counts.get(currIP);
                 counts.replace(currIP,freq+1);
             }
             else{
                 counts.put(currIP,1);
                 }
         }
         return counts;
    }
    public int mostNumberVisitsByIP(HashMap<String,Integer> countIPs){
         int maxVisits = 0;
         int currVisits =0;
         for(String IPAddr:countIPs.keySet()){
             currVisits = countIPs.get(IPAddr);
             if(currVisits>maxVisits){
                 maxVisits = currVisits;
             }
         }
         return maxVisits;
    }

    public ArrayList<String> iPsMostVisits(HashMap<String,Integer> countIPs){
         int maxVisits = mostNumberVisitsByIP(countIPs);
         ArrayList<String> mostVisitedIPs = new ArrayList<>();
         int currVisits = 0;
         for(String ipAdd:countIPs.keySet()){
             currVisits = countIPs.get(ipAdd);
             if(currVisits == maxVisits){
                 mostVisitedIPs.add(ipAdd);
             }
         }
         return mostVisitedIPs;
    }

    public HashMap<String,ArrayList<String>> iPsForDays(){
        HashMap<String,ArrayList<String>> result = new HashMap<>();
        for(LogEntry rec:records){
            String date = rec.getAccessTime().toString().substring(4,10);
            String ipAddress = rec.getIpAddress();
            ArrayList<String> ips;
            if(!result.containsKey(date)){
                ips= new ArrayList<>();
            }
            else{
                ips=result.get(date);
                }
            ips.add(ipAddress);
            result.put(date,ips);
        }
        return result;
    }

    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> ipsPerDay) {
        String day = "";
        int maxVisit = Integer.MIN_VALUE;

        for (String key : ipsPerDay.keySet()) {
            int currentVisit = ipsPerDay.get(key).size();

            if (currentVisit > maxVisit) {
                maxVisit = currentVisit;
                day = key;
            }
        }

        return day;
    }
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> ipsPerDay, String day) {
        ArrayList<String> ipList = ipsPerDay.get(day);
        HashMap<String, Integer> ipCounts = new HashMap<String, Integer>();

        for (String ip : ipList) {
            if (!ipCounts.containsKey(ip)) {
                ipCounts.put(ip, 1);
            } else {
                ipCounts.put(ip, ipCounts.get(ip) + 1);
            }
        }

        return iPsMostVisits(ipCounts);
    }

    public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
