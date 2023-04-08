
package store.shop.mte.app.enums;


public enum OrderStatusEnum implements CodeEnum {
  NEW(0,"New Order Main"),
  FINISHED(1,"Finished"),
  CANCELED(2,"Canceled")
    ;
       private Integer code ;
       private String  msg ;

    private OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code ;
    }

}
