import com.menu.Main;
import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;

public class MainTest {
    /*@Test
    public void createGiftTest(){
        String simulatedUserInput = "gift" +  "\n"
                +"korivka" +  "\n"
                +"save" +  "\n";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertEquals("korivka", Main.createGift().getCandies().get(0).getName());
    }
    /*@Test
    public void SortGiftTest(){
        Gift gift = new Gift("gift");
        gift.addCandy(new Candy("b",1,1,1));
        gift.addCandy(new Candy("a", 2,2,2));
        String simulatedUserInput = "0" + "\n" + "ABC" +  "\n";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        given(findGift()).willReturn(gift);
        Assert.assertEquals("a", Main.sortGift().getCandies().get(0).getName());
    }*/
}