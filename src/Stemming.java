import java.util.ArrayList;
import java.util.Random;

public class Stemming {
    public static void main(String[] args) {

        // Creeer 3 partijen
        Partij pvda = new Partij("PVDA", new String[] {"Henk", "Bert", "Danny", "Tom", "Dennis", "Barry", "Dave", "Ingrid"});
        Partij cda = new Partij("CDA", new String[] {"Jos", "Imre", "Nick", "Cheryl", "Frank"});
        Partij vvd = new Partij("VVD", new String[] {"Mark", "Margreet", "Bertus"});

        // Maak een kieslijst van de 3 partijen
        ArrayList<Partij> kieslijst = new ArrayList<Partij>();
        kieslijst.add(pvda);
        kieslijst.add(cda);
        kieslijst.add(vvd);

        // Stem 50 keer op een willekeurige kandidaat
        RandomStemming(50, kieslijst);
    }

    private static void RandomStemming(int total, ArrayList<Partij> partijen) {
        for (int i = 0; i < total; i++) {
            if (i < total - 1) {
                voegStemmenToe(partijen);
            } else {
                ShowStemming(partijen);
            }
        }
    }

    private static void ShowStemming(ArrayList<Partij> partijen) {
        System.out.println(System.lineSeparator() + "Resultaten van de stemming:");
        for (int i = 0; i < partijen.size(); i++) {
            int totaalStemmen = 0;
            String partijNaam = System.lineSeparator() + partijen.get(i).partijNaam;
            System.out.println(partijNaam);
            for (int j = 0; j < partijen.get(i).partijKandidaten.size(); j++) {
                String naam = partijen.get(i).partijKandidaten.get(j).kandidaatNaam;
                int stemmen = partijen.get(i).partijKandidaten.get(j).kandidaatStemmen;
                System.out.println(naam + ' ' + stemmen);
                totaalStemmen = totaalStemmen + stemmen;
            }
            System.out.println(System.lineSeparator() + "Totaal aantal stemmen = " + totaalStemmen);
        }
    }

    private static void voegStemmenToe(ArrayList<Partij> partijen) {
        Random randomPartij = new Random();
        int partijenlength = randomPartij.nextInt(partijen.size());
        Random randomKandidaat = new Random();
        int kandidatenLength = randomKandidaat.nextInt(partijen.get(partijenlength).partijKandidaten.size());
        partijen.get(partijenlength).partijKandidaten.get(kandidatenLength).kandidaatStemmen++;
    }

}