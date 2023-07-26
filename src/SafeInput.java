import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print("\n" + prompt + ": "); // show prompt add space

            retString = pipe.nextLine();

        } while (retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                int toReturn = pipe.nextInt();
                if (pipe.hasNextLine())
                    pipe.nextLine();
                return toReturn;
            }
        } while (true);

    }

    public static double getDouble(Scanner pipe, String prompt) {

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                double toReturn = pipe.nextDouble();
                if (pipe.hasNextLine())
                    pipe.nextLine();
                return toReturn;
            }
        } while (true);

    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "] " + ": ");
            if (pipe.hasNextInt()) {
                int toReturn = pipe.nextInt();
                if (pipe.hasNextLine())
                    pipe.nextLine();
                if (toReturn >= low && toReturn <= high)
                    return toReturn;
            }
        } while (true);
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "] " + ": ");
            if (pipe.hasNextDouble()) {
                double toReturn = pipe.nextDouble();
                if (pipe.hasNextLine())
                    pipe.nextLine();
                if (toReturn >= low && toReturn <= high)
                    return toReturn;
            }
        } while (true);
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String retString = "";
        do
        {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            if (pipe.hasNextLine())
                retString = pipe.nextLine();

        } while (retString == null || (retString.trim().length() == 1
                && !(retString.trim().equalsIgnoreCase("y") || retString.trim().equalsIgnoreCase("n"))));

        if (retString.trim().equalsIgnoreCase("y"))
            return true;
        else
            return false;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String retString = "";
        do
        {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            if (pipe.hasNextLine())
                retString = pipe.nextLine();

        } while (retString == null || !retString.matches(regEx));

        return retString;

    }
    public static void prettyHeader(String msg) {
        int starCount=60;
        while(starCount!=0)
        {System.out.print("*");
            starCount--;
        }
        System.out.println();
        int starsonLeft=(60-msg.length())/2;
        int left=1;
        while(left<=starsonLeft)
        {
            System.out.print("*");
            left++;
        }
        System.out.print(msg);
        int right=0;
        while(right<=starsonLeft)
        {
            System.out.print("*");
            right++;
        }
        System.out.println();
        starCount=60;
        while(starCount!=0)
        {
            System.out.print("*");
            starCount--;
        }
    }
}