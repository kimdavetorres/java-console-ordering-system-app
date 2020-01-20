package ordering_System1;
import java.util.Scanner;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ordering_System {
	public static int numberOfProducts = product_Object.productName.length;

	public static void main(String[] args) {
		productsDetailsDisp();
		customerOrder();
	}

	public static void next() {
		productsDetailsDisp();
		customerOrder();
	}

	public static void productsDetailsDisp() {
		System.out.print("\n\n---------------------------------------------------------------\n");
		System.out.print("                      X I O M I GADGETS\n\n");
		System.out.print("PRODUCT-NUMBER\t\tPRODUCT-NAME\t\tPRODUCT-PRICE\n");
		System.out.print("---------------------------------------------------------------\n");
		String space = " ";
		int longestString = 0;
		for(int i = 0; i < numberOfProducts; i++) {
			if(longestString < (product_Object.productName[i].length())) {
				longestString = product_Object.productName[i].length();
			}
		}
		for(int i = 0; i < numberOfProducts; i++) {
			int numberOfSpace = longestString - product_Object.productName[i].length() + 4;
			System.out.print(i + 1 + "\t\t\t");
			System.out.print(product_Object.productName[i] + space);
			for(int j = 0; j < numberOfSpace; j++) {
				System.out.print(space);
			}
			System.out.print("PHP " + product_Object.productPrice[i]);
			System.out.print("\n");
		}
		System.out.print("---------------------------------------------------------------\n");
		/*JFrame frame = new JFrame("Ordering System");
		String[] column = {"PRODUCT-NUMBER", "PRODUCT-NAME", "PRODUCT-PRICE"};
		String[][] data = {
				{"  PRODUCT-NUMBER", "  PRODUCT-NAME", "  PRODUCT-PRICE"},
				{"  1", "  Xiaomi Redmi Note 8", "  PHP 9,990"},
				{"  2", "  Xiaomi Mi 9T Pro", "  PHP 19,562"},
				{"  3", "  Xiaomi Mi 9 SE", "  PHP 17,140"},
				{"  4", "  Xiaomi Mi 9T Pro", "  PHP 22,000"},
				{"  5", "  Xiaomi Redmi 7A", "  PHP 4,490"},
				{"  6", "  Xiaomi Redmi 6", "  PHP 6,090"},
				{"  7", "  Dell G3 3579 i5", "  PHP 46,956"},
				{"  8", "  Dell Inspiron G7", "  PHP 128,826"},
				{"  9", "  Mi USB Car Charger", "  PHP 450"},
				{"  10", "  Xiaomi Redmi 7", "  PHP 6,490"}
		};
		JTable table = new JTable(data, column);
		table.setRowHeight(62);
		table.setRowMargin(45);
		table.setBorder(BorderFactory.createDashedBorder(Color.blue, 5, 0));
		table.setGridColor(new Color(220, 220, 220));
		table.setFont(new Font("Verdana", Font.PLAIN, 16));
		frame.setSize(6000, 9000);
		frame.setVisible(true);
		frame.add(table);*/

	}

	public static void customerOrder() {

//		String str1, str2;
		int flag = 1, flag2 = 1;
		int prod_number;

		Scanner prod_num = new Scanner(System.in);
		do {

			System.out.print("Enter product number >> ");
			prod_number = prod_num.nextInt();

//			str1 = JOptionPane.showInputDialog(strProdNumLabel, + 0);
//			productNum = Integer.parseInt(str1);

			if(prod_number > 0 && prod_number <= numberOfProducts) {
				flag = 0;
			}else {
				flag = 1;
			}

		}while(flag == 1);

		Scanner user_qty = new Scanner(System.in);
		do {

			System.out.print("Enter quantity >> ");
//			str2 = JOptionPane.showInputDialog(strQtyLabel, + 0);
//			quantity = Integer.parseInt(str2);
			int qty = user_qty.nextInt();
			if(qty < 0) {
				flag2 = 1;
			}else {
				customer_Object.quantity[prod_number-1] += qty;
				flag2 = 0;
			}

		}while(flag2 == 1);

		viewOrdered();

	}

	public static void cls() {

	    try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void viewOrdered() {

		cls();
		boolean sent = true;
//		String anotherStr;
//		int another;
		String space = " ";

		System.out.print("\n\n--------------------------------------------------------------------------------------\n");
		System.out.print("\t\t\t\t   REVIEW ORDERED\n\n");
		System.out.print("Product-Number\t\tProduct-Name\t\tQty\t\tProduct-Price\tTotal\n");
		System.out.print("--------------------------------------------------------------------------------------\n");
		int longestString = 0;
		for(int i = 0; i < numberOfProducts; i++) {
			if(longestString < (product_Object.productName[i].length())) {
				longestString = product_Object.productName[i].length();
			}
		}
		for(int i = 0; i < numberOfProducts; i++) {
			if(customer_Object.quantity[i] > 0) {
				int numberOfSpace = longestString - product_Object.productName[i].length() + 4;
				System.out.print(i + 1 + "\t\t\t");
				System.out.print(product_Object.productName[i] + space);
				for(int j = 0; j < numberOfSpace; j++) {
					System.out.print(space);
				}
//				null,"REVIEW ORDERED\n\n" + "Product number:     [" + (i+1) + "]" + "\n" + "Product name:         [" + product_Object.productName[i] + "]" + "\n" + "Quantity:                    [" + customer_Object.quantity[i] + "]" + "\n" + "Product price:          [" + product_Object.productPrice[i] + "]" + "\n"  + "Total:                          [" + (customer_Object.total += product_Object.productPrice[i] * customer_Object.quantity[i]) + "]" + "\n" + "_________________________________________\n\n"
				System.out.print(customer_Object.quantity[i] + "\t\t");
				System.out.print(product_Object.productPrice[i] + "\t\t");
				System.out.print(customer_Object.quantity[i] * product_Object.productPrice[i] + "\n");
				customer_Object.total += customer_Object.quantity[i] * product_Object.productPrice[i];
			}
			System.out.print("\n");
		}
		System.out.print("---------------------------------------------------------------------------------------\n");

		Scanner anthr = new Scanner(System.in);
		do {

			System.out.print("\nAdd Order ?\t[1]Yes\t[2]No >> ");
			int another_order = anthr.nextInt();
			if(another_order == 1) {
				cls();
				productsDetailsDisp();
				customerOrder();
				sent = false;
			}else if(another_order == 2) {
				customerPayment();
				sent = false;
			}else {
				sent = true;
			}

		}while(sent);


	}

	public static void customerPayment() {
		cls();
		boolean sent = true;
		int i = 0;
//		String e = "Enter Cash";
//		String payStr;

		Scanner input_user = new Scanner(System.in);
		do {
			System.out.print("\n\n================================================\n");
			System.out.print("            Amount to pay : PHP " + customer_Object.total + "\n");
			System.out.print("================================================\n");
			System.out.print("Enter cash >> ");
			customer_Object.payCash = input_user.nextInt();
			if(customer_Object.payCash >= customer_Object.total) {
				i = 1;
				sent = false;
			}else if(customer_Object.payCash < customer_Object.total){
				System.out.print("\nNot enough (PHP " + customer_Object.payCash + " ) to pay!\n\n");
				sent = true;
			}else {
				sent = true;
			}

		}while(sent);

		if(i == 1) {
			customerChange();
		}

	}

	public static void customerChange() {

		cls();
		customer_Object.change = customer_Object.payCash - customer_Object.total;
		System.out.print("\n\n================================================\n");
		System.out.print("               Change : PHP " +  customer_Object.change + "\n");
		System.out.print("================================================\n\n");
		System.out.print("GENERATING RECIEPTS........\n\n");
		try
		{
		    Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		customerReciept();

	}

	public static void customerReciept() {
		cls();
		System.out.print("\n\n====================================================================\n");
		System.out.print("                           R E C I E P T S\n");
		System.out.print("                        SM MANDAUE CEBU CITY\n ");
		System.out.print("                  TIN #: 0000030340512444555555\n\n");
		System.out.print("                                                                    \n");
		System.out.print("Product Name\t\tQty\t\tPrice\t\tSub-Total\n\n");
		String space = " ";
		int longestString = 0;
		int numberOfSpace;
		for(int i = 0; i < numberOfProducts; i++) {
			if(longestString < (product_Object.productName[i].length())) {
				longestString = product_Object.productName[i].length();
			}
		}

		for(int i = 0; i < numberOfProducts; i++) {
			if(customer_Object.quantity[i] > 0) {
				numberOfSpace = longestString - product_Object.productName[i].length() + 5;
				System.out.print(product_Object.productName[i] + space);
				for(int j = 0; j < numberOfSpace; j++) {
					System.out.print(space);
				}
				System.out.print(customer_Object.quantity[i] + "\t\t");
				System.out.print(product_Object.productPrice[i] + "\t\t");
				System.out.print(customer_Object.quantity[i] * product_Object.productPrice[i]);
			}
			System.out.print("\n");
		}

		System.out.print("\n                                                        -------\n");
		System.out.print("TOTAL                                                   ");
		System.out.print(customer_Object.total);
		System.out.print("\n");
		System.out.print("CASH                                                    ");
		System.out.print(customer_Object.payCash);
		System.out.print("\n");
		System.out.print("CHANGE                                                  ");
		System.out.print(customer_Object.change);
		System.out.print("\n");
		System.out.print("====================================================================\n");
		nextCustomer();

	}

	public static void nextCustomer() {
		boolean sent = true;
		int c = 0;

		Scanner next = new Scanner(System.in);
		do {
			System.out.print("\nNext customer ?\t[1]Yes     [2]No >> ");
			int n = next.nextInt();
			if(n == 1) {
				for(int i = 0; i < numberOfProducts; i++) {
					customer_Object.quantity[i] = 0;
				}
				customer_Object.payCash = 0;
				customer_Object.total = 0;
				customer_Object.change = 0;
				c = 1;
				sent = false;
			}else if(n == 2) {
				System.exit(0);
				sent = false;
			}else {
				sent = true;
			}
		}while(sent);

		if(c == 1) {
			cls();
			next();
		}
	}

}
