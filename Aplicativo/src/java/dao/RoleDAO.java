package dao;

import connectiondb.Connect;
import interfaces.IRole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vo.RoleVO;

public class RoleDAO extends Connect implements IRole {

    public RoleDAO() {
    }

    @Override
    public boolean create(RoleVO role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<RoleVO> all() {
         ArrayList<RoleVO> rolesVO = new ArrayList<RoleVO>();;
        try {
            this.createConnection();
            connection = this.getConnection();
            stmt = connection.prepareStatement("SELECT * FROM rol");
            result = stmt.executeQuery();

            while(result.next()) {
                rolesVO.add(new RoleVO(result.getString(1), result.getString(2)));
            }
        } catch (SQLException e) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {
                Logger.getLogger(DocumentTypeDAO.class.getName()).log(Level.SEVERE, null,e);
            }
        }
        return rolesVO;
    }
    

    @Override
    public RoleVO get(int id) {
        RoleVO rolVO = null;
        try {
            this.createConnection();
            connection = this.getConnection();
            stmt = connection.prepareStatement("SELECT * FROM rol WHERE idrol = ?");
            stmt.setInt(1, id);
            result = stmt.executeQuery();

            if (this.result.next()) {
                rolVO = new RoleVO(result.getString(1), result.getString(2));
            }
        } catch (SQLException e) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {
                Logger.getLogger(DocumentTypeDAO.class.getName()).log(Level.SEVERE, null,e);
            }
        }
        return rolVO;
    }

    @Override
    public boolean update(RoleVO role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
