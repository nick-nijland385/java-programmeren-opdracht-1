import java.util.ArrayList;

public class Partij {

    private final String partijNaam;
    private final ArrayList<Kandidaat> partijKandidaten;

    public Partij(String naam, String[] kandidaten) {
        partijNaam = naam.length() == 0 ? "Geen partijnaam opgegeven" : naam;
        partijKandidaten = createKandidaatLijst(kandidaten);
    }

    public static String getPartijNaam(Partij partij) {
        return partij.partijNaam;
    }

    public static int getTotalKandidaten(Partij partij) {
        return partij.partijKandidaten.size();
    }

    public static String getKandidaat(Partij partij, int index) {
        Kandidaat kandidaat = partij.partijKandidaten.get(index);
        return Kandidaat.getKandidaatNaam(kandidaat);
    }

    public static void setAantalStemmen(Partij partij, int kandidaatIndex) {
        Kandidaat kandidaat = partij.partijKandidaten.get(kandidaatIndex);
        Kandidaat.setKandidaatStemmen(kandidaat);
    }

    public static int getAantalStemmen(Partij partij, int index) {
        Kandidaat kandidaat = partij.partijKandidaten.get(index);
        return Kandidaat.getKandidaatStemmen(kandidaat);
    }

    private static ArrayList<Kandidaat> createKandidaatLijst(String[] kandidaten) {
        ArrayList<Kandidaat> kandidaatLijst = new ArrayList<>();
        for (String kandidaatNaam : kandidaten) {
            Kandidaat candidate = new Kandidaat(kandidaatNaam);
            kandidaatLijst.add(candidate);
        }
        return kandidaatLijst;
    }
}