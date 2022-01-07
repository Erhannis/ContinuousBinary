/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erhannis.continuousbinary;

/**
 *
 * @author erhannis
 */
public class CBit {
    public double v;
    
    public CBit(double v) {
        this.v = v;
    }
    
    // Convenience for equations etc.
    public static CBit v(double v) {
        return new CBit(v);
    }
        
    public static CBit xor(CBit a, CBit b) {
        double d = a.v - b.v;
        
        //I'm sorta torn between these two.  Multiplication seems cleaner - more pure.  But abs give more "reasonable" values - like, I think addition maybe still works out, with abs.
        //return new CBit(d*d);
        return new CBit(Math.abs(d));
    }
    
    public static CBit or(CBit a, CBit b) {
        return new CBit(a.v + b.v - (a.v*b.v));
    }
    
    public static CBit and(CBit a, CBit b) {
        return new CBit(a.v * b.v);
    }
    
    public static CBit not(CBit a) {
        return new CBit(1 - a.v);
    }

    public CBit xor(CBit b) {
        return CBit.xor(this, b);
    }

    public CBit or(CBit b) {
        return CBit.or(this, b);
    }

    public CBit and(CBit b) {
        return CBit.and(this, b);
    }
    
    public CBit not() {
        return CBit.not(this);
    }
    
    public CBit copy() {
        return new CBit(this.v);
    }
    
    @Override
    public String toString() {
        return ""+v;
    }
}
