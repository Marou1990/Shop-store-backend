
package store.shop.mte.app.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum  implements CodeEnum{
UP(0,"Avaible"),
DOWN(1,"Unavaible")
;

private Integer code ;
private String message ;

@Override
public Integer getCode() {
    return code;
}

public String getStatus(Integer code) {

    for(ProductStatusEnum statusEnum : ProductStatusEnum.values()) {
        if(statusEnum.getCode() == code) return statusEnum.getMessage();
    }
    return "";
}

private ProductStatusEnum(Integer code, String mesg) {
    this.code = code;
    this.message = mesg;
}



}
