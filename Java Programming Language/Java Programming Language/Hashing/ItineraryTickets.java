package Hashing;

import java.util.HashMap;

public class ItineraryTickets {

    public static void main(String[] args) {

        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Bengaluru", "Mumbai");

        String start = getStart(tickets);

        while (tickets.containsKey(start)) {
            System.out.print(start + " -> ");
            start = tickets.get(start);
        }

        System.out.println(start);
    }

    static String getStart(HashMap<String, String> tickets) {

        HashMap<String, String> revMap = new HashMap<>();

        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }

        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }

        return null;
    }
}
