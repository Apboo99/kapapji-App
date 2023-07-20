//package com.example.kababjipalace;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class SearchProcess {
//    public static void main(String[] args){
//        List<String> items = new ArrayList<>();
//        items.add("item1");
//        items.add("item2");
//        items.add("item3");
//        items.add("item4");
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter search term: ");
//        String searchTerm = scanner.nextLine();
//
//        List<String> results = new ArrayList<>();
//        for (String item : items) {
//            if (item.contains(searchTerm)) {
//                results.add(item);
//            }
//        }
//
//        if (results.isEmpty()) {
//            System.out.println("No results found.");
//        } else {
//            System.out.println("Results:");
//            for (String result : results) {
//                System.out.println(result);
//            }
//        }
//    }
//}
