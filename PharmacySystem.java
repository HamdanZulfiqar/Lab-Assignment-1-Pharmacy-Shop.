import java.util.Scanner;
class Person {
    private String name;
    private String contactNumber;

    public Person(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
class Address {
    private String street;
    private String city;
    private String postalCode;

    public Address(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
class Medicine {
    private String medicineId;
    private String name;
    private double price;
    private int quantity;
    private String manufacturer;
    private String batchNumber;
    private Date expiryDate;

    public Medicine(String medicineId, String name, double price, int quantity, String manufacturer, String batchNumber, Date expiryDate) {
        this.medicineId = medicineId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
        this.batchNumber = batchNumber;
        this.expiryDate = expiryDate;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void displayInformation() {
        System.out.println("Medicine ID: " + medicineId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Batch Number: " + batchNumber);
        System.out.println("Expiry Date: " + expiryDate.getDay() + "/" + expiryDate.getMonth() + "/" + expiryDate.getYear());
    }
}
class PharmacyShop {
    private Person owner;
    private Address address;
    private Medicine[] medicines;
    private int medicineCount;
    private double totalRevenue;

    public PharmacyShop(Person owner, Address address, int maxMedicines) {
        this.owner = owner;
        this.address = address;
        this.medicines = new Medicine[maxMedicines];
        this.medicineCount = 0;
        this.totalRevenue = 0.0;
    }

    public void addMedicine(Medicine medicine) {
        if (medicineCount < medicines.length) {
            medicines[medicineCount] = medicine;
            medicineCount++;
        } else {
            System.out.println("Pharmacy is full. Cannot add more medicines.");
        }
    }

    public void displayMedicines() {
        for (int i = 0; i < medicineCount; i++) {
            medicines[i].displayInformation();
            System.out.println();
        }
    }

    public void sellMedicine(String medicineId, int quantity) {
        for (int i = 0; i < medicineCount; i++) {
            if (medicines[i].getMedicineId().equals(medicineId)) {
                if (medicines[i].getQuantity() >= quantity) {
                    medicines[i].setQuantity(medicines[i].getQuantity() - quantity);
                    totalRevenue += medicines[i].getPrice() * quantity;
                    System.out.println("Medicine sold successfully.");
                } else {
                    System.out.println("Not enough quantity available.");
                }
                return;
            }
        }
        System.out.println("Medicine not found.");
    }

    public void displayTotalRevenue() {
        System.out.println("Total Revenue: " + totalRevenue);
    }
}
public class PharmacySystem {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("**************************Welcome to Pharmacy Management System***************************** ");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        // Create a person
        System.out.print("Enter owner's name: ");
        String ownerName = scanner.nextLine();
        System.out.print("Enter owner's contact number: ");
        String ownerContactNumber = scanner.nextLine();
        Person owner = new Person(ownerName, ownerContactNumber);

        // Create an address
        System.out.print("Enter street: ");
        String street = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter postal code: ");
        String postalCode = scanner.nextLine();
        Address address = new Address(street, city, postalCode);

        // Create a pharmacy shop
        System.out.print("Enter maximum number of medicines: ");
        int maxMedicines = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        PharmacyShop pharmacy = new PharmacyShop(owner, address, maxMedicines);

        while (true) {
            System.out.println();
            System.out.println("1. Add medicine");
            System.out.println("2. Display medicines");
            System.out.println("3. Sell medicine");
            System.out.println("4. Display total revenue");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.println("Enter medicine ID: ");
                    String medicineId = scanner.nextLine();

                    System.out.println("Enter medicine name: ");
                    String medicineName = scanner.nextLine();

                    System.out.println("Enter medicine price: ");
                    double medicinePrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline left-over

                    System.out.println("Enter medicine quantity: ");
                    int medicineQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over

                    System.out.println("Enter manufacturer: ");
                    String manufacturer = scanner.nextLine();

                    System.out.println("Enter batch number: ");
                    String batchNumber = scanner.nextLine();

                    System.out.println("Enter expiry day: ");
                    int expiryDay = scanner.nextInt();

                    System.out.println("Enter expiry month: ");
                    int expiryMonth = scanner.nextInt();

                    System.out.println("Enter expiry year: ");
                    int expiryYear = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over

                    Date expiryDate = new Date(expiryDay, expiryMonth, expiryYear);
                    Medicine medicine = new Medicine(medicineId, medicineName, medicinePrice, medicineQuantity, manufacturer, batchNumber, expiryDate);
                    pharmacy.addMedicine(medicine);
                    break;
                case 2:
                    pharmacy.displayMedicines();
                    break;
                case 3:
                    System.out.println("Enter medicine ID: ");
                    String sellMedicineId = scanner.nextLine();
                    System.out.println("Enter quantity to sell: ");
                    int sellQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    pharmacy.sellMedicine(sellMedicineId, sellQuantity);
                    break;
                case 4:
                    pharmacy.displayTotalRevenue();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}