package store.shop.mte.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;


@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User implements Serializable {
    
    @Id
    @NotNull
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id ;
    
    @NaturalId
    @NotEmpty
    private String email ;
    @NotEmpty
    private String password ;
    @NotEmpty
    private String name ;
    @NotEmpty
    private String phone ;
    @NotEmpty
    private String address ;
    @NotEmpty
    private boolean active ;
    @NotEmpty
    private String role = "ROLE_CUSTOMER";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore  // fix bi-direction toString() recursion problem
    private cart cart ;
    
    @Override
    public String toString(){
        return "user { "+
                "email "+email+
                ",password "+password+
                ",name "+name+
                ",phone "+phone+
                ",address "+address+
                ",role "+role+
                ",active "+active+
                " } " ;
    
    }
    
    
    
    
}
