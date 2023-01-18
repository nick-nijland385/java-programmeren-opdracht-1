public class Kandidaat {

    private final String kandidaatNaam;
    private int kandidaatStemmen;

    public Kandidaat(String naam) {
        kandidaatNaam = naam;
        kandidaatStemmen = 0;
    }

    public static String getKandidaatNaam(Kandidaat kandidaat) {
        return kandidaat.kandidaatNaam;
    }

    public static void setKandidaatStemmen(Kandidaat kandidaat) {
        kandidaat.kandidaatStemmen++;
    }

    public static int getKandidaatStemmen(Kandidaat kandidaat) {
        return kandidaat.kandidaatStemmen;
    }

}
