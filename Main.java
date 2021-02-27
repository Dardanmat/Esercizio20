package esercizi.esercizio20;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        Componente pomodoro = new Componente("Pomodoro", 3, 1);
        Componente oliva = new Componente("Oliva", 1, 10);
        Componente zucchero = new Componente("Zucchero", 10, 8);
        Componente cannuccia = new Componente("Cannuccia", 1, 17);
        Componente acqua = new Componente("Acqua", 1, 5);
        Componente gassata = new Componente("Gassata", 1, 19);
        
        //1
        ArrayList<Componente> componentiWiskhey = new ArrayList<>();
        componentiWiskhey.add(gassata);
        componentiWiskhey.add(oliva);
        
        CocktailAlcolico wiskhey = new CocktailAlcolico(89, "Wiskhey", componentiWiskhey);
        
        //2
        ArrayList<Componente> componentiRuhm = new ArrayList<>();
        componentiRuhm.add(gassata);
        componentiRuhm.add(zucchero);
        
        CocktailAlcolico ruhm = new CocktailAlcolico(59, "Ruhm", componentiRuhm);
        
        //3
        ArrayList<Componente> componentiAcqua = new ArrayList<>();
        componentiAcqua.add(gassata);
        componentiAcqua.add(cannuccia);
        
        CocktailAlcolico acquaGassata = new CocktailAlcolico(157, "Acqua Gassata", componentiAcqua);
        
        //4
        ArrayList<Componente> componentiBirretta = new ArrayList<>();
        componentiBirretta.add(acqua);
        componentiBirretta.add(pomodoro);
        
        CocktailAnalcolico birretta = new CocktailAnalcolico("Birra", componentiBirretta);
        
        //5
        ArrayList<Componente> componentiWiskheyAnalcolico = new ArrayList<>();
        componentiWiskheyAnalcolico.add(acqua);
        componentiWiskheyAnalcolico.add(cannuccia);
        
        CocktailAnalcolico wiskheyAnalcolico = new CocktailAnalcolico("Wiskhey Analcolico", componentiWiskheyAnalcolico);
        
        ArrayList<Cocktail> listino = new ArrayList<>();
        
        listino.add(ruhm);
        listino.add(wiskheyAnalcolico);
        listino.add(wiskhey);
        listino.add(birretta);
        listino.add(acquaGassata);
        
        CocktailBar laSpatola = new CocktailBar("La Spatola", listino);
        
        for(Cocktail c: listino){
            System.out.println(c.getClass());
        }
        
        System.out.println(laSpatola.contaTipo(CocktailAlcolico.class));
        
//        System.out.println(laSpatola.toString()+"\n");
//        
//        System.out.println("Lista Cocktail con gassata");
//        for(Cocktail c: laSpatola.listaCocktailConComponente(gassata)){
//            System.out.println(c.getNome());
//        }
//        
//        System.out.println("\n");
//        System.out.println("Lista Cocktail con gradazione al di sotto di 90");
//        for(Cocktail c: laSpatola.listaCocktailSottoGradazioneAlcolica(90)){
//            System.out.println(c.getNome());
//        }
//        
//        System.out.println("\n");
//        System.out.println("Lista Cocktail con prezzo minore di 50");
//        for(Cocktail c: laSpatola.listaCocktailPrezzoMinoreDi(50)){
//            System.out.println(c.getNome());
//        }
    }
}
