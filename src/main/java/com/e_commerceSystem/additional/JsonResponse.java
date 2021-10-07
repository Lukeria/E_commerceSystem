package com.e_commerceSystem.additional;

import com.e_commerceSystem.additional.ComponentViews;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;

public class JsonResponse {

    @JsonView({ComponentViews.Normal.class, ComponentViews.PriceList.class})
    private HttpStatus status = null;

    @JsonView({ComponentViews.Normal.class, ComponentViews.PriceList.class})
    private Object result = null;
    private String redirectUrl;
    private boolean redirect = false;

    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
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
