package com.e_commerceSystem.additional;

import com.e_commerceSystem.additional.ComponentViews;
import com.fasterxml.jackson.annotation.JsonView;

public class JsonResponse {

    @JsonView({ComponentViews.Normal.class, ComponentViews.PriceList.class})
    private String status = null;

    @JsonView({ComponentViews.Normal.class, ComponentViews.PriceList.class})
    private Object result = null;
    private String redirectUrl;
    private boolean redirect = false;

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

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public boolean isRedirect() {
        return redirect;
    }

    public void setRedirect(boolean redirect) {
        this.redirect = redirect;
    }
}
