
package Intefaces;

import vo.HotelVO;
import java.util.List;


public interface CRUD {
    public List listar();
    public HotelVO list(int idhotel);
    public boolean add(HotelVO hot);
    public boolean edit(HotelVO hot);
    public boolean eliminar(int idhotel);
}

