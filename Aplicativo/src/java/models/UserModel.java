package models;
//Este modelo representa la logica de negocio

import dao.UserDAO;
import interfaces.IUser;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vo.UserVO;

public class UserModel implements IUser {

    public UserModel() {
        
    }

    
    @Override
    public boolean create(UserVO user) {

        UserDAO userDAO = new UserDAO();
        boolean result = false;
        
        try {
            result = userDAO.create( user);
          } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    @Override
    public ArrayList<UserVO> getAll() {

        UserDAO userDAO = new UserDAO();
        ArrayList<UserVO> result = new ArrayList<>();

        try {
            result = userDAO.getAll();
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    @Override
    public UserVO getById(int idUser) {

        UserDAO userDAO = new UserDAO();
        UserVO result = null;

        try {
            result = userDAO.getById(idUser);
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    @Override
    public boolean updateById(UserVO user) {
        
        UserDAO userDAO = new UserDAO();
        boolean result = false;

        try {
            result = userDAO.updateById(user);
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    @Override
    public boolean deleteById(int idUser) {
        
        UserDAO userDAO = new UserDAO();
        boolean result = false;

        try {
            result = userDAO.deleteById(idUser);
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }
    

    public UserVO validate(String email, String password) {
        
        UserVO userVO = null;
        UserDAO userDAO = new UserDAO();
      
        try {
            UserVO userValidate = userDAO.validate(email);
            if(userValidate != null){
                if(password.equals(userValidate.getContrasena())){
                    userVO = userValidate;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return userVO;
    }

}
