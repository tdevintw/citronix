package dev.yassiraitelghari.citronix.utils;
import dev.yassiraitelghari.citronix.domain.enums.Season ;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GetSeason {
    public static Season season(LocalDateTime date){
        int month = date.getMonthValue();

        if (month >= 3 && month <= 5) {
            return Season.SPRING;
        } else if (month >= 6 && month <= 8) {
            return Season.SUMMER;
        } else if (month >= 9 && month <= 11) {
            return Season.FALL;
        } else {
            return Season.WINTER;
        }
    }
}
