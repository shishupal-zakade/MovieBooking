package com.threatre.booking.records;

public record Show(String movieId, Integer theatreId, String showStartTime, String showEndtime, String dayPart, Double price) {

}
