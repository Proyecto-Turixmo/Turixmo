/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import dao.HotelDAO;
import dao.UserDAO;
import interfaces.IHotel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vo.HotelVO;
import vo.UserVO;

/**
 *
 * @author andre
 */
public class HotelModel implements IHotel {
    
    public HotelModel() {
        
    }

    @Override
    public boolean create(HotelVO hotel) {
        
       HotelDAO hotelDAO = new HotelDAO();
        boolean result = false;
        
        try {
            result = hotelDAO.create(hotel);
          } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    @Override
    public ArrayList<HotelVO> getAll(int idUser) {
       HotelDAO hotelDAO = new HotelDAO();
        ArrayList<HotelVO> result = new ArrayList<>();

        try {
            result = hotelDAO.getAll(idUser);
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    
    }

    @Override
    public HotelVO edit(int idHotel,int idUsuario) {
        HotelDAO hotelDAO = new HotelDAO();
        HotelVO result = null;

        try {
            result = hotelDAO.edit(idHotel,idUsuario);
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    
    }

    @Override
    public boolean update(HotelVO hotel) {
       HotelDAO hotelDAO = new HotelDAO();
        boolean result = false;

        try {
            result = hotelDAO.update(hotel);
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    @Override
    public boolean disable(int idHotel,int idUser) {
        
       HotelDAO hotelDAO = new HotelDAO();
        boolean result = false;

        try {
            result = hotelDAO.disable(idHotel,idUser);
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

   
}
