/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
/**
 *
 * @author a4178
 */

@DisplayName("Testing fisher camp model")
public class FisherCampTest {
    static FishingCamp model = new FishingCamp();
    
    
    
    
    
    
    @ParameterizedTest
    @MethodSource("calendarSource")
    void testCalendar(String day, String month, String year ){
        
        if(day.length() == 2 && month.length() == 2 && year.length() == 4){
            assertEquals(true,true);
        }else{
            fail("incorrect length");
        }
    }
  
    
    private static Stream<Arguments> calendarSource(){
         return Stream.of(
        Arguments.of("01","10","2001"),
        Arguments.of("3131","3131","2001"),
        Arguments.of("12313131","10","500")
        );
    }
    
    
    @ParameterizedTest
    @CsvSource({"qq,ww","ee,rr","tt,yy"})
    void testDummyString(String str1,String str2){
        String expected = str1+str2;
        String res = model.getDummyString(str1, str2);
        assertEquals(expected,res);
    }
    
    
    @ParameterizedTest
    @ValueSource(ints={1,2})       
    void testDummySum(int i, int j){
        int res = model.getDummySum(i, j);
        int expected = i + j;
        assertEquals(expected,res);
    }
    
    
    
    
    @Test
    @DisplayName("opening date testing")
    void openingDateTesting(){    
        String result = model.getOpeningDate();
        assertEquals("2001-09-01",result);
    }
    
    @Test
    @DisplayName("init date testing")
    void initDateTesting(){    
        String first = model.getCurrentDate();
        String second = model.getOpeningDate();
        assertEquals(first,second);
    }
    
   
    
    
}
