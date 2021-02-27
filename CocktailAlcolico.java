package esercizi.esercizio20;
import java.util.ArrayList;

//CocktailAlcolico con il dato relativo alla gradazione alcolica in esso contenuta
public class CocktailAlcolico extends Cocktail implements Comparable<CocktailAlcolico>{
    
    private static final double AMPLIFICATORE_PREZZO = 0.01;
    
    private float gradazioneAlcolica;

    public CocktailAlcolico(float gradazioneAlcolica, String nome, ArrayList<Componente> listaComponenti) {
        super(nome, listaComponenti);
        this.gradazioneAlcolica = gradazioneAlcolica;
    }

    public CocktailAlcolico() {
        this.gradazioneAlcolica = 0;
    }

    public CocktailAlcolico(CocktailAlcolico c) {
        super(c);
        this.gradazioneAlcolica = c.gradazioneAlcolica;
    }

    @Override
    public double getPrezzo() {
        return super.getPrezzo()*(1+(AMPLIFICATORE_PREZZO*gradazioneAlcolica));
    }

    @Override
    public int compareTo(CocktailAlcolico o) {
        if(o.gradazioneAlcolica<this.gradazioneAlcolica) return -1;
        if(o.gradazioneAlcolica>this.gradazioneAlcolica) return 1;
        return 0;
    }

    public float getGradazioneAlcolica() {
        return gradazioneAlcolica;
    }

    public void setGradazioneAlcolica(float gradazioneAlcolica) {
        this.gradazioneAlcolica = gradazioneAlcolica;
    }

    @Override
    public String toString() {
        return super.toString()+ "\n - Alcolico - \nGradazione: " + gradazioneAlcolica;
    }
}
