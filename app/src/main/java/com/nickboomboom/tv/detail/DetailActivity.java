package com.nickboomboom.tv.detail;

import androidx.annotation.NonNull;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

import android.widget.LinearLayout;

import com.nickboomboom.tv.R;
import com.nickboomboom.tv.components.customPlayer.CustomPlayerView;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;


import butterknife.BindView;
import butterknife.ButterKnife;


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
	}


	/**
	 * orientationUtils 和  detailPlayer.onConfigurationChanged 方法是用于触发屏幕旋转的
	 */
	@Override
	public void onConfigurationChanged(@NonNull Configuration newConfig) {
		super.onConfigurationChanged(newConfig);

	}
}