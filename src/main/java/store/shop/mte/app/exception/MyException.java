package store.shop.mte.app.exception;

import store.shop.mte.app.enums.ResultEnum;


public class MyException  extends RuntimeException{

private Integer code ;

public MyException(ResultEnum resultenum){
  super(resultenum.getMessage());
   this.code = resultenum.getCode();
}

public MyException(Integer code,String message){
  super(message);
   this.code = code ;

} 

}
