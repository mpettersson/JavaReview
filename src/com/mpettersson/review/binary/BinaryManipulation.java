package com.mpettersson.review.binary;

public class BinaryManipulation {

    public static int getBit(int num, int i){
        return (num & (1 << i)) != 0 ? 1 : 0;
    }

    public static int setBitToOne(int num, int i){
        return (num | (1 << i));
    }

    public static int setBitToZero(int num, int i){
        return (num | ~(1 << i));
    }

    public static int setIthToMostSigBitZero(int num, int i){
        return (num & ((1 << i) - 1));
    }

    public static int setIthToLeastSigBitZero(int num, int i){
        return num & ~(-1 >>> (31 - i));
    }

    public static int setIthBit(int num, int i, int value) throws Exception{
        if (value < 0 || value > 1){
            throw new Exception();
        }
        return (num & ~(1 << i)) | (value << i);
    }

    public static String intToBinaryString(int num){
        String binaryString = "";
        for(int i = 32; i >= 0; i--){
            int w = (int)Math.pow(2, i) / num;
            int r = (int)Math.pow(2, i) % num;
            if(w > 0){
                num = r;
                binaryString = binaryString + "1";
            }else{
                binaryString = binaryString + "0";
            }
        }
        return binaryString;
    }

    static String decToBinary(int n) {
        String binaryNum = "";

        while (n > 0) {
            System.out.println("n: " + n);
            binaryNum = (n % 2) + binaryNum;
            System.out.println("binaryNum: " + binaryNum);
            n = n / 2;
            System.out.println("n: " + n);
        }
        return binaryNum;
    }


    public static int stringToDec(String str){
        int n = 0;
        int exp = 0;
        for(int i = str.length() - 1; i >= 0; i--){
            n += (Math.pow(2, exp) * Integer.parseInt(""+ str.charAt(i)));
            exp++;
        }
        return n;
    }

    public static int insertQuestion(int n, int m, int j, int i){
        int onesMask = ((int) Math.pow(2, j - i + 1) - 1 ) << i;
        return (n & ~onesMask) | (m << i);
    }

    public static String printBinary(double num){
        if(num >=1 || num <= 0){
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while(num > 0){
            // Setting a limit on length: 32 characters
            if(binary.length() >= 32){
                return "ERROR";
            }
            double r = num * 2;
            if(r >= 1){
                binary.append(1);
                num = r - 1;
            }else {
                binary.append(0);
                num = r;
            }
            System.out.println("num: " + num);
            System.out.println(binary.toString());
        }
        return binary.toString();
    }

    public static String printBinary2(double num){
        if(num >=1 || num <= 0){
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        double frac = .5;
        while(num > 0){
            // Setting a limit on length: 32 characters
            if(binary.length() >= 32){
                return "ERROR";
            }
            if(num >= frac){
                binary.append(1);
                num -= frac;
            }else {
                binary.append(0);
            }
            frac /= 2;
            System.out.println("num: " + num);
            System.out.println(binary.toString());
        }
        return binary.toString();
    }


    public static void main(String[] args) {

        double num = .25;
        System.out.println(printBinary(num));
        System.out.println("--------------------------------");
        System.out.println(printBinary(num));

        System.exit(0);

        System.out.println(decToBinary(0b11110000));

        System.out.println(Integer.toBinaryString(stringToDec("11110000")));
//        System.out.println(intToBinaryString(0b10010));

        int answer = insertQuestion(0b10000000000, 0b10011, 6, 2);
        System.out.println(Integer.toBinaryString(answer));

        System.out.println(Integer.toBinaryString(setIthToMostSigBitZero(0b101010, 3)));
    }
}
