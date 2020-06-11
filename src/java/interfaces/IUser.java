/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.util.ArrayList;
import models.vo.User;
/**
 *
 * @author andre
 */
public interface IUser {
    public abstract boolean insertUser();
    public abstract ArrayList<User> getAllUsers();
    public abstract boolean getUserById(int iduser);
    public abstract boolean deleteUserById(int iduser);
}
