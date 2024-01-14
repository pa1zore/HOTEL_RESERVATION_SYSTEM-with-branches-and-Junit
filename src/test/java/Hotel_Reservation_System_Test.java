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
        Hotel hotel1 = new Hotel(name,price);
        String actualName=hotel1.getName();
        int  actualPrice = hotel1.getRateForRegularCustomer();
        //then
        Assertions.assertEquals(actualName,name);
        Assertions.assertEquals(actualPrice,price);
    }
}
