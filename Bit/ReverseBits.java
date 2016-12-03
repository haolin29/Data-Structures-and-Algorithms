package Bit;

import java.util.HashMap;

/**
 * Created by Haolin on 2016/10/11.
 */
public class ReverseBits {
    private HashMap<Byte, Integer> cache = new HashMap<>();

    public int reverseBits(int n) {
        Byte[] bytes = new Byte[4];

        for(int i = 0; i < 4; i++) {
            bytes[i] = (byte) ((n >>> 8 * i) & 0xFF); // just keep the lowest 8 bits
        }

        int result = 0;

        for (int i = 0; i < 4; i++) {
            result += reverseByte(bytes[i]);
            if(i < 3) {
                result <<= 8;
            }
        }

        return result;
    }

    public int reverseByte(byte b) {
        if(cache.containsKey(b)) {
            return cache.get(b);
        }

        int result = 0;

        for (int i = 0; i < 8; i++) {
            result += (b >>> i) & 1;
            if(i < 7) {
                result <<= 1;
            }
        }

        return result;

    }
}
