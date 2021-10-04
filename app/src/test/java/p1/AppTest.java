/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package p1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

class AppTest {
    @Test void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }

    @Test
   public void testFound() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(15, 20, 25, 30));
      assertTrue(App.searchTheSum(array, 5, 10, 15));
    }

    @Test
    public void testFound2() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(100, 200, 300, 400));
      assertTrue(App.searchTheSum(array, 100, 100, 100));
    }

    @Test
    public void testNotFound() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      assertFalse(App.searchTheSum(array, 5, 10, 15));
    }

    @Test
    public void testEmptyArray() {
      ArrayList<Integer> array = new ArrayList<>();
      assertFalse(App.searchTheSum(array, 1 ,2 ,3));
    }

    @Test
    public void testNull() {
      assertFalse(App.searchTheSum(null, 1, 2 ,3));
    }

}
