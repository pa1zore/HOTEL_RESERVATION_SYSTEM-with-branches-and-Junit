import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Hotel_Reservation_System_Test {

    // test case for cheking input is store or not
    @Test
    void shoudl_return_same_value_after_passing_throw_constructor()
    {
        // given
        String name = "akash";
        int price=110;
        //when
        Hotel hotel = new Hotel(name,price);
        String actualName=hotel.getName();
        int  actualPrice = hotel.getRateForRegularCustomer();
        //then
        Assertions.assertEquals(actualName,name);
        Assertions.assertEquals(actualPrice,price);
    }
    @Test 
    void should_return_chepeast_hotel_name_and_price()
    {
        Hotel h1=  new Hotel("Lakewood",110);
        Hotel h2=  new Hotel("Bredgewood",160);
        Hotel h3=  new Hotel("Ringwood",220);
        Hotel_Resevation_System_Main.hotel.add(h1);
        Hotel_Resevation_System_Main.hotel.add(h2);
        Hotel_Resevation_System_Main.hotel.add(h3);

        Hotel h=Hotel_Resevation_System_Main.cheapestHotel(2);
        int actual=h.getRateForRegularCustomer();
        Assertions.assertEquals(actual,220);
    }
}
