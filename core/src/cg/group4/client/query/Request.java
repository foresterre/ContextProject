package cg.group4.client.query;

import java.io.Serializable;

public class Request implements Serializable {
    Data cData;

    public Request(Data data) {
        cData = data;
    }

    public void setcData(Data data){
        cData = data;
    }

    public Data getcData() {
        return cData;
    }
}