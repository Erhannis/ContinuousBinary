/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erhannis.continuousbinary;

/**
 *
 * @author erhannis
 */
public class CInt {
    private static final int N = 32;
    // bits[0] is smallest, bits[N-1] is biggest.
    public CBit[] bits;
    
    public CInt(int v) {
        this.bits = new CBit[N];
        for (int i = 0; i < N; i++) {
            bits[i] = new CBit(v & 0x1);
            v = v >> 1;
        }
    }
    
    /**
     * Set bit in-place, return `this`.
     * @param i
     * @param v
     * @return 
     */
    public CInt set(int i, double v) {
        bits[i].v = v;
        //bits[i] = CBit.v(v); //TODO Safer?
        return this;
    }
    
    // Convenience for equations etc.
    public static CInt v(int v) {
        return new CInt(v);
    }

    public static CInt add(CInt a, CInt b) {
        CBit carry = new CBit(0);
        CInt result = new CInt(0);
        for (int i = 0; i < N; i++) {
            result.bits[i] = a.bits[i].xor(b.bits[i]).xor(carry);
            carry = (a.bits[i].and(b.bits[i])).or(a.bits[i].and(carry)).or(b.bits[i].and(carry));
        }
        return result;
    }

    public static CInt xor(CInt a, CInt b) {
        CInt result = new CInt(0);
        for (int i = 0; i < N; i++) {
            result.bits[i] = a.bits[i].xor(b.bits[i]);
        }
        return result;
    }

    public static CInt and(CInt a, CInt b) {
        CInt result = new CInt(0);
        for (int i = 0; i < N; i++) {
            result.bits[i] = a.bits[i].and(b.bits[i]);
        }
        return result;
    }

    public static CInt not(CInt a) {
        CInt result = new CInt(0);
        for (int i = 0; i < N; i++) {
            result.bits[i] = a.bits[i].not();
        }
        return result;
    }
    
    public static CInt rightrotate(CInt a, int n) {
        n = -n;
        CInt result = new CInt(0);
        for (int i = 0; i < N; i++) {
            result.bits[(((i+n)%N)+N)%N] = a.bits[i];
        }
        return result;
    }

    public static CInt rightshift(CInt a, int n) {
        n = -n;
        CInt result = new CInt(0);
        for (int i = 0; i < N; i++) {
            int j = i+n;
            if (j >= 0 && j < N) {
                result.bits[j] = a.bits[i];
            }
        }
        return result;
    }

    public CInt add(CInt b) {
        return CInt.add(this, b);
    }
    
    public CInt xor(CInt b) {
        return CInt.xor(this, b);
    }

    public CInt and(CInt b) {
        return CInt.and(this, b);
    }

    public CInt not() {
        return CInt.not(this);
    }
    
    public CInt rightrotate(int n) {
        return CInt.rightrotate(this, n);
    }

    public CInt rightshift(int n) {
        return CInt.rightshift(this, n);
    }
    
    public CInt copy() {
        CInt result = new CInt(0);
        for (int i = 0; i < N; i++) {
            result.bits[i] = this.bits[i].copy();
        }
        return result;
    }

    public int roundToInt() {
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            result <<= 1;
            if ((bits[i].v - 0.5) >= 0) {
                result |= 0x1;
            }
        }
        return result;
    }
    
    public String roundToHex() {
        String hex = Integer.toHexString(roundToInt());
        StringBuilder sb = new StringBuilder();
        while ((sb.length() + hex.length()) < (N / 4)) {
            sb.append("0");
        }
        sb.append(hex);
        return sb.toString();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = N-1; i >= 0; i--) {
            sb.append(bits[i] + " ");
        }
        return sb.toString();
    }
}
