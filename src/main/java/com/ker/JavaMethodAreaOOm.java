package com.ker;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * vm args : -XX:PermSize=10M -XX:MaxPermSize=10M
 * @author peng.guo on 2017/12/7.
 */
public class JavaMethodAreaOOm {

  static class OOMObject{

  }

  public static void main(final String[] args) {
    while (true){
      Enhancer enhancer = new Enhancer();
      enhancer.setSuperclass(OOMObject.class);
      enhancer.setUseCache(false);
      enhancer.setCallback(new MethodInterceptor() {
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
            throws Throwable {
          return methodProxy.invokeSuper(o,objects);
        }
      });
      enhancer.create();
    }
  }
}
