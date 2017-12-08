package com.ker;

/**
 * @author peng.guo on 2017/12/7.
 */
public class ReferenceCountingGC {

  public Object instance = null;

  private  static final int _1MB = 1024*1024;

  private byte[] bigSize = new byte[2 * _1MB];

  public static void testGC(){
    ReferenceCountingGC objA = new ReferenceCountingGC();
    ReferenceCountingGC objB = new ReferenceCountingGC();
    objA.instance = objA;
    objB.instance = objB;

    objA = null;
    objB = null;

    System.gc();
  }

  public static void main(String[] args) {
    ReferenceCountingGC.testGC();
  }

}
