package com.hdn.zp.utils;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;

/**
 * Created by 多多啦 on 2020/3/12 0012.
 * 时间飞逝
 * time goes by
 * 時間が飛ぶ
 */
@Slf4j
public class Md5Utils {
   // private static final Logger log = LoggerFactory.getLogger(Md5Utils.class);

    private static byte[] md5(String s) {
        MessageDigest algorithm;
        try {
            algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(s.getBytes("UTF-8"));
            byte[] messageDigest = algorithm.digest();
            return messageDigest;
        } catch (Exception e) {
            log.error("MD5 Error...", e);
        }
        return null;
    }

    private static final String toHex(byte hash[]) {
        if (hash == null) {
            return null;
        }
        StringBuffer buf = new StringBuffer(hash.length * 2);
        int i;

        for (i = 0; i < hash.length; i++) {
            if ((hash[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString(hash[i] & 0xff, 16));
        }
        return buf.toString();
    }

    public static String hash(String s) {
        try {
            return new String(toHex(md5(s)).getBytes("UTF-8"), "UTF-8");
        } catch (Exception e) {
            log.error("not supported charset...{}", e);
            return s;
        }
    }

    //	public static void main(String[] args) {
//		String hash = Md5Utils.hash("aa");
//		System.out.println(hash);
//
//		String hash2 = Md5Utils.hash("4124bc0a9335c27f086f24ba207a4912");
//		System.out.println(hash2);
//
//		String s = new String("789ABCabc159");
//		System.out.println("原始：" + s);
////		System.out.println("MD5后：" + string2MD5(s));
//		System.out.println("加密的：" + convertMD5(s));
//		System.out.println("解密的：" + convertMD5(convertMD5(s)));
//
//	}
//
    public static String string2MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
//			md5.reset();
//			md5.update(inStr.getBytes("UTF-8"));
        } catch (Exception e) {
            System.out.println(e.toString());
            log.error("", e);
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = (md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr) {
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

}
