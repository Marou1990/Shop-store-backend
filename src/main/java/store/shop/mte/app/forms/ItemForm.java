package store.shop.mte.app.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


public class ItemForm {
  @Min(value = 1)
    private Integer quantity;
    @NotEmpty
    private String productId;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    
}
