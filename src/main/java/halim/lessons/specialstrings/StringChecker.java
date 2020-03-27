/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package halim.lessons.specialstrings;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

/**
 *
 * @author AbdElHalim
 */
public class StringChecker {

    public static void main(String[] args) {

        long result = substrCount(7, "abcbaba");
        System.out.println(result);
    }

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {

        List<Pair> list = new ArrayList<>();
        char c = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if (c == c1) {
                count++;
            } else {
                list.add(new Pair(c, count));
                c = c1;
                count = 1;
            }
        }
        list.add(new Pair(c, count));
        if (list.size() == 1) {
            return sumNaturalNumbers(list.get(0).getValue());
        }
        long total = sumNaturalNumbers(list.get(0).getValue())
                + sumNaturalNumbers(list.get(list.size() - 1).getValue());

        for (int i = 1; i < list.size() - 1; i++) {
            total += sumNaturalNumbers(list.get(i).getValue());
            // case 2
            if ((int) list.get(i).getValue() == 1 && list.get(i - 1).getKey() == list.get(i + 1).getKey()) {
                total += Math.min((int) list.get(i - 1).getValue(), (int) list.get(i + 1).getValue());
            }
        }
        return total;
    }

    private static long sumNaturalNumbers(Object n) {
        return ((int) n * ((int) n + 1)) / 2;
    }
}
