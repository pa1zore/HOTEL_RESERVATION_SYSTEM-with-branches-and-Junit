import java.util.ArrayList;
import java.util.Scanner;

class Hotel {
    private String name;
    private int rateForRegularCustomer;
    private int weekdayRate;
    private int weekendRate;

    public Hotel() {
    }

    public Hotel(String name, int rateForRegularCustomer) {
        this.name = name;
        this.rateForRegularCustomer = rateForRegularCustomer;
    }

    public String getName() {
        return this.name;
    }

    public int getRateForRegularCustomer() {
        return this.rateForRegularCustomer;
    }

    public void setRateForRegularCustomer(int rateForRegularCustomer) {
        this.rateForRegularCustomer = rateForRegularCustomer;
    }

    public void setWeekdayAndWeekendRates(int weekdayRate, int weekendRate) {
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
    }

    public int getWeekdayRate() {
        return weekdayRate;
    }

    public int getWeekendRate() {
        return weekendRate;
    }
    public int calculateTotalCostForDateRange(int[] dateRange) {
        int totalCost = 0;
        for (int date : dateRange) {
            if (date >= 1 && date <= 5) {
                totalCost += weekdayRate;
            } else {
                totalCost += weekendRate;
            }
        }
        return totalCost;
    }

    public String toString() {
        return "Hotel name is " + name + " rate for regular customer " + rateForRegularCustomer + "$";
    }
}

public class Hotel_Resevation_System_Main {
    static ArrayList<Hotel> hotel = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Hotel h1 = new Hotel("Lakewood", 110);
        h1.setWeekdayAndWeekendRates(110, 90);

        Hotel h2 = new Hotel("Bredgewood", 160);
        h2.setWeekdayAndWeekendRates(150, 50);

        Hotel h3 = new Hotel("Ringwood", 220);
        h3.setWeekdayAndWeekendRates(220, 150);

        hotel.add(h1);
        hotel.add(h2);
        hotel.add(h3);

        int dcount = 0;
        System.out.println("Enter date");
        String date1 = sc.nextLine();
        if (date1.matches("\\w"))
            dcount++;

        System.out.println("Enter date");
        String date2 = sc.nextLine();
        dcount++;

        Hotel h = cheapestHotel(dcount);
        System.out.println("Cheapest hotel is");
        System.out.println("Hotel name: " + h.getName() + " hotel price: " + h.getRateForRegularCustomer());

        int[] dateRange = { 11, 12 }; // You can modify this array based on user input or other requirements

        Hotel cheapestHotel = findCheapestHotelForDateRange(dateRange);
        System.out.println("Cheapest hotels for the given date range:");
        System.out.println("Hotel name: " + cheapestHotel.getName() + ", Total Rate: " + cheapestHotel.calculateTotalCostForDateRange(dateRange));
    }

    public static Hotel cheapestHotel(int count) {
        Hotel temp = new Hotel(hotel.get(0).getName(), hotel.get(0).getRateForRegularCustomer());

        for (int i = 0; i < hotel.size(); i++) {
            if (temp.getRateForRegularCustomer() > hotel.get(i).getRateForRegularCustomer()) {
                temp = new Hotel(hotel.get(i).getName(), hotel.get(i).getRateForRegularCustomer());
            }
        }

        int i = 0;
        int sum = 0;
        while (i < count) {
            sum += temp.getRateForRegularCustomer();
            i++;
        }

        temp.setRateForRegularCustomer(sum);
        return temp;
    }
    public static Hotel findCheapestHotelForDateRange(int[] dateRange) {
        Hotel cheapestHotel = null;
        int minCost = Integer.MAX_VALUE;

        for (Hotel h : hotel) {
            int totalCost = h.calculateTotalCostForDateRange(dateRange);

            if (totalCost < minCost) {
                minCost = totalCost;
                cheapestHotel = h;
            }
        }

        return cheapestHotel;
    }
}
