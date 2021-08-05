package com.enerjisa.enframework.data.interactions;

/**
 * Created by Arda Kaplan at 12/13/2018
 * <p>
 * arda.kaplan09@gmail.com
 */
public abstract class ENInteraction<In, Out> {

    private In in;

    public ENInteraction(In in) {
        this.in = in;
    }

    public ENInteraction() {
        this.in = null;
    }

    public In getIn() {
        return in;
    }

    public void setIn(In in) {
        this.in = in;
    }

    public abstract void execute(ENInteractionResultListener<Out> ENInteractionResultListener);
}
