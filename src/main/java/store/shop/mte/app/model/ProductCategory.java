
package store.shop.mte.app.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "product_category")
@Data
@DynamicUpdate
public class ProductCategory implements Serializable {
    
    
    @Id
    @NotNull
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long categoryid    ;
    @NotNull
    @NotEmpty
    private String categoryname  ; 
    @NaturalId
    private Integer categorytype  ;
    @CreationTimestamp
    private Date createtime    ;
    @UpdateTimestamp
    private Date updatetime  ;  

    public long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(long categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Integer getCategorytype() {
        return categorytype;
    }

    public void setCategorytype(Integer categorytype) {
        this.categorytype = categorytype;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
    
    
    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryname = categoryName;
        this.categorytype = categoryType;
    }
    
    
    
}
