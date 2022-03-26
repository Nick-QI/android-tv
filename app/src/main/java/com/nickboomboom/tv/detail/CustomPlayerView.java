package com.nickboomboom.tv.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.nickboomboom.tv.R;
import com.nickboomboom.tv.utils.KeyHandler;
import com.shuyu.gsyvideoplayer.cache.CacheFactory;
import com.shuyu.gsyvideoplayer.player.PlayerFactory;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import tv.danmaku.ijk.media.exo2.Exo2PlayerManager;
import tv.danmaku.ijk.media.exo2.ExoPlayerCacheManager;

public class CustomPlayerView extends StandardGSYVideoPlayer {
	private static final String TAG = "CustomPlayerView";
	public CustomPlayerView(Context context, Boolean fullFlag) {
		super(context, fullFlag);
		this.initView(context);
	}

	public CustomPlayerView(Context context) {
		super(context);
		this.initView(context);

	}

	public CustomPlayerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.initView(context);

	}

	@Override
	public int getLayoutId() {
		return R.layout.player_layout;
	}



	public void initView(Context context) {
		PlayerFactory.setPlayManager(Exo2PlayerManager.class);//EXO模式
		CacheFactory.setCacheManager(ExoPlayerCacheManager.class);//exo缓存模式，支持m3u8，只支持exo
		RelativeLayout view = findViewById(R.id.player_layout);
		Log.d(TAG, "initView:" + this);
		Log.d(TAG, "initView:" + view);
//
//		view.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				Log.d(TAG, "onClick: ");
//			}
//		});
//		this.setOnKeyListener(new OnKeyListener() {
//			@Override
//			public boolean onKey(View view, int i, KeyEvent keyEvent) {
//				Log.d(TAG, "onKey: 111111111111111111111111111111");
//				if (KeyHandler.isBottomDown(i, keyEvent)) {
//
//					return true;
//				} else if (KeyHandler.isTopDown(i, keyEvent)) {
//
//					return true;
//				} else if (KeyHandler.isLeftDown(i, keyEvent)) {
//
//
//					return true;
//				} else if (KeyHandler.isRightDown(i, keyEvent)) {
//
//
//					return true;
//				} else if (KeyHandler.isEnterDown(i, keyEvent)) {
//					Log.d(TAG, "onKey: ");
////					changeUiToPlayingShow();
//					return true;
//				}
//
//				return false;
//			}
//		});
	}
}
