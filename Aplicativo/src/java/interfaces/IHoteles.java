/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import models.vo.Hoteles;
/**
 *
 * @author Neira Castillo
 */
public interface IHoteles {
     public abstract boolean registerHoteles();
    public abstract ArrayList<Hoteles> getAllHoteles();
    public abstract Hoteles getHotelesById(int idhotel);
    public abstract boolean updateHotelesById(int idhotel);
    public abstract boolean deleteHotelesById(int idhotel);
    
}
