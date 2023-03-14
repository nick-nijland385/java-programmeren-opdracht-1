import java.util.ArrayList;

public class Partij {

    private final String partijNaam;
    private final ArrayList<Kandidaat> partijKandidaten;

    private int partijStemmen;

    public Partij(String[][] partijGegevens) {
        partijNaam = partijGegevens[0][0];
        partijKandidaten = createKandidaatLijst(partijGegevens[1]);
        partijStemmen = 0;
    }

    public String getPartijNaam() {
        return partijNaam;
    }

    public int getTotalKandidaten() {
        return partijKandidaten.size();
    }

    public String getKandidaat(int index) {
        return partijKandidaten.get(index).getKandidaatNaam();
    }

    public void stemOpKandidaat(int index) {
        partijKandidaten.get(index).voegStemToe();
    }

    public int getKandidaatStemmen(int index) {
        return partijKandidaten.get(index).getKandidaatStemmen();
    }

    public int getPartijStemmen() {
        for (int i = 0; i < partijKandidaten.size(); i++) {
            partijStemmen = partijStemmen + partijKandidaten.get(i).getKandidaatStemmen();
        }
        return partijStemmen;
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