import java.util.ArrayList;
import java.util.Scanner;
//creating hotel1 class for first adding multiple hotels
class Hotel
{
    //declearing data members as private for avoiding direct acess
    private String name;
    private int rateForRegularCustomer;
    //parameterized constructor to initialised object
    public Hotel(String name, int rateForRegularCustomer)
    {
        this.name=name;
        this.rateForRegularCustomer=rateForRegularCustomer;
    }
    // only implementing getter method to avoid unauthorized access
    public String getName() {
        return this.name;
    }
    public int getRateForRegularCustomer()
    {
        return this.rateForRegularCustomer;
    }
    // toString method for getting all the contents of current object
    public String toString()
    {
        return "Hotel name is "+name+" rate for regular customer "+rateForRegularCustomer+"$";
    }

}
public class Hotel_Resevation_System_Main {
    static ArrayList<Hotel> hotel1 = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Hotel h=  new Hotel("Lakewood",110);
        hotel1.add(h);
        System.out.println(h);
    }

}
