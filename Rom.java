
package bokingsystem;

public class Rom 
{
    private int rom_id;
    private int antall_sengeplasser;
    private double pris;
    private String type;
    private static int genererId = 1; // måtte legge til static for å få unik id for alle rom
    
    public Rom(int antall_sengeplasser, double pris , String type )
    {
        this.antall_sengeplasser = antall_sengeplasser;
        this.pris = pris;
        this.type = type;
        this.rom_id = this.genererId++;
        
    }

    public int getRom_id() {
        return rom_id;
    }

    public int getAntall_sengeplasser() {
        return antall_sengeplasser;
    }

    public double getPris() {
        return pris;
    }

    public String getType() {
        return type;
    }
    
    
}
