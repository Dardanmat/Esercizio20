package esercizi.esercizio20;
import java.util.ArrayList;
//La classe base Cocktail definisce il nome del cocktail e la collezione dei suoi Componenti. 

//fare dei metodi:
// - per l’aggiunta/rimozione di componenti ai cocktail
// - per il calcolo del prezzo di un cocktail
public class Cocktail {
    
    private String nome;
    private ArrayList<Componente> listaComponenti;

    public Cocktail(String nome, ArrayList<Componente> listaComponenti) {
        this.nome = nome;
        this.listaComponenti = listaComponenti;
    }
    
    public Cocktail() {
        this.nome = "";
        this.listaComponenti = new ArrayList<>();
    }
    
    public Cocktail(Cocktail c) {
        this.nome = c.nome;
        try {
            this.listaComponenti = (ArrayList)c.clone();
        } catch (CloneNotSupportedException ex) {}
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Componente> getListaComponenti() {
        return listaComponenti;
    }

    public void setListaComponenti(ArrayList<Componente> listaComponenti) {
        this.listaComponenti = listaComponenti;
    }
    
    // metodo per l’aggiunta di componenti ai cocktail
    public boolean addComponente(Componente c){
        return listaComponenti.add(c);
    }
    
    // metodo per la rimozione di componenti ai cocktail
    public boolean removeComponente(String nome){
        for(int i = 0; i<listaComponenti.size(); i++){
            if(listaComponenti.get(i).getNome().equals(nome)){
                listaComponenti.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean removeComponente(Cocktail c){
        for(int i = 0; i<listaComponenti.size(); i++){
            if(listaComponenti.get(i).equals(c)){
                listaComponenti.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public double getPrezzo(){
        double sum = 0;
        for(Componente c: listaComponenti){
            sum += c.getQta()*c.getCostoUnitario();
        }
        return sum;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cocktail){
            if(this.nome.equals(((Cocktail) obj).nome)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        
        s += "Nome Cocktail: " + this.nome + "\nComponenti:";
        for(Componente c: listaComponenti){
            s += "\n"+c.getNome();
        }
        
        return s;
    }
    
    
    
}
