import java.util.ArrayList;

public class Partij {

    String partijNaam;
    ArrayList<Kandidaat> partijKandidaten;

    public Partij(String naam, String[] kandidaten) {
        partijNaam = naam.length() == 0 ? "Geen partijnaam opgegeven" : naam;
        partijKandidaten = createKandidaatLijst(kandidaten);
    }

    private static ArrayList<Kandidaat> createKandidaatLijst(String[] kandidaten) {
        ArrayList<Kandidaat> kandidaatLijst = new ArrayList<Kandidaat>();
        int total = kandidaten.length;
        for (int i = 0; i < total; i++) {
            String kandidaatNaam = kandidaten[i];
            Kandidaat candidate = new Kandidaat(kandidaatNaam);
            kandidaatLijst.add(candidate);
        }
        return kandidaatLijst;
    }
}