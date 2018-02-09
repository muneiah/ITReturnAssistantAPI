package ITReturnAssistant.ITReturnAssistantAPI.modal;

import java.util.List;

public class User {
    private String id;
    private String email;
    private String name;
    private String pan;
    private List<UserDeclaration> userDeclaration;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public List<UserDeclaration> getUserDeclaration() {
        return userDeclaration;
    }

    public void setUserDeclaration(List<UserDeclaration> userDeclaration) {
        this.userDeclaration = userDeclaration;
    }
}
