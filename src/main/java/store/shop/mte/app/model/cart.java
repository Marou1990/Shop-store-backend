
package store.shop.mte.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name = "card")
public class cart implements Serializable {
    
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
     private long cartid  ;
    
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonIgnore
    private User user ;
    
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true,
            mappedBy = "card")
    private Set<ProductInOrder> products = new HashSet<>();

    public long getCartid() {
        return cartid;
    }

    public void setCartid(long cartid) {
        this.cartid = cartid;
    }
    
    @Override
    public String toString(){
        
        return " Cart { " +
                        "cartid   = "+cartid+
                        "products = "+products+
                 "     } ";
    
    }
    
    public  cart(User user){
    this.user = user ;
    }
}
