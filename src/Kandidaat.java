public class Kandidaat {

    private final String kandidaatNaam;
    private int kandidaatStemmen;

    public Kandidaat(String naam) {
        kandidaatNaam = naam;
        kandidaatStemmen = 0;
    }

    public String getKandidaatNaam() {
        return kandidaatNaam;
    }

    public void voegStemToe() {
        kandidaatStemmen++;
    }

    public int getKandidaatStemmen() {
        return kandidaatStemmen;
    }

}
