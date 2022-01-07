/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erhannis.continuousbinary;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author erhannis
 */
public class Main {
    public static void main(String[] args) {
        if (1==1) {
            int n = 32;
            for (int i = 0; i <= n; i++) {
                sha256(new CBit[]{CBit.v(i / (1.0*n))});
            }
            if (1==1) return;
        }
        if (1==1) {
            System.out.println(CInt.v(0).roundToHex());
            System.out.println(CInt.v(0x123).roundToHex());
            System.out.println(CInt.v(-1).roundToHex());
            if (1==1) return;
        }
        if (1==1) {
            System.out.println(""+CInt.v(0xFFFFFFFF).add(CInt.v(1000)).roundToInt());
            System.out.println(""+CInt.v(0b11111111000000000000000000000000).and(CInt.v(0b10101010000000000000000000000000)));
            System.out.println(""+CInt.v(0b11111111000000000000000000000000).xor(CInt.v(0b10101010000000000000000000000000)));
            if (1==1) return;
        }
        if (1==1) {
            System.out.println(Integer.toHexString(-1));
            sha256(new CBit[]{}); // Hmm.  Incorrect output.  ... AHA!  Fixed it.
            if (1==1) return;
        }
        if (1==1) {
            System.out.println(""+CInt.v(1).roundToInt());
            System.out.println(""+CInt.v(12345678).roundToInt());
            System.out.println(""+CInt.v(0xFFFFFFFF).roundToInt());
            System.out.println(""+CInt.v(0).set(1,0.9).roundToInt());
            System.out.println(""+CInt.v(0).set(1,0.9).set(0,0.4).roundToInt());
            if (1==1) return;
        }
        if (1==1) {
            System.out.println(""+CInt.v(0).set(0, 0.5).add(CInt.v(3)));
            System.out.println("");
            for (int i = 0; i <= 10; i++) {
                System.out.println(""+CInt.v(0).set(0, i / 10.0).add(CInt.v(3)));
            }
            System.out.println("");
            for (int i = 0; i <= 10; i++) {
                System.out.println(""+CInt.v(2).set(0, i / 10.0).add(CInt.v(3)));
            }
            if (1==1) return;
        }
        if (1==1) {
            System.out.println(""+CInt.v(1).add(CInt.v(0)));
            System.out.println(""+CInt.v(1).add(CInt.v(1)));
            System.out.println(""+CInt.v(1).add(CInt.v(2)).add(CInt.v(4)));
            if (1==1) return;
        }
        if (1==1) {
            int x = 0xFFFFFFFF;
            System.out.println(""+CInt.v(x).rightrotate(0));
            System.out.println(""+CInt.v(x).rightrotate(1));
            System.out.println(""+CInt.v(x).rightrotate(-1));
            System.out.println(""+CInt.v(x).rightshift(0));
            System.out.println(""+CInt.v(x).rightshift(1));
            System.out.println(""+CInt.v(x).rightshift(30));
            System.out.println(""+CInt.v(x).rightshift(40));
            System.out.println(""+CInt.v(x).rightshift(-1));
            System.out.println(""+CInt.v(x).rightshift(-30));
            System.out.println(""+CInt.v(x).rightshift(-40));
            if (1==1) return;
        }
        if (1==1) {
            System.out.println(""+CBit.xor(CBit.v(1), CBit.v(1)));
            System.out.println(""+CBit.xor(CBit.v(0.5), CBit.v(0.5)));
            System.out.println(""+CBit.and(CBit.v(0.5), CBit.v(0.5)));
            if (1==1) return;
        }
        if (1==1) {
            CBit a = new CBit(1);
            CBit b = new CBit(1);
            System.out.println(""+a.xor(b));
            if (1==1) return;
        }
        if (1==1) {
            CInt x = new CInt(-1);
            System.out.println(""+x);
            if (1==1) return;
        }
        if (1==1) {
            CInt x = new CInt(0xFF);
            System.out.println(""+x);
            if (1==1) return;
        }
    }
    
