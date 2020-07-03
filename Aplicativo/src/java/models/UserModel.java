package models;
//Este modelo representa la logica de negocio

import dao.DocumentTypeDAO;
import dao.RoleDAO;
import dao.UserDAO;
import dto.UserDTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Util;
import vo.DocumentTypeVO;
import vo.RoleVO;
import vo.UserVO;

public class UserModel extends UserDAO {

    public UserModel() {
        
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
    
    public UserDTO get(int id){
        
        UserDTO userDTO = null;
        
        try {
            DocumentTypeDAO documentTypeDAO = new DocumentTypeDAO();
            RoleDAO roleDAO = new RoleDAO();
            
            UserVO userVO = this.getById(id);
            DocumentTypeVO documentTypeVO = documentTypeDAO.get(Util.toNumber(userVO.getIdtipodocumento()));
            RoleVO roleVO = roleDAO.get(Util.toNumber(userVO.getIdrol()));
            
            userDTO = new UserDTO(userVO,documentTypeVO,roleVO);
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return userDTO;
    }
    
      
        public ArrayList<UserDTO> all(){
        
        ArrayList<UserDTO> usersDTO = new ArrayList<UserDTO>();
        
        try {
            DocumentTypeDAO documentTypeDAO = new DocumentTypeDAO();
            RoleDAO roleDAO = new RoleDAO();
            
            ArrayList<UserVO> usersVO = super.getAll();
            for(UserVO userVO:usersVO){
               DocumentTypeVO documentTypeVO = documentTypeDAO.get(Util.toNumber(userVO.getIdtipodocumento()));
               RoleVO roleVO = roleDAO.get(Util.toNumber(userVO.getIdrol()));
            
               usersDTO.add(new UserDTO(userVO,documentTypeVO,roleVO));
            }
            
            
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return usersDTO;
    }
    
     public ArrayList<RoleVO> allRoles(){
        
        ArrayList<RoleVO> rolesVO =  null;
        
        try {
            RoleDAO roleDAO = new RoleDAO();
            rolesVO = roleDAO.all();
            
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return rolesVO;
    }
     
     
     public ArrayList<DocumentTypeVO> allDocumentsTypes(){
        
        ArrayList<DocumentTypeVO> documentsTypesVO =  null;
        
        try {
            DocumentTypeDAO documentTypeDAO = new DocumentTypeDAO();
            documentsTypesVO = documentTypeDAO.all();
            
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return documentsTypesVO;
    }
    
}
