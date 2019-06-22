package com.jvm.learn.classLoad;

/**
 * @Author dabing
 * @Date 2019-06-22 23:15
 **/
public class Learn14DemoObj {

    private Learn14DemoObj learn14DemoObj;

    public Learn14DemoObj init() {
        return new Learn14DemoObj();
    }

    public void setLearn14DemoObj(Object obj) {
        this.learn14DemoObj = (Learn14DemoObj) obj;
    }
}
