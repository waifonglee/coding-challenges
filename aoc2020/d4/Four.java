package aoc2020.d4;
import java.util.*;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors

public class Four {
    static List<String> passports = new ArrayList<>();
    static String optional = "cid";

/*
didn't do part 2 because too painful :D
If cm, the number must be at least 150 and at most 193.
If in, the number must be at least 59 and at most 76.
hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
pid (Passport ID) - a nine-digit number, including leading zeroes.
cid (Country ID) - ignored, missing or not.

    //byr (Birth Year) - four digits; at least 1920 and at most 2002.
    public static boolean checkbyr(String s) {
        int year = Integer.parseInt(s);
        if (year >= 1920 && year <= 2002) {
            return true;
        } else {
            return false;
        }
    }

    //iyr (Issue Year) - four digits; at least 2010 and at most 2020.
    public static boolean checkiyr(String s) {
        int year = Integer.parseInt(s);
        if (year >= 2010 && year <= 2020) {
            return true;
        } else {
            return false;
        }
    }

    //eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
    public static boolean checkeyr(String s) {
        int year = Integer.parseInt(s);
        if (year >= 2020 && year <= 2030) {
            return true;
        } else {
            return false;
        }
    }

    //hgt (Height) - a number followed by either cm or in:
    public static boolean checkheight(String s) {
        String num = s.substring(0, s.length() - 2);
        String m = s.substring(s.length() - 2);
    }
*/
    public static void scanLines() {
        try {
            File input = new File("four.txt");
            Scanner sc = new Scanner(input);
            StringBuilder build = new StringBuilder();
            while (sc.hasNextLine()) {
                String next = sc.nextLine();
                if (!next.equals("")) {
                    build.append(next);
                    build.append(" ");
                } else {
                    passports.add(build.toString());
                    build = new StringBuilder();
                }
            }
            passports.add(build.toString());
            sc.close();
          } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
          }
    }

    public static int op() {
        int valid = 0;

        for (String s:passports) {
            String[] s_arr = s.split(" ");
            //System.out.println(s_arr.length);
            if (s_arr.length < 7) {
                continue;
            }
            
            if (s_arr.length == 8) {
                valid ++;
            } else if (s_arr.length == 7) {
                for (int p = 0; p < 7; p ++) {
                    if (s_arr[p].substring(0, 3).equals(optional)) {
                        valid --;
                        break;
                    }
                }
                valid++;
            }
        }

        return valid;

    }

    public static void main(String[] args) {
        scanLines();
        int ans = op();
        System.out.println(ans);
        /*
        System.out.println(passports.get(0));
        String[] s = passports.get(0).split(" ");
        
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
        */
    }
}