    // https://en.wikipedia.org/wiki/SHA-2#Pseudocode
    public static void sha256(CBit[] msg) {
        CInt h0 = CInt.v(0x6a09e667);
        CInt h1 = CInt.v(0xbb67ae85);
        CInt h2 = CInt.v(0x3c6ef372);
        CInt h3 = CInt.v(0xa54ff53a);
        CInt h4 = CInt.v(0x510e527f);
        CInt h5 = CInt.v(0x9b05688c);
        CInt h6 = CInt.v(0x1f83d9ab);
        CInt h7 = CInt.v(0x5be0cd19);
        
        CInt[] k = new CInt[] {
            CInt.v(0x428a2f98), CInt.v(0x71374491), CInt.v(0xb5c0fbcf), CInt.v(0xe9b5dba5), CInt.v(0x3956c25b), CInt.v(0x59f111f1), CInt.v(0x923f82a4), CInt.v(0xab1c5ed5),
            CInt.v(0xd807aa98), CInt.v(0x12835b01), CInt.v(0x243185be), CInt.v(0x550c7dc3), CInt.v(0x72be5d74), CInt.v(0x80deb1fe), CInt.v(0x9bdc06a7), CInt.v(0xc19bf174),
            CInt.v(0xe49b69c1), CInt.v(0xefbe4786), CInt.v(0x0fc19dc6), CInt.v(0x240ca1cc), CInt.v(0x2de92c6f), CInt.v(0x4a7484aa), CInt.v(0x5cb0a9dc), CInt.v(0x76f988da),
            CInt.v(0x983e5152), CInt.v(0xa831c66d), CInt.v(0xb00327c8), CInt.v(0xbf597fc7), CInt.v(0xc6e00bf3), CInt.v(0xd5a79147), CInt.v(0x06ca6351), CInt.v(0x14292967),
            CInt.v(0x27b70a85), CInt.v(0x2e1b2138), CInt.v(0x4d2c6dfc), CInt.v(0x53380d13), CInt.v(0x650a7354), CInt.v(0x766a0abb), CInt.v(0x81c2c92e), CInt.v(0x92722c85),
            CInt.v(0xa2bfe8a1), CInt.v(0xa81a664b), CInt.v(0xc24b8b70), CInt.v(0xc76c51a3), CInt.v(0xd192e819), CInt.v(0xd6990624), CInt.v(0xf40e3585), CInt.v(0x106aa070),
            CInt.v(0x19a4c116), CInt.v(0x1e376c08), CInt.v(0x2748774c), CInt.v(0x34b0bcb5), CInt.v(0x391c0cb3), CInt.v(0x4ed8aa4a), CInt.v(0x5b9cca4f), CInt.v(0x682e6ff3),
            CInt.v(0x748f82ee), CInt.v(0x78a5636f), CInt.v(0x84c87814), CInt.v(0x8cc70208), CInt.v(0x90befffa), CInt.v(0xa4506ceb), CInt.v(0xbef9a3f7), CInt.v(0xc67178f2)};
        
        ArrayList<CBit> working = new ArrayList<>(Arrays.asList(msg));
        working.add(CBit.v(1));
        while (((working.size()+64) % 512) != 0) {
            working.add(CBit.v(0));
        }
        CLong L = CLong.v(msg.length);
        for (int i = (L.bits.length-1); i >= 0; i--) {
            working.add(L.bits[i].copy());
        }
        
        for (int chunk = 0; chunk < working.size(); chunk += 512) {
            // create a 64-entry message schedule array w[0..63] of 32-bit words
            CInt[] w = new CInt[64];
            
            // copy chunk into first 16 words w[0..15] of the message schedule array
            for (int i = 0; i < 16; i++) {
                CInt sword = new CInt(0);
                w[i] = sword;
                for (int j = 0; j < 32; j++) {
                    sword.bits[31-j] = working.get(chunk+(i*32)+j).copy();
                }
            }
            
            // (alright)
            
            // Extend the first 16 words into the remaining 48 words w[16..63] of the message schedule array:
            for (int i = 16; i < 64; i++) {
                CInt s0 = (w[i-15].rightrotate(7)).xor(w[i-15].rightrotate(18)).xor(w[i-15].rightshift(3));
                CInt s1 = (w[i-2].rightrotate(17)).xor(w[i-2].rightrotate(19)).xor(w[i-2].rightshift(10));
                w[i] = w[i-16].add(s0).add(w[i-7]).add(s1);
            }
            
            // Initialize working variables to current hash value:
            CInt a = h0.copy();
            CInt b = h1.copy();
            CInt c = h2.copy();
            CInt d = h3.copy();
            CInt e = h4.copy();
            CInt f = h5.copy();
            CInt g = h6.copy();
            CInt h = h7.copy();
            
            // Compression function main loop:
            for (int i = 0; i < 64; i++) {
                CInt S1 = (e.rightrotate(6)).xor(e.rightrotate(11)).xor(e.rightrotate(25));
                CInt ch = (e.and(f)).xor((e.not()).and(g));
                CInt temp1 = h.add(S1).add(ch).add(k[i]).add(w[i]);
                CInt S0 = (a.rightrotate(2)).xor(a.rightrotate(13)).xor(a.rightrotate(22));
                CInt maj = (a.and(b)).xor(a.and(c)).xor(b.and(c));
                CInt temp2 = S0.add(maj);

                h = g;
                g = f;
                f = e;
                e = d.add(temp1);
                d = c;
                c = b;
                b = a;
                a = temp1.add(temp2);
            }
            
            // Add the compressed chunk to the current hash value:
            h0 = h0.add(a);
            h1 = h1.add(b);
            h2 = h2.add(c);
            h3 = h3.add(d);
            h4 = h4.add(e);
            h5 = h5.add(f);
            h6 = h6.add(g);
            h7 = h7.add(h);
        }
        
        // Produce the final hash value (big-endian):
        //hash := h0 append h1 append h2 append h3 append h4 append h5 append h6 append h7;
        StringBuilder sb = new StringBuilder();
        sb.append(colorify(h0.roundToHex()));
        sb.append(colorify(h1.roundToHex()));
        sb.append(colorify(h2.roundToHex()));
        sb.append(colorify(h3.roundToHex()));
        sb.append(colorify(h4.roundToHex()));
        sb.append(colorify(h5.roundToHex()));
        sb.append(colorify(h6.roundToHex()));
        sb.append(colorify(h7.roundToHex()));
        System.out.println(sb.toString());
    }
    
