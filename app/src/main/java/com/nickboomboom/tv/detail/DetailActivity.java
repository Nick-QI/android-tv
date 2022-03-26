package com.nickboomboom.tv.detail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nickboomboom.tv.R;
import com.nickboomboom.tv.utils.KeyHandler;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.cache.CacheFactory;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.player.PlayerFactory;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import butterknife.BindView;
import butterknife.ButterKnife;
import tv.danmaku.ijk.media.exo2.Exo2PlayerManager;
import tv.danmaku.ijk.media.exo2.ExoPlayerCacheManager;

public class DetailActivity extends Activity {
	@BindView(R.id.activity_detail)
	LinearLayout root;

	@BindView(R.id.activity_detail_player)
	CustomPlayerView detailPlayer;
	String url = "http://39.134.115.163:8080/PLTV/88888910/224/3221225618/index.m3u8";
	String title = "测试用";
	boolean isPlay = false;
	boolean isPause = false;

	private static final String TAG = "DetailActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		ButterKnife.bind(this);
		this.init();
	}


	public void init() {
//		detailPlayer = findViewById(R.id.activity_detail_player);

		GSYVideoOptionBuilder gsyVideoOption = new GSYVideoOptionBuilder();
		gsyVideoOption
				.setIsTouchWiget(true)
				.setRotateViewAuto(false)
				.setLockLand(true)
				.setUrl(this.url)
				.setCacheWithPlay(false)
				.setVideoTitle(this.title)
				.setStartAfterPrepared(true)
				.setShowFullAnimation(false)
				///不需要旋转
				.setNeedOrientationUtils(false)
				.setVideoAllCallBack(new GSYSampleCallBack() {
					@Override
					public void onPrepared(String url, Object... objects) {
						super.onPrepared(url, objects);
						//开始播放了才能旋转和全屏
						isPlay = true;
					}
				}).build(this.detailPlayer);

		this.detailPlayer.startPlayLogic();
		Log.d(TAG, "init: "+ this.root);
		this.detailPlayer.setOnKeyListener(new View.OnKeyListener() {
			@Override
			public boolean onKey(View view, int i, KeyEvent keyEvent) {
				Log.d(TAG, "onKey: 111111111111111111111111111111");
				if (KeyHandler.isBottomDown(i, keyEvent)) {

					return true;
				} else if (KeyHandler.isTopDown(i, keyEvent)) {

					return true;
				} else if (KeyHandler.isLeftDown(i, keyEvent)) {


					return true;
				} else if (KeyHandler.isRightDown(i, keyEvent)) {


					return true;
				} else if (KeyHandler.isEnterDown(i, keyEvent)) {
					Log.d(TAG, "onKey: ");
					return true;
				}

				return false;
			}
		});

	}


	@Override
	public void onBackPressed() {

		if (GSYVideoManager.backFromWindowFull(this)) {
			return;
		}
		super.onBackPressed();
	}


	@Override
	protected void onPause() {
		detailPlayer.getCurrentPlayer().onVideoPause();
		super.onPause();
		isPause = true;
	}

	@Override
	protected void onResume() {
		detailPlayer.getCurrentPlayer().onVideoResume(false);
		super.onResume();
		isPause = false;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (isPlay) {
			detailPlayer.getCurrentPlayer().release();
		}
//        if (orientationUtils != null)
//            orientationUtils.releaseListener();
	}


	/**
	 * orientationUtils 和  detailPlayer.onConfigurationChanged 方法是用于触发屏幕旋转的
	 */
	@Override
	public void onConfigurationChanged(@NonNull Configuration newConfig) {
		super.onConfigurationChanged(newConfig);

	}
}