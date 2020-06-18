
package Intefaces;

import vo.Hotel;
import java.util.List;


public interface CRUD {
    public List listar();
    public Hotel list(int idhotel);
    public boolean add(Hotel hot);
    public boolean edit(Hotel hot);
    public boolean eliminar(int idhotel);
}

