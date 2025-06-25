package BestellManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KaffeeTest {
    Kaffee kaffee = new Kaffee("Espresso", false, "Kuhmilch", 2);
    @Test
    void berechneTest(){
       double gesamtpreis = kaffee.berechne();
       assertEquals(4.40, gesamtpreis);

   }
   @Test
    void toStringTest(){
        assertEquals("2x Espresso, Kuhmilch, zum hier trinken", kaffee.toString());
   }
}