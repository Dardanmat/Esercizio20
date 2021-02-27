package esercizi.esercizio20;

//Ciascun Componente è rappresentato da un nome, una quantità e un costoUnitario.
public class Componente {
    
    private String nome;
    private int qta;
    private double costoUnitario;
    
    public Componente(Componente c){
        this.nome = c.nome;
        this.qta = c.qta;
        this.costoUnitario = c.costoUnitario;
    }

    public Componente(String nome, int qta, double costoUnitario) {
        this.nome = nome;
        this.qta = qta;
        this.costoUnitario = costoUnitario;
    }
    
    public Componente(){
        this.nome = "";
        this.qta = 0;
        this.costoUnitario = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQta() {
        return qta;
    }

    public void setQta(int qta) {
        this.qta = qta;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "Nome: "+nome+
             "\nQuantità: " +qta+
             "\nCosto Unitario: "+costoUnitario;
    }

    @Override
    public boolean equals(Object obj) {
        
        if(obj instanceof Componente){
            
            if(((Componente) obj).nome.equals(this.nome)
            && ((Componente) obj).qta == this.qta 
            && ((Componente) obj).costoUnitario == this.costoUnitario){
                return true;
            }      
        }
        return false;
    }
  
}
