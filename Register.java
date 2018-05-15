
package bokingsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;


public class Register 
{
    
    private ArrayList<Rom> Rommer;
    private ArrayList<Boking>Bokinger;

    public Register() {
        this.Rommer = new ArrayList<>();
        this.Bokinger = new ArrayList<>();
    }
    
    public void regRom(Rom rom)
    {
        if(rom!=null)
        {
            Rommer.add(rom);
        }
    }
    
    public void bookRom(int rom_id, int ant_pers, Date dato)
    {
        //Rom rom = Rommer.get(rom_id); feil her
        Rom rom=null;
        for(int i =0 ; i < Rommer.size(); i++)
        {
            if(Rommer.get(i).getRom_id()==rom_id)
            {
                 rom = Rommer.get(i);
                 i= Rommer.size();
                         
            }
        }
        
        
        if(rom!=null && erLedig())
        {
           
            Boking b = new Boking(rom,ant_pers,dato);
        
            Bokinger.add(b);
        }
    
    }
    
    public Double getTotalInntjenningForRom(int rom_id)
    {
        Double total_pris=0.0;
        for(int i = 0; i < Bokinger.size();i++)
        {
            Boking bk = Bokinger.get(i);
            Rom rom = bk.getRom();
            if(rom.getRom_id()==rom_id)
            {
                total_pris+= rom.getPris();
            }
                  
        }
        
        return total_pris;
    }
    
    public ArrayList<Rom>listAlleRom()
    {
        Collections.sort(Rommer,new Comparator<Rom>()
        {
            @Override
            public int compare(Rom r1, Rom r2) {
             
                return Double.valueOf(getTotalInntjenningForRom(r2.getRom_id()))
                        .compareTo(getTotalInntjenningForRom(r1.getRom_id()));
            }
            
        });
        
        return Rommer;
    }

    //ikke rukket å implemtere 
    private boolean erLedig() {
        return true;
    }

    private Rom hetRoomMedID(int rom_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
    
