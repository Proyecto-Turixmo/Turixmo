
package interfaces;

import java.util.ArrayList;
import vo.RoleVO;


public interface IRole {
    abstract boolean create(RoleVO role);
    abstract ArrayList<RoleVO> getAll();
    abstract RoleVO getById(int idRole);
    abstract boolean updateById(RoleVO role);
    abstract boolean deleteById(int idRole);
}

