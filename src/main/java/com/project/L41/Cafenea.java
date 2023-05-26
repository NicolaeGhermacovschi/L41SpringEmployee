package com.project.L41;

import java.util.HashMap;
import java.util.Map;

public class Cafenea {
    private Map<String, String> rezervari;

    public Cafenea() {
        rezervari = new HashMap<>();
    }

    public void rezervaMasa(String nume, String oraStart, String oraSfarsit, String masa) {
        for (Map.Entry<String, String> rezervare : rezervari.entrySet()) {
            String existingMasa = rezervare.getKey();
            String existingOraStart = rezervare.getValue().split("-")[0];
            String existingOraSfarsit = rezervare.getValue().split("-")[1];

            // Verificăm dacă există suprapunere de ore între rezervări
            if (existingMasa.equals(masa) && (
                    (oraStart.compareTo(existingOraStart) >= 0 && oraStart.compareTo(existingOraSfarsit) < 0) ||
                            (oraSfarsit.compareTo(existingOraStart) > 0 && oraSfarsit.compareTo(existingOraSfarsit) <= 0) ||
                            (oraStart.compareTo(existingOraStart) <= 0 && oraSfarsit.compareTo(existingOraSfarsit) >= 0)
            )) {
                System.out.println("Masa " + masa + " este deja rezervată în intervalul orar " +
                        existingOraStart + " - " + existingOraSfarsit + ".");
                return;
            }
        }

        rezervari.put(masa, oraStart + "-" + oraSfarsit);
        System.out.println("Masa " + masa + " a fost rezervată pentru " +
                nume + " în intervalul orar " + oraStart + " - " + oraSfarsit + ".");
    }

    public void meseRezervate() {
        if (rezervari.isEmpty()) {
            System.out.println("Nu există mese rezervate în acest moment.");
            return;
        }

        System.out.println("Mesele rezervate sunt:");

        for (Map.Entry<String, String> rezervare : rezervari.entrySet()) {
            String masa = rezervare.getKey();
            String oraStart = rezervare.getValue().split("-")[0];
            String oraSfarsit = rezervare.getValue().split("-")[1];

            System.out.println("Masa " + masa + ": " + oraStart + " - " + oraSfarsit);
        }
    }

    public static void main(String[] args) {
        Cafenea cafenea = new Cafenea();

        cafenea.rezervaMasa("John", "10:00", "12:00", "A");
        cafenea.rezervaMasa("Alice", "11:00", "14:00", "B");
        cafenea.rezervaMasa("Bob", "13:00", "15:00", "C");
        cafenea.rezervaMasa("Bob", "14:00", "16:00", "C");

        cafenea.meseRezervate();
    }
}
