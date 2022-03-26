package com.nickboomboom.tv.utils;

import android.view.KeyEvent;


public class KeyHandler {

    private String TAG = "KeyHandler";


    public static boolean isUp(KeyEvent event) {
        return event.getAction() == KeyEvent.ACTION_UP;
    }

    public static boolean isDown(KeyEvent event) {
        return event.getAction() == KeyEvent.ACTION_DOWN;
    }

    public static boolean isLeftUp(int keyCode, KeyEvent event) {
        return KeyEvent.KEYCODE_DPAD_LEFT == keyCode && isUp(event);
    }

    public static boolean isRightUp(int keyCode, KeyEvent event) {
        return KeyEvent.KEYCODE_DPAD_RIGHT == keyCode && isUp(event);
    }

    public static boolean isLeftDown(int keyCode, KeyEvent event) {
        return KeyEvent.KEYCODE_DPAD_LEFT == keyCode && isDown(event);
    }

    public static boolean isRightDown(int keyCode, KeyEvent event) {
        return KeyEvent.KEYCODE_DPAD_RIGHT == keyCode && isDown(event);
    }

    public static boolean isEnterDown(int keyCode, KeyEvent event) {
        return (KeyEvent.KEYCODE_ENTER == keyCode || KeyEvent.KEYCODE_DPAD_CENTER == keyCode) && isDown(event);
    }

    public static boolean isEnterUp(int keyCode, KeyEvent event) {
        return (KeyEvent.KEYCODE_ENTER == keyCode || KeyEvent.KEYCODE_DPAD_CENTER == keyCode) && isUp(event);
    }


    public static boolean isTopDown(int keyCode, KeyEvent event) {
        return KeyEvent.KEYCODE_DPAD_UP == keyCode && isDown(event);
    }

    public static boolean isTopUp(int keyCode, KeyEvent event) {
        return KeyEvent.KEYCODE_DPAD_UP == keyCode && isUp(event);
    }


    public static boolean isBottomDown(int keyCode, KeyEvent event) {
        return KeyEvent.KEYCODE_DPAD_DOWN == keyCode && isDown(event);
    }

    public static boolean isBottomUp(int keyCode, KeyEvent event) {
        return KeyEvent.KEYCODE_DPAD_DOWN == keyCode && isUp(event);
    }
//    public <T> boolean handle(int keyCode, KeyEvent event, View view, T params) {
//        switch (keyCode) {
//            case KeyEvent.KEYCODE_ENTER:     //确定键enter
//            case KeyEvent.KEYCODE_DPAD_CENTER:
//                Log.d(TAG, "enter--->");
//                this.handlers.enter(view, params);
//                break;
//
//            case KeyEvent.KEYCODE_BACK:    //返回键
//                Log.d(TAG, "back--->");
//                this.handlers.back(view, params);
//                return true;   //这里由于break会退出，所以我们自己要处理掉 不返回上一层
//
//            case KeyEvent.KEYCODE_SETTINGS: //设置键
//                Log.d(TAG, "setting--->");
//                this.handlers.setting(view, params);
//                break;
//
//            case KeyEvent.KEYCODE_DPAD_DOWN:   //向下键
//
//                /*    实际开发中有时候会触发两次，所以要判断一下按下时触发 ，松开按键时不触发
//                 *    exp:KeyEvent.ACTION_UP
//                 */
//                if (event.getAction() == KeyEvent.ACTION_DOWN) {
//
//                    Log.d(TAG, "down--->");
//                    this.handlers.down(view, params);
//                }
//
//                break;
//
//            case KeyEvent.KEYCODE_DPAD_UP:   //向上键
//                Log.d(TAG, "up--->");
//                this.handlers.up(view, params);
//
//                break;
//
//            case KeyEvent.KEYCODE_0:   //数字键0
//                Log.d(TAG, "0--->");
//                this.handlers.zero(view, params);
//                break;
//
//            case KeyEvent.KEYCODE_DPAD_LEFT: //向左键
//
//                Log.d(TAG, "left--->");
//                this.handlers.left(view, params);
//
//                break;
//
//            case KeyEvent.KEYCODE_DPAD_RIGHT:  //向右键
//                Log.d(TAG, "right--->");
//                this.handlers.right(view, params);
//                break;
//
//            case KeyEvent.KEYCODE_INFO:    //info键
//                Log.d(TAG, "info--->");
//                this.handlers.info(view, params);
//
//                break;
//
//            case KeyEvent.KEYCODE_PAGE_DOWN:     //向上翻页键
//            case KeyEvent.KEYCODE_MEDIA_NEXT:
//                Log.d(TAG, "page down--->");
//                this.handlers.pageDown(view, params);
//                break;
//
//
//            case KeyEvent.KEYCODE_PAGE_UP:     //向下翻页键
//            case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
//                Log.d(TAG, "page up--->");
//                this.handlers.pageUp(view, params);
//                break;
//
//            case KeyEvent.KEYCODE_VOLUME_UP:   //调大声音键
//                Log.d(TAG, "voice up--->");
//                this.handlers.voiceUp(view, params);
//                break;
//
//            case KeyEvent.KEYCODE_VOLUME_DOWN: //降低声音键
//                Log.d(TAG, "voice down--->");
//                this.handlers.voiceDown(view, params);
//                break;
//            case KeyEvent.KEYCODE_VOLUME_MUTE: //禁用声音
//                Log.d(TAG, "voice mute--->");
//                this.handlers.voiceMute(view, params);
//                break;
//            default:
//                break;
//        }
//
//
//        return false;
//    }

}
