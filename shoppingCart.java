
import java.util.Arrays;
import java.util.Scanner;

public class shoppingCart {

    public static void main(String[] args) {
        boolean loop=true;
        init();
        while(loop){
        System.out.println("Enter products");
        Scanner in = new Scanner(System.in);
        String products = in.nextLine();
        int result = totalPrice(products);
        if (result == 0) {
            System.out.print("Empty Cart");
        } else if (result == -1) {
            System.out.print("Wrong input");
        } else {
            System.out.println("Total Price " + result + ".00 ");
        }
         System.out.println("Do yo want to continue: (y/n)");
         String n=in.next().toLowerCase();
         if(!n.equals("y"))
          loop=false;
       }
    }

    static void init() {
        System.out.println("Product Code | Price");
        System.out.println("      A      |  RS 35.00 each or 4 for RS 100.00");
        System.out.println("      B      |  RS 65.00");
        System.out.println("      C      |  RS 50.00 each or RS 250 for a six-pack");
        System.out.println("      D      |  RS 85.00");

    }

    static int totalPrice(String products) {
        char[] productArray = products.toCharArray();
        int[] quantitiyCount = new int[4];
        Arrays.fill(quantitiyCount, 0);
        int i = 0;
        for (; i < products.length(); i++) {
            if (productArray[i] != 'A' && productArray[i] != 'B' && productArray[i] != 'C' && productArray[i] != 'D') {
                return -1;
            }
            quantitiyCount[productArray[i] - 65]++;
        }
        if (i != 0) {
            return (quantitiyCount[0] / 4) * 100 + (quantitiyCount[0] % 4) * 35 + quantitiyCount[1] * 65 + (quantitiyCount[2] / 6) * 250 + (quantitiyCount[2] % 6) * 50 + quantitiyCount[3] * 85;
        }
        return 0;
    }

}
