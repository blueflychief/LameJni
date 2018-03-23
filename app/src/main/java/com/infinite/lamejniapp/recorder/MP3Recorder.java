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
     * Initialize LAME
     *
     * @param inSampling  input sample rate in Hz.
     * @param outChannel  number of channels in input stream.
     * @param outSampling output sample rate in Hz.
     * @param outBitrate  bitrate compression ratio in KHz.
     * @param quality     bitrate compression ratio in KHz.
     * @param quality     quality=0..9. 0=best (very slow). 9=worst.<br />
     *                    recommended:<br />
     *                    2 near-best quality, not too slow<br />
     *                    5 good quality, fast<br />
     *                    7 ok quality, really fast
     */
    public native static void init(int inSampling, int outChannel,
                                   int outSampling, int outBitrate, int quality);

    /**
     * Encode buffer to mp3
     *
     * @param buffLeft  左声道PCM数据
     * @param buffRight 右声道PCM数据
     * @param samples
     * @param mp3buf    MP3输出
     * @return -1: mp3buf was too small<br />
     * -2: malloc() problem<br />
     * -3: lame_init_params() not called<br />
     * -4: psycho acoustic problems
     */
    public native static int encode(short[] buffLeft, short[] buffRight, int samples, byte[] mp3buf);

    /**
     * Flush LAME buffer
     *
     * @param mp3buf result encoded MP3 stream. You must specified at least 7200 bytes
     * @return number of bytes output to mp3buf. Can be 0
     */
    public native static int flush(byte[] mp3buf);

    /**
     * Close LAME
     */
    public native static void close();
}
