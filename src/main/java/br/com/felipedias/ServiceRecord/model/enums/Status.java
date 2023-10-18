package br.com.felipedias.ServiceRecord.model.enums;

public enum Status {

    WAITING(1),
    INPROGRESS(2),
    COMPLETED(3);

    private int code;

    private Status(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }

}
