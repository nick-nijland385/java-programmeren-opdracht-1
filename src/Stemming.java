import java.util.ArrayList;
import java.util.Random;

public class Stemming {

    private static final Random randomStem = new Random();

    public static void main(String[] args) {

        // Er is een class Stemming deze heeft minimaal de volgende gegevens:

        // Een tweedimensionaal array
        Partij pvda = new Partij(new String[][]{{"PVDA"}, {"Margreet", "Bertus", "Carmen", "Loïs", "Tim"}});
        Partij vvd = new Partij(new String[][]{{"VVD"}, {"Mark", "Bart", "Tom", "Bas"}});
        Partij cda = new Partij(new String[][]{{"CDA"}, {"Hugo", "Sinem", "Astrid"}});

        // de kieslijst
        ArrayList<Partij> kieslijst = new ArrayList<>();

        // Er is een kieslijst met partijen.
        kieslijst.add(pvda);
        kieslijst.add(vvd);
        kieslijst.add(cda);

        // Uitgecomment:
        // De kieslijst heeft een methode om de lijst van partijen en kandidaten terug te geven.
        // showKieslijst(kieslijst);

        randomStemming(kieslijst);
    }

//  RandomStemming() daar wordt precies 50 keer een stemming uit gebracht, door random een partij te kiezen en random uit die partij een kandidaat te kiezen.
    private static void randomStemming(ArrayList<Partij> kieslijst) {
        for (int i = 0; i < 50; i++) {
            voegStemmenToe(kieslijst);
        }
        showStemming(kieslijst);
    }

//  voegStemmenToe: in deze methode wordt de stem van de kandidaat in de bewuste partij met één verhoogd.
    private static void voegStemmenToe(ArrayList<Partij> kieslijst) {
        int randomPartij = randomStem.nextInt(kieslijst.size());
        int randomKandidaat = randomStem.nextInt(kieslijst.get(randomPartij).getTotalKandidaten());
        kieslijst.get(randomPartij).getKandidaat(randomKandidaat);
        kieslijst.get(randomPartij).stemOpKandidaat(randomKandidaat);
    }

//  ShowStemming geeft de lijst weer in de output (mag met System.out.println)
    private static void showStemming(ArrayList<Partij> kieslijst) {
        System.out.println(System.lineSeparator() + "Resultaten van de stemming:" + System.lineSeparator());
        for (int i = 0; i < kieslijst.size(); i++) {
            String partijNaam = kieslijst.get(i).getPartijNaam();
            System.out.println(partijNaam);
            for (int j = 0; j < kieslijst.get(i).getTotalKandidaten(); j++) {
                String kandidaatNaam = kieslijst.get(i).getKandidaat(j);
                int kandidaatSttemmen = kieslijst.get(i).getKandidaatStemmen(j);
                System.out.println(kandidaatNaam + ' ' + kandidaatSttemmen);
            }
            int partijStemmen = kieslijst.get(i).getPartijStemmen();
            System.out.println(System.lineSeparator() + "Totaal aantal stemmen = " + partijStemmen + System.lineSeparator());
        }
    }

//  De kieslijst heeft een methode om de lijst van partijen en kandidaten terug te geven.
    private static void showKieslijst(ArrayList<Partij> kieslijst) {
        System.out.println(System.lineSeparator() + "Kieslijst:" + System.lineSeparator());
        for (int i = 0; i < kieslijst.size(); i++) {
            for (int j = 0; j < kieslijst.get(i).getTotalKandidaten(); j++) {
                String partijNaam = kieslijst.get(i).getPartijNaam();
                String kandidaatNaam = kieslijst.get(i).getKandidaat(j);
                System.out.println(partijNaam + " " + kandidaatNaam);
            }
        }
    }

}