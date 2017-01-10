package priv.lyh.arena.exception;

public class ActionException extends SysException {

    public ActionException(){
        super("Arena:The service layer an exception occurs");
    }

    public ActionException(String msg){
        super(msg);
    }
}
