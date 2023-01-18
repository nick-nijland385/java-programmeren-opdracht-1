import java.util.ArrayList;
import java.util.Random;

public class Stemming {
    public static void main(String[] args) {

        // Creeer 3 partijen
        Partij pvda = new Partij("PVDA", new String[] {"Henk", "Bert", "Danny", "Tom", "Dennis", "Barry", "Dave", "Ingrid"});
        Partij cda = new Partij("CDA", new String[] {"Jos", "Imre", "Nick", "Cheryl", "Frank"});
        Partij vvd = new Partij("VVD", new String[] {"Mark", "Margreet", "Bertus", "Carmen", "Loïs"});

        // Maak een kieslijst van de 3 partijen
        ArrayList<Partij> kieslijst = new ArrayList<>();
        kieslijst.add(pvda);
        kieslijst.add(cda);
        kieslijst.add(vvd);

        // Stem 50 keer op een willekeurige kandidaat
        RandomStemming(kieslijst);
    }

    private static void RandomStemming(ArrayList<Partij> kieslijst) {
        for (int i = 0; i <= 50; i++) {
            if (i < 50) {
                voegStemmenToe(kieslijst);
            } else {
                ShowStemming(kieslijst);
            }
        }
    }

    private static void ShowStemming(ArrayList<Partij> kieslijst) {
        System.out.println(System.lineSeparator() + "Resultaten van de stemming:" + System.lineSeparator());
        for (Partij partij : kieslijst) {
            int totaalStemmen = 0;
            int totaalKandidaten = Partij.getTotalKandidaten(partij);
            String partijNaam = Partij.getPartijNaam(partij);
            System.out.println(partijNaam);
            for (int j = 0; j < totaalKandidaten; j++) {
                String kandidaatNaam = Partij.getKandidaat(partij, j);
                int kandidaatSttemmen = Partij.getAantalStemmen(partij, j);
                System.out.println(kandidaatNaam + ' ' + kandidaatSttemmen);
                totaalStemmen = totaalStemmen + kandidaatSttemmen;
            }
            System.out.println(System.lineSeparator() + "Totaal aantal stemmen = " + totaalStemmen + System.lineSeparator());
        }
    }

    private static void voegStemmenToe(ArrayList<Partij> kieslijst) {
        Random randomPartij = new Random();
        int partijenlength = randomPartij.nextInt(kieslijst.size());
        Random randomKandidaat = new Random();
        int kandidatenLength = randomKandidaat.nextInt(Partij.getTotalKandidaten(kieslijst.get(partijenlength)));
        Partij.setAantalStemmen(kieslijst.get(partijenlength), kandidatenLength);
    }

}