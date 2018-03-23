package com.infinite.lamejniapp.recorder;

/**
 * Created by Administrator on 3/23/2018.
 */

public class MP3Recorder {
    static {
        System.loadLibrary("mp3lame");
    }

    /**
     * 初始化录制参数
     */
    public static void init(int inSampling, int outChannel,
                            int outSampling, int outBitrate) {
        init(inSampling, outChannel, outSampling, outBitrate, 7);
    }

    /**
     * 初始化录制参数 quality:0=很好很慢 9=很差很快
     */
    public native static void init(int inSampling, int outChannel,
                                   int outSampling, int outBitrate, int quality);

    /**
     * 音频数据编码(PCM左进,PCM右进,MP3输出)
     */
    public native static int encode(short[] buffLeft, short[] buffRight, int samples, byte[] mp3buf);

    /**
     * 刷干净缓冲区
     */
    public native static int flush(byte[] mp3buf);

    /**
     * 结束编码
     */
    public native static void close();
}
