/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author PC_HONGQUAN
 */
public class Util {

    public static String getDateNow() {
        LocalDate today = LocalDate.now(); // Lấy ngày hôm nay
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy"); // Định dạng ngày tháng năm
        String formattedDate = today.format(formatter); // Định dạng ngày tháng năm theo định dạng đã cho
        return formattedDate;
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(regex);
    }

    public static boolean isNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isNumber("10"));
    }

    public boolean isEmail(String input) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return input.matches(regex);
    }
}
