/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.util.ArrayList;
import vo.HotelVO;
/**
 *
 * @author andre
 */
public interface IHotel {
    abstract boolean create(HotelVO hotel);
    abstract ArrayList<HotelVO> getAll(int idUser);
    abstract HotelVO edit(int idHotel,int idUser);
    abstract boolean update(HotelVO hotel);
    abstract boolean disable(int idHotel,int idUser);
;
    
}
