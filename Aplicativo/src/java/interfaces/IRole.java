
package interfaces;

import java.util.ArrayList;
import vo.RoleVO;


public interface IRole {
    abstract boolean create(RoleVO role);
    abstract ArrayList<RoleVO> all();
    abstract RoleVO get(int id);
    abstract boolean update(RoleVO role);
}

