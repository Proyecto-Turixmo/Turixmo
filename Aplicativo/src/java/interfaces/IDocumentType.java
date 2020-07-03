
package interfaces;

import java.util.ArrayList;
import vo.DocumentTypeVO;

public interface IDocumentType {
   
    abstract boolean create(DocumentTypeVO documentType);
    abstract ArrayList<DocumentTypeVO> all();
    abstract DocumentTypeVO get(int id);
    abstract boolean update(DocumentTypeVO documentType);
}