    public static String colorify(String s) {
        StringBuilder sb = new StringBuilder();
        for (int c : s.chars().toArray()) {
            String r = ((char)0x1B)+"[0m";
            switch (c) {
                case '0':
                    sb.append(((char)0x1B)+"[30m"+((char)c)+r);
                    break;
                case '1':
                    sb.append(((char)0x1B)+"[31m"+((char)c)+r);
                    break;
                case '2':
                    sb.append(((char)0x1B)+"[32m"+((char)c)+r);
                    break;
                case '3':
                    sb.append(((char)0x1B)+"[33m"+((char)c)+r);
                    break;
                case '4':
                    sb.append(((char)0x1B)+"[34m"+((char)c)+r);
                    break;
                case '5':
                    sb.append(((char)0x1B)+"[35m"+((char)c)+r);
                    break;
                case '6':
                    sb.append(((char)0x1B)+"[36m"+((char)c)+r);
                    break;
                case '7':
                    sb.append(((char)0x1B)+"[37m"+((char)c)+r);
                    break;
                case '8':
                    sb.append(((char)0x1B)+"[30;1m"+((char)c)+r);
                    break;
                case '9':
                    sb.append(((char)0x1B)+"[31;1m"+((char)c)+r);
                    break;
                case 'a':
                    sb.append(((char)0x1B)+"[32;1m"+((char)c)+r);
                    break;
                case 'b':
                    sb.append(((char)0x1B)+"[33;1m"+((char)c)+r);
                    break;
                case 'c':
                    sb.append(((char)0x1B)+"[34;1m"+((char)c)+r);
                    break;
                case 'd':
                    sb.append(((char)0x1B)+"[35;1m"+((char)c)+r);
                    break;
                case 'e':
                    sb.append(((char)0x1B)+"[36;1m"+((char)c)+r);
                    break;
                case 'f':
                    sb.append(((char)0x1B)+"[37;1m"+((char)c)+r);
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }
}
