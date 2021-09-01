package com.e_commerceSystem.additional;

import com.fasterxml.jackson.annotation.JsonView;

public class JsonResponse {

    @JsonView({ComponentViews.Normal.class, ComponentViews.PriceList.class})
    private String status = null;

    @JsonView({ComponentViews.Normal.class, ComponentViews.PriceList.class})
    private Object result = null;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Object getResult() {
        return result;
    }
    public void setResult(Object result) {
        this.result = result;
    }
}
