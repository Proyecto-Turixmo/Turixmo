package dao;

import connectiondb.Connect;
import interfaces.IDocumentType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vo.DocumentTypeVO;

public class DocumentTypeDAO extends Connect implements IDocumentType {

    public DocumentTypeDAO() {
    }

    @Override
    public boolean create(DocumentTypeVO documentType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DocumentTypeVO> all() {
     
        ArrayList<DocumentTypeVO> documentsTypesVO = new ArrayList<DocumentTypeVO>();
        try {
            this.createConnection();
            connection = this.getConnection();
            stmt = connection.prepareStatement("SELECT * FROM tipodocumento");
            
            result = stmt.executeQuery();
            while (result.next()) {
                documentsTypesVO.add(new DocumentTypeVO(result.getString(1), result.getString(2)));
            }
        } catch (SQLException e) {
            Logger.getLogger(DocumentTypeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {
                Logger.getLogger(DocumentTypeDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return documentsTypesVO;
    
    }

    @Override
    public DocumentTypeVO get(int id) {
        DocumentTypeVO documentTypeVO = null;

        try {
            this.createConnection();
            connection = this.getConnection();
            stmt = connection.prepareStatement("SELECT * FROM tipodocumento WHERE idtipodocumento = ?");
            stmt.setInt(1, id);
            result = stmt.executeQuery();
            if (result.next()) {
                documentTypeVO = new DocumentTypeVO(result.getString(1), result.getString(2));
            }
        } catch (SQLException e) {
            Logger.getLogger(DocumentTypeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {
                Logger.getLogger(DocumentTypeDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return documentTypeVO;
    }

    @Override
    public boolean update(DocumentTypeVO documentType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
