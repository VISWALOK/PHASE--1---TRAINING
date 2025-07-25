import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PackageService service = new PackageServiceImpl();

        try (Scanner sc = new Scanner(System.in)) {  
            while (true) {
                System.out.println("\n1. Add Package Details");
                System.out.println("2. Display All Packages");
                System.out.println("3. Search Package by ID");
                System.out.println("4. Calculate Package Cost");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); 

                try {
                    switch (choice) {
                        case 1:
                            System.out.print("Enter Package ID (exactly 7 characters): ");
                            String id = sc.nextLine();
                            if (id.length() != 7) {
                                System.out.println(" Package ID must be exactly 7 characters long.");
                                break;
                            }

                            System.out.print("Enter Source Place: ");
                            String source = sc.nextLine();
                            System.out.print("Enter Destination Place: ");
                            String dest = sc.nextLine();
                            System.out.print("Enter Number of Days: ");
                            int days = sc.nextInt();
                            System.out.print("Enter Basic Fare: ");
                            double fare = sc.nextDouble();

                            Package p = new Package(id, source, dest, days, fare);
                            service.addPackage(p);
                            System.out.println(" Package added successfully.");
                            break;

                        case 2:
                            for (Package pkg : service.fetchAllPackages()) {
                                System.out.println("ID: " + pkg.getPackageId() + ", Source: " + pkg.getSource() +
                                        ", Destination: " + pkg.getDestination() + ", Days: " + pkg.getNoOfDays() +
                                        ", Cost: Rs." + pkg.getPackageCost());
                            }
                            break;

                        case 3:
                            System.out.print("Enter Package ID: ");
                            String searchId = sc.nextLine();
                            Package found = service.findPackageById(searchId);
                            if (found != null) {
                                System.out.println("Found: " + found.getPackageId() + ", " +
                                        found.getSource() + " to " + found.getDestination());
                            } else {
                                System.out.println("Package not found.");
                            }
                            break;

                        case 4:
                            System.out.print("Enter Package ID: ");
                            String calcId = sc.nextLine();
                            service.calculatePackageCost(calcId);
                            System.out.println("Package cost calculated successfully.");
                            break;

                        case 5:
                            System.out.println("Exiting...");
                            return;

                        default:
                            System.out.println("Invalid choice!");
                    }
                } catch (InvalidPackageIdException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
