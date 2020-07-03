package dto;

import vo.DocumentTypeVO;
import vo.RoleVO;
import vo.UserVO;

public class UserDTO {
    
    private UserVO user;
    private DocumentTypeVO document;
    private RoleVO role;
    public UserDTO(){}
    public UserDTO(UserVO user,DocumentTypeVO document,RoleVO role){
    
        this.user = user;
        this.document = document;
        this.role = role;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public DocumentTypeVO getDocument() {
        return document;
    }

    public void setDocument(DocumentTypeVO document) {
        this.document = document;
    }

    public RoleVO getRole() {
        return role;
    }

    public void setRole(RoleVO role) {
        this.role = role;
    }
    
    
}
