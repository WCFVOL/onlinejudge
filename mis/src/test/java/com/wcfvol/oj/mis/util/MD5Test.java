package com.wcfvol.oj.mis.util;

import org.junit.Test;

public class MD5Test {

    @Test
    public void toMD5() {
        String ans = MD5.toMD5("123ce08e27c-e26f-4752-ba7b-6ac5246e876fce08e27c-e26f-4752-ba7b-6ac5246e876f");
        System.out.println(ans);
    }

    @Test
    public void toHex() {
    }
}