package com.infinite.lamejniapp.lame;

import android.util.Log;

/**
 * 循环缓冲区
 * Created by Administrator on 3/23/2018.
 */

public class RingBuffer {
    private static final String TAG = RingBuffer.class.getSimpleName();
    private byte[] buffer;

    private int allSize;

    private int remainPoint;

    private int writePoint;

    /**
     * Initialize a ring buffer given number of bytes
     *
     * @param size
     */
    public RingBuffer(int size) {
        this.allSize = size;
        buffer = new byte[size];
        writePoint = remainPoint = 0;
    }

    /**
     * Check number of bytes left
     *
     * @param writeCheck
     * @return
     */
    private int checkSpace(boolean writeCheck) {
        int s;
        if (writeCheck) {
            if (writePoint > remainPoint) {
                s = remainPoint - writePoint + allSize - 1;
            } else if (writePoint < remainPoint) {
                s = remainPoint - writePoint - 1;
            } else {
                s = allSize - 1;
            }
        } else {
            if (writePoint > remainPoint) {
                s = writePoint - remainPoint;
            } else if (writePoint < remainPoint) {
                s = writePoint - remainPoint + allSize;
            } else {
                s = 0;
            }
        }
        return s;
    }

    /**
     * Read a number of bytes from ring buffer
     *
     * @param buffer
     * @param bytes
     * @return
     */
    public int read(byte[] buffer, final int bytes) {
        int remaining;
        if ((remaining = checkSpace(false)) == 0) {
            Log.e(TAG, "No data");
            return 0;
        }
        final int bytesRead = bytes > remaining ? remaining : bytes;
        // copy from ring buffer to buffer
        for (int i = 0; i < bytesRead; ++i) {
            buffer[i] = this.buffer[remainPoint++];
            if (remainPoint == allSize) {
                remainPoint = 0;
            }
        }
        return bytesRead;
    }

    /**
     * Write a number of bytes to ring buffer;
     *
     * @param buffer
     * @param bytes
     * @return
     */
    public int write(byte[] buffer, final int bytes) {
        int remaining;
        if ((remaining = checkSpace(true)) == 0) {
            Log.e(TAG, "Buffer overrun. Data will not be written");
            return 0;
        }
        final int bytesWrite = bytes > remaining ? remaining : bytes;
        for (int i = 0; i < bytesWrite; ++i) {
            this.buffer[writePoint++] = buffer[i];
            if (writePoint == allSize) {
                writePoint = 0;
            }
        }
        return bytesWrite;
    }
}
