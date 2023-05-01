package com.threatre.customer.records;

public record Show(String movieId, Integer theatreId, String showStartTime, String showEndtime, String dayPart, Double price) {

}
