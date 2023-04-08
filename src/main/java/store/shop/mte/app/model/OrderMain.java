
package store.shop.mte.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Data
@Table(name = "order_main")
@NoArgsConstructor
@DynamicUpdate
public class OrderMain implements Serializable {
    
    private static final long serialVersionUID = -3819883511505235030L;
    
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderid  ;
    
    @NotEmpty
    private String buyeremail  ;
    @NotEmpty
    private String buyername   ;
    @NotEmpty
    private String buyerphone   ;
    @NotEmpty
    private String buyeraddress  ;
    @NotNull
    @Min(0)
    private BigDecimal orderamount  ;
    @NotNull
    @ColumnDefault("0")    //0 : new order
    private Integer   orderstatus   ;
    @CreationTimestamp
    private LocalDateTime createtime  ;
    @UpdateTimestamp
    private LocalDateTime updatetime  ;
    
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "order_main")
    private Set<ProductInOrder> products = new HashSet<>();

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public String getBuyeremail() {
        return buyeremail;
    }

    public void setBuyeremail(String buyeremail) {
        this.buyeremail = buyeremail;
    }

    public String getBuyername() {
        return buyername;
    }

    public void setBuyername(String buyername) {
        this.buyername = buyername;
    }

    public String getBuyerphone() {
        return buyerphone;
    }

    public void setBuyerphone(String buyerphone) {
        this.buyerphone = buyerphone;
    }

    public String getBuyeraddress() {
        return buyeraddress;
    }

    public void setBuyeraddress(String buyeraddress) {
        this.buyeraddress = buyeraddress;
    }

    public BigDecimal getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(BigDecimal orderamount) {
        this.orderamount = orderamount;
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public LocalDateTime getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(LocalDateTime updatetime) {
        this.updatetime = updatetime;
    }
    
    
    public OrderMain(User buyer) {
        this.buyeremail = buyer.getEmail();
        this.buyername = buyer.getName();
        this.buyerphone = buyer.getPhone();
        this.buyeraddress = buyer.getAddress();
        this.orderamount = buyer.getCart().getProducts().stream().map(item -> item.getProductprice().multiply(new BigDecimal(item.getCount())))
        .reduce(BigDecimal::add)
        .orElse(new BigDecimal(0));
        this.orderstatus = 0;

    }
    
}
