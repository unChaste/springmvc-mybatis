package com.ay.apple.proxy;

import java.lang.reflect.Method;

public interface MyLogger {
    void saveIntoMethodTime(Method method);

    void saveOutMethodTime(Method method);
}
