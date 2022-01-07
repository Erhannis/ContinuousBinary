/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erhannis.continuousbinary;

/**
 *
 * @author erhannis
 */
public class CLong {
    private static final int N = 64;
    // bits[0] is smallest, bits[N-1] is biggest.
    public CBit[] bits;
    
    public CLong(int v) {
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
    public CLong set(int i, double v) {
        bits[i].v = v;
        //bits[i] = CBit.v(v); //TODO Safer?
        return this;
    }
    
    // Convenience for equations etc.
    public static CLong v(int v) {
        return new CLong(v);
    }

    public static CLong add(CLong a, CLong b) {
        CBit carry = new CBit(0);
        CLong result = new CLong(0);
        for (int i = 0; i < N; i++) {
            result.bits[i] = a.bits[i].xor(b.bits[i]).xor(carry);
            carry = (a.bits[i].and(b.bits[i])).or(a.bits[i].and(carry)).or(b.bits[i].and(carry));
        }
        return result;
    }
    
    public static CLong xor(CLong a, CLong b) {
        CLong result = new CLong(0);
        for (int i = 0; i < N; i++) {
            result.bits[i] = a.bits[i].xor(b.bits[i]);
        }
        return result;
    }
    
    public static CLong and(CLong a, CLong b) {
        CLong result = new CLong(0);
        for (int i = 0; i < N; i++) {
            result.bits[i] = a.bits[i].and(b.bits[i]);
        }
        return result;
    }

    public static CLong not(CLong a) {
        CLong result = new CLong(0);
        for (int i = 0; i < N; i++) {
            result.bits[i] = a.bits[i].not();
        }
        return result;
    }
    
    public static CLong rightrotate(CLong a, int n) {
        n = -n;
        CLong result = new CLong(0);
        for (int i = 0; i < N; i++) {
            result.bits[(((i+n)%N)+N)%N] = a.bits[i];
        }
        return result;
    }

    public static CLong rightshift(CLong a, int n) {
        n = -n;
        CLong result = new CLong(0);
        for (int i = 0; i < N; i++) {
            int j = i+n;
            if (j >= 0 && j < N) {
                result.bits[j] = a.bits[i];
            }
        }
        return result;
    }

    public CLong add(CLong b) {
        return CLong.add(this, b);
    }

    public CLong xor(CLong b) {
        return CLong.xor(this, b);
    }

    public CLong and(CLong b) {
        return CLong.and(this, b);
    }
    
    public CLong not() {
        return CLong.not(this);
    }
    
    public CLong rightrotate(int n) {
        return CLong.rightrotate(this, n);
    }

    public CLong rightshift(int n) {
        return CLong.rightshift(this, n);
    }

    public CLong copy() {
        CLong result = new CLong(0);
        for (int i = 0; i < N; i++) {
            result.bits[i] = this.bits[i].copy();
        }
        return result;
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
