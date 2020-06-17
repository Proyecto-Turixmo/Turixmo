/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.util.ArrayList;
import vo.UserVO;
/**
 *
 * @author andre
 */
public interface IUser {
    abstract boolean create(UserVO user);
    abstract ArrayList<UserVO> getAll();
    abstract UserVO getById(int idUser);
    abstract boolean updateById(UserVO user);
    abstract boolean deleteById(int idUser);
//    abstract UserVO validate(UserVO user);
    
}
