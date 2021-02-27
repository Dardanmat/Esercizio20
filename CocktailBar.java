package esercizi.esercizio20;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
La classe contenitore CocktailBar contiene il nome del locale e l’elenco dei cocktail disponibili con i prezzi
calcolati sommando il costo unitario di ciascun componente per la quantità; ai cocktail alcolici viene
applicato un ulteriore costo in base al grado alcolico (si aggiunge cioè una quantità ottenuta moltiplicando il
grado alcolico per un “fattore costante” definito staticamente in CocktailAncolico).
*/

//per l’aggiunta/rimozione di cocktail al listino del bar

/*per la creazione della lista dei cocktail alcolici al di sotto di una certa gradazione,
   in ordine decrescente del grado alcolico*/

/*per la creazione della lista dei cocktail che contengono un certo componente, in ordine alfabetico
(inserimento ordinato)*/

/*per la creazione della lista dei cocktail con prezzo maggiore di una certa cifra, in ordine di prezzo
(inserimento ordinato)*/

public class CocktailBar {
    
    private String nome;
    private ArrayList<Cocktail> listino;

    public CocktailBar(String nome, ArrayList<Cocktail> listino) {
        this.nome = nome;
        this.listino = listino;
    }
    
    public CocktailBar() {
        this.nome = "";
        this.listino = new ArrayList<>();
    }
    
    public CocktailBar(CocktailBar cb) {
        this.nome = cb.nome;
        try {
            this.listino = (ArrayList<Cocktail>) cb.clone();
        } catch (CloneNotSupportedException ex) {}
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Cocktail> getListino() {
        return listino;
    }

    public void setListino(ArrayList<Cocktail> listino) {
        this.listino = listino;
    }
    
    //per l’aggiunta/rimozione di cocktail al listino del bar
    public boolean addCocktail(Cocktail c){
        return listino.add(c);
    }
    
    public boolean removeCocktail(Cocktail c){
        int i = trovaCocktailListino(c);
        if(i!=-1){
            listino.remove(i);
            return true;
        }
        return false;
    }
    
    public boolean removeCocktail(String nome){
        int i = trovaCocktailListino(nome);
        if(i!=-1){
            listino.remove(i);
            return true;
        }
        return false;
    }
    
    private int trovaCocktailListino(Cocktail c){
        for(int i = 0; i < listino.size(); i++){
            if(listino.get(i).equals(c)) return i;
        }
        return -1;
    }
    
    private int trovaCocktailListino(String nome){
        for(int i = 0; i < listino.size(); i++){
            if(listino.get(i).getNome().equals(nome)) return i;
        }
        return -1;
    }
    
    /*per la creazione della lista dei cocktail alcolici al di sotto di una certa gradazione,
   in ordine decrescente del grado alcolico*/
    public ArrayList<CocktailAlcolico> listaCocktailSottoGradazioneAlcolica(float gradazione){
        ArrayList<CocktailAlcolico> lista = new ArrayList<>();
        
        for(Cocktail c: listino){
            if(c instanceof CocktailAlcolico){
                if(((CocktailAlcolico)c).getGradazioneAlcolica() < gradazione) lista.add((CocktailAlcolico) c);
            }
        }
        
        Collections.sort(lista);
        return lista;
    }
    
    /*per la creazione della lista dei cocktail che contengono un certo componente, in ordine alfabetico
    (inserimento ordinato)*/
    public ArrayList<Cocktail> listaCocktailConComponente(Componente c){
        ArrayList<Cocktail> lista = new ArrayList<>();
        
        for(Cocktail coc: listino){
            for(Componente com: coc.getListaComponenti()){
                if(com.equals(c)) {
                    lista.add(coc);
                    break;
                }
            }
        }
        
        Collections.sort(lista, Comparator.comparing(Cocktail::getNome));
        return lista;
    }
    
    /*per la creazione della lista dei cocktail con prezzo maggiore di una certa cifra, in ordine di prezzo
    (inserimento ordinato)*/
    public ArrayList<Cocktail> listaCocktailPrezzoMinoreDi(double prezzo){
        ArrayList<Cocktail> lista = new ArrayList<>();
        
        for(Cocktail c: listino){
            if(c.getPrezzo()<prezzo){
                lista.add(c);
            }
        }
        
        Collections.sort(lista, Comparator.comparing(Cocktail::getPrezzo));
        return lista;
    }

    @Override
    public String toString() {
        String s = "";
        
        s += "Listino Cocktail del Bar "+this.nome+":\n\n";
        
        for(Cocktail c: listino){
            s += c.toString() + "\nPrezzo: " + c.getPrezzo()+"€\n\n";
        }
        
        return s;
    }
    
    public String toStringSimple(){
        String s = "";
        
        s += "Listino Cocktail del Bar "+this.nome+":\n\n";
        
        for(Cocktail c: listino){
            s += c.getNome()+"\n";
        }
        
        return s;
    }
    
    public int contaTipo(Class<?> c){
        int j = 0;
        for(Cocktail co: listino){
            if(c == co.getClass()) j++;
        }
        return j;
    }
    
    
}
