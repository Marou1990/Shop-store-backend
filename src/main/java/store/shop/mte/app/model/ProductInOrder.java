
package store.shop.mte.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name ="product_in_order")
@NoArgsConstructor
public class ProductInOrder implements Serializable {
    
    
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id                 ;
    @NotEmpty
    private String productid          ;
    @NotEmpty
    private String productname        ;
    @NotEmpty
    private String productdescription  ;
    @NotEmpty
    private String producticon         ;
    @NotNull
    private Integer categorytype      ;
    
    @NotNull
    private BigDecimal productprice      ;
    @Min(0)
   private Integer  productstock       ;
    @Min (1)
    private Integer count   ;
    
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    // @JoinColumn(name = "cart_id")
    @JsonIgnore
    private cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private OrderMain orderMain;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    public String getProducticon() {
        return producticon;
    }

    public void setProducticon(String producticon) {
        this.producticon = producticon;
    }

    public Integer getCategorytype() {
        return categorytype;
    }

    public void setCategorytype(Integer categorytype) {
        this.categorytype = categorytype;
    }

    public BigDecimal getProductprice() {
        return productprice;
    }

    public void setProductprice(BigDecimal productprice) {
        this.productprice = productprice;
    }

    public Integer getProductstock() {
        return productstock;
    }

    public void setProductstock(Integer productstock) {
        this.productstock = productstock;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    
    
    
    public ProductInOrder(ProductInfo productInfo, Integer quantity) {
        this.productid = productInfo.getProductid();
        this.productname = productInfo.getProductname();
        this.productdescription = productInfo.getProductdescription();
        this.producticon = productInfo.getProducticon();
        this.categorytype = productInfo.getCategorytype();
        this.productprice = productInfo.getProductprice();
        this.productstock = productInfo.getProductstock();
        this.count = quantity;
    }

    @Override
    public String toString() {
        return "ProductInOrder{" +
                "id=" + id +
                ", productId='" + productid + '\'' +
                ", productName='" + productname + '\'' +
                ", productDescription='" + productdescription + '\'' +
                ", productIcon='" + producticon + '\'' +
                ", categoryType=" + categorytype +
                ", productPrice=" + productprice +
                ", productStock=" + productstock +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductInOrder that = (ProductInOrder) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(productid, that.productid) &&
                Objects.equals(productname, that.productname) &&
                Objects.equals(productdescription, that.productdescription) &&
                Objects.equals(producticon, that.producticon) &&
                Objects.equals(categorytype, that.categorytype) &&
                Objects.equals(productprice, that.productprice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), id, productid, productname,
               productdescription, producticon, categorytype, productprice);
    }
    
}
