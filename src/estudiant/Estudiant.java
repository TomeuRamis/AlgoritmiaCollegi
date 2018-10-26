package estudiant;
import assignatura.Assignatura;

public class Estudiant {
    private String nom;
    private String dni;
    private Estudiant seg;       
    private Llista_estudiant_assignatura list; 
    
    public Estudiant(String nom, String dni) {
        this.nom = nom;
        this.dni = dni;
        this.seg = null;
        this.list = new Llista_estudiant_assignatura();  
    }
    
    public void inserirAssignatura(Assignatura ass) {
        list.inserirRefAssign(ass);
    }
            
//    public void cercarAssignatura(int codi) {
//        ReferenciaAssignatura refassin = list.cercarRefassign(codi);
//    }      
            
    public void eliminarAssignatura(int codi){
        list.eliminarRefassign(codi);
    }
    
    public void Nodeseg(Estudiant estuseg){
        seg = estuseg;
    }

    public String getNom() {
        return nom;
    }
    
    public Estudiant getSeg() {
        return seg;
    }

    public String getDni() {
        return dni;
    }

    public Llista_estudiant_assignatura getList() {
        return list;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setSeg(Estudiant seg) {
        this.seg = seg;
    }
    
    @Override
    public String toString(){
       return "Estudiant = {nom: "+nom+" | DNI: "+dni+"}"; 
    }
}
