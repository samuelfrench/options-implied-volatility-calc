
import java.util.Scanner;

/**
 *
 * @author sam french
 * 
 * samfrench@gmail.com
 * github: samuelfrench
 */
public class IVCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double price, iv, option;
        while (true) {
            System.out.println("Price: ");
            price = sc.nextDouble();
            System.out.println("IV: (Should be between 0 and 1, for instance 20% is .2");
            iv = sc.nextDouble();
            System.out.println("Option: ");
            option = sc.nextDouble();
            calc(price, iv, 1);
            calc(price, iv, option);
            calc(price, iv, 365);
        }
    }

    public static void calc(double price, double iv, double option) {
        double thirdTerm = Math.sqrt(option / 365);
        double stdDev = price * iv * thirdTerm;
        System.out.println("-------------------------------------------------------");
        System.out.println("Option length of " + option + " days: ");
        double leftBound, rightBound;
        leftBound = price - stdDev;
        rightBound = price + stdDev;
        System.out.println("There is 68% chance the stock price will be between ");
        System.out.println(leftBound + " " + rightBound);
        System.out.println("For an option length of " + option + " days");
        System.out.println("(Standard Deviation: " + stdDev + ")");
    }
}
