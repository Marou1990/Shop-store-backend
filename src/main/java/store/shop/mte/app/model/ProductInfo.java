
package store.shop.mte.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name ="product_info")
@Data
@DynamicUpdate
public class ProductInfo implements Serializable {
    
    @Id
    private String productid ;
    @NotNull
    private String productname;
    @NotNull
    private String productdescription;
    @NotNull
    private String producticon ;
    @ColumnDefault("0")
    private Integer productstatus ;
    @NotNull
    @Min(0)
    private Integer productstock ;
    @NotNull
    private BigDecimal  productprice ;
    @ColumnDefault("0")
    private Integer categorytype ;
    
    @CreationTimestamp
    private Date createdate;
    @UpdateTimestamp
    private Date updatetime ;

    public ProductInfo() {
    }
    
   
    
    
    
}
