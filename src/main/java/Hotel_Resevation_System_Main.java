import java.util.ArrayList;
import java.util.Scanner;

class Hotel
{
    //declearing data members as private for avoiding direct acess
    private String name;
    private int rateForRegularCustomer;
    public Hotel()
    {

    }
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
    public void setRateForRegularCustomer(int rateForRegularCustomer)
    {
        this.rateForRegularCustomer=rateForRegularCustomer;
    }
    // toString method for getting all the contents of current object
    public String toString()
    {
        return "Hotel name is "+name+" rate for regular customer "+rateForRegularCustomer+"$";
    }

}


public class Hotel_Resevation_System_Main {
    static ArrayList<Hotel> hotel = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Hotel h1=  new Hotel("Lakewood",110);
        Hotel h2=  new Hotel("Bredgewood",160);
        Hotel h3=  new Hotel("Ringwood",220);
        hotel.add(h1);
        hotel.add(h2);
        hotel.add(h3);

        int dcount=0;
        System.out.println("enter date");
        String date1=sc.nextLine();
        if(date1.matches("\\w"))
            dcount++;
        System.out.println("enter date");
        String date2=sc.nextLine();
        dcount++;

        Hotel h;
        h=cheapestHotel(dcount);
        System.out.println(" cheapest hotel is");
        System.out.println("Hotel name: "+h.getName()+" hotel price: "+h.getRateForRegularCustomer());


    }
    public static Hotel cheapestHotel(int count)
    {
        Hotel temp= new Hotel(hotel.get(0).getName(),hotel.get(0).getRateForRegularCustomer());
        for (int i=0;i<hotel.size();i++)
        {
            if(temp.getRateForRegularCustomer()>hotel.get(i).getRateForRegularCustomer())
            {
                temp = new Hotel(hotel.get(i).getName(),hotel.get(i).getRateForRegularCustomer());
            }
        }
        int i=0;
        int sum=0;
        while(i<count)
        {
            sum+=temp.getRateForRegularCustomer();
            i++;
        }
        temp.setRateForRegularCustomer(sum);
        return temp;
    }
}
