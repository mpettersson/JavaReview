package com.mpettersson.questions.strings;

import java.util.*;

/**
 *     ENGLISH INT
 *
 *     Given any integer, print an English phrase that describes the integer
 *     (e.g., "One Thousand, Two Hundred Thirty Four").
 *
 *     The key here is to be organized and have good test cases.
 */
public class EnglishInt {
    String[] smalls = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] bigs = {"", "Thousand", "million", "Billion", "Trillion", "Quadrillion", "Quintillion", "Sextillion"};
    String hundred = "Hundred";
    String negative = "Negative";

    String convert (int num){
        if(num == 0){
            return smalls[0];
        }else if(num < 0 && num > -2_147_483_647){
            return (negative + " " + convert(Math.abs(num)));
        }

        LinkedList<String> parts = new LinkedList<>();
        int chunkCount = 0;

        while(num > 0){
            if(num % 1000 != 0){
                String chunk = convertChunk(num % 1000) + " " + bigs[chunkCount];
                parts.addFirst(chunk);
            }
            num /= 1000;  // Shift chunk
            chunkCount++;
        }

        return listToString(parts);
    }

    String convertChunk(int number){
        LinkedList<String> parts = new LinkedList<>();

        // Convert hundres place
        if(number >= 100){
            parts.addLast(smalls[number / 100]);
            parts.addLast(hundred);
            number %= 100;
        }

        // Convert tens place
        if(number >= 10 && number <= 19){
            parts.addLast(smalls[number]);
        }else if(number >= 20){
            parts.addLast(tens[number / 10]);
            number %= 10;
        }

        // Convert ones place
        if(number >= 1 && number <= 9){
            parts.addLast(smalls[number]);
        }

        return listToString(parts);
    }

    // Convert list of strings to a String, dividing it up with spaces.
    String listToString(LinkedList<String> parts){
        StringBuilder sb = new StringBuilder();
        while(parts.size() > 1){
            sb.append(parts.pop());
            sb.append(" ");
        }
        sb.append(parts.pop());
        return sb.toString();
    }


    public static void main(String[] args) {
        EnglishInt englishIntConverter = new EnglishInt();


        // The following case fails...
//        System.out.println("englishIntConverter.convert(-2_147_483_648): " + englishIntConverter.convert(-2_147_483_648));

        System.out.println("englishIntConverter.convert(-2_000_999_648): " + englishIntConverter.convert(-2_000_999_648));
        System.out.println("englishIntConverter.convert(-2_000_000_000): " + englishIntConverter.convert(-2_000_000_000));
        System.out.println("englishIntConverter.convert(-1202300): " + englishIntConverter.convert(-1202300));
        System.out.println("englishIntConverter.convert(-1): " + englishIntConverter.convert(-1));
        System.out.println("englishIntConverter.convert(-0): " + englishIntConverter.convert(-0));
        System.out.println("englishIntConverter.convert(1): " + englishIntConverter.convert(1));
        System.out.println("englishIntConverter.convert(1202300): " + englishIntConverter.convert(1202300));
        System.out.println("englishIntConverter.convert(10204987): " + englishIntConverter.convert(10204987));
        System.out.println("englishIntConverter.convert(2_000_000_000): " + englishIntConverter.convert(2_000_000_000));
        System.out.println("englishIntConverter.convert(2_000_999_648): " + englishIntConverter.convert(2_000_999_648));
        System.out.println("englishIntConverter.convert(2_147_483_647): " + englishIntConverter.convert(2_147_483_647));
    }
}
