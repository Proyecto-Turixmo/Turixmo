
package interfaces;

import java.util.ArrayList;
import vo.DocumentTypeVO;

public interface IDocumentType {
   
    abstract boolean create(DocumentTypeVO documentType);
    abstract ArrayList<DocumentTypeVO> getAll();
    abstract DocumentTypeVO getById(int idDocumentType);
    abstract boolean update(DocumentTypeVO documentType);
    abstract boolean deleteById(int idDocumentType);
}
