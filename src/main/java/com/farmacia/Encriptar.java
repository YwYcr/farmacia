
package com.farmacia;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptar {
    public static void main (String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        var clavePablo = encoder.encode("123");
        var claveDaniel = encoder.encode("456");
        var claveJose = encoder.encode("789");
        
        //System.out.Println("Pablo (123): " +clavePablo);
        //System.out.Println("Daniel (456): " +claveDaniel);
        //System.out.Println("Jose (789): " +claveJose);
    }
}
