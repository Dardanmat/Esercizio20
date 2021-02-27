package esercizi.esercizio20;
import java.util.ArrayList;

public class CocktailAnalcolico extends Cocktail{
    
    public CocktailAnalcolico(String nome, ArrayList<Componente> listaComponenti) {
        super(nome, listaComponenti);
    }

    public CocktailAnalcolico() {
    }

    public CocktailAnalcolico(CocktailAnalcolico c) {
        super(c);
    }

    @Override
    public String toString() {
        return super.toString() + "\n - Analcolico - ";
    }
    
    
}
