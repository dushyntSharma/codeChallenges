package mobile;

//Add mobiles
//display
//sort the mobiles using bubble sort
//display them
//take the mobile id from the user
//update the price using setters
//display them after
//delete particular mobile id

import java.util.Scanner;

public class MobileApp {
	static Scanner sc = new Scanner(System.in);
	static int noOfMobiles;
	static Mobile[] allMobiles;

	public static void main(String[] args) {
		System.out.println("Enter the no of mobiles");
		noOfMobiles = sc.nextInt();
		allMobiles = new Mobile[noOfMobiles];
		int choice = 0;
		do {
			displayMainMenu();
			System.out.println("Enter the choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				addNewMobile(allMobiles);
				displayProductDetails(allMobiles);
				break;

			case 2:
				sortMobileByModel();
				break;
			case 3:
				updateQtForPartProduct(allMobiles);
				displayProductDetails(allMobiles);
				break;
			case 4:

				deleteParticularProduct();
				break;
			case 5:
				System.out.println("Visit again, Thank you!!");
				System.exit(choice);

			default:
				System.out.println("Invalid choice");
				System.out.println("Try again");

			}

		} while (choice < 6);

	}

	public static Mobile[] removeTheElement(Mobile[] arr, int index) {

		if (arr == null || index < 0 || index >= arr.length) {
			return arr;
		}
		// take another array
		Mobile[] anotherArray = new Mobile[arr.length - 1];
		// loop through the original array
		for (int i = 0, k = 0; i < arr.length; i++) {
			if (i == index) {
				continue;
			}
			// print
			anotherArray[k++] = arr[i];
		}
		return anotherArray;
	}

	private static void deleteParticularProduct() {
		System.out.println("Enter the mobile id");
		long id = sc.nextLong();

		for (int i = 0; i < noOfMobiles; i++) {
			if (id == allMobiles[i].getId()) {
				allMobiles = removeTheElement(allMobiles, i);
			}
		}
		displayProductDetails(allMobiles);

	}

//	private static void deleteParticularProduct(Mobile[] allMobiles, int id1) {
//		// TODO Auto-generated method stub
//		for (int i = 0; i < allMobiles.length; i++) {
//			if (allMobiles[i].getId() == id1) {
//				allMobiles[i] = allMobiles[allMobiles.length - 1];
//				break;
//			}
//			if (i == allMobiles.length - 1) {
//				System.out.println("That requested mobile is not there");
//			}
//		}
//
//		for (int i = 0; i < allMobiles.length - 1; i++) {
//			System.out.println("Mobile Id       :" + allMobiles[i].getId());
//			System.out.println("Mobile Model     :" + allMobiles[i].getModel());
//			System.out.println("Mobile Price :" + allMobiles[i].getPrice());
//			System.out.println("Mobile Date    :" + allMobiles[i].getDate());
//			System.out.println("================================================");
//
//		}
//
//	}

	private static Mobile[] updateQtForPartProduct(Mobile[] allMobiles) {
		// TODO Auto-generated method stub
		System.out.println("Enter the ID");
		long id = sc.nextLong();
		System.out.println("Enter the Price");
		double price = sc.nextDouble();
		for (int i = 0; i < allMobiles.length; i++) {
			if (allMobiles[i].getId() == id) {
				allMobiles[i].setPrice(price);
			}

		}
		return allMobiles;

	}

	private static void sortMobileByModel() {
		// TODO Auto-generated method stub
		Mobile mobiles[] = new Mobile[noOfMobiles];
		mobiles = allMobiles;
		Mobile pt[] = new Mobile[noOfMobiles];
		for (int i = 0; i < noOfMobiles - i; i++) {
			for (int j = i + 1; j < noOfMobiles; j++) {
				if (mobiles[i].getModel().compareTo(mobiles[j].getModel()) > 0)// if(a>b)
				{
					pt[i] = mobiles[i];// temp=a;

					mobiles[i] = new Mobile(mobiles[j].getId(), mobiles[j].getModel(), mobiles[j].getPrice(),
							mobiles[j].getDate());// a=b;
					mobiles[j] = new Mobile(pt[i].getId(), pt[i].getModel(), pt[i].getPrice(), pt[i].getDate());// b=temp;
				}
			}
		}
		for (int i = 0; i < noOfMobiles; i++) {
			System.out.println("ID :" + mobiles[i].getId() + "\nModel :" + mobiles[i].getModel() + "\nPrice :"
					+ mobiles[i].getPrice() + "\nDate :" + mobiles[i].getDate() + "\n====================");
		}

	}

	private static void displayProductDetails(Mobile[] allMobiles) {
		// TODO Auto-generated method stub
		for (int i = 0; i < allMobiles.length; i++) {
			System.out.println("The Mobile are -> ");
			System.out.println("Mobile Id       :" + allMobiles[i].getId());
			System.out.println("Mobile Name     :" + allMobiles[i].getModel());
			System.out.println("Mobile Quantity :" + allMobiles[i].getPrice());
			System.out.println("Mobile Price    :" + allMobiles[i].getDate());
			System.out.println("===========================");
		}

	}

	private static Mobile[] addNewMobile(Mobile[] allMobiles) {
		// TODO Auto-generated method stub
		for (int i = 0; i < allMobiles.length; i++) {
			System.out.println("Enter the id");
			long id = sc.nextLong();
			System.out.println("Enter the model");
			sc.nextLine();
			String model = sc.nextLine();
			System.out.println("Enter the price");
			int price = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the date");
			String date = sc.nextLine();
			allMobiles[i] = new Mobile(id, model, price, date);

		}
		return allMobiles;

	}

	private static void displayMainMenu() {
		// TODO Auto-generated method stub
		System.out.println("...........Main Menu......");
		System.out.println("1.Add mobiles and display");
		System.out.println("2.sort all mobiles based on model");
		System.out.println("3.update price and display");
		System.out.println("4.Delete mobiles based on ID");
		System.out.println("5.Exit");

	}

}
