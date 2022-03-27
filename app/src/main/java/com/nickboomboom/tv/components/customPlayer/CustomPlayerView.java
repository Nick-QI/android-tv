package com.nickboomboom.tv.components.customPlayer;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nickboomboom.tv.R;
import com.nickboomboom.tv.main.ChanelAdapter;
import com.nickboomboom.tv.main.ChannelBean;
import com.nickboomboom.tv.main.ChannelList;
import com.nickboomboom.tv.utils.KeyHandler;
import com.shuyu.gsyvideoplayer.cache.CacheFactory;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.player.PlayerFactory;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.GSYVideoType;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView;

import java.util.List;

import moe.codeest.enviews.ENDownloadView;
import tv.danmaku.ijk.media.exo2.Exo2PlayerManager;
import tv.danmaku.ijk.media.exo2.ExoPlayerCacheManager;

public class CustomPlayerView extends StandardGSYVideoPlayer {
	private static final String TAG = "CustomPlayerView";

	private boolean isPlay;

	private LinearLayout slide_view;

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
		this.slide_view = findViewById(R.id.layout_slide);
		RecyclerView list_view = findViewById(R.id.layout_slide_list);


//		TODO: 暂时挂起 等我研究下软硬解码
//		Button decoding_btn = findViewById(R.id.player_layout_btn_decoding);
//
//		decoding_btn.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				GSYVideoType.enableMediaCodec();
//
//				//硬解码：1、打开，0、关闭
////mMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "mediacodec", 1);
////软解码：1、打开，0、关闭
////mMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "videotoolbox", 0);
//
//			}
//		});

		String[] list = {
				"源1",
				"源1",
				"源1",
				"源1",
		};
		LinearLayoutManager manager = new LinearLayoutManager(context);
		ItemAdapter adapter = new ItemAdapter(context, list);
		manager.setOrientation(RecyclerView.VERTICAL);
		list_view.setLayoutManager(manager);
		list_view.setAdapter(adapter);


		this.setVideoAllCallBack(new GSYSampleCallBack() {

		});

		this.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(View view, int i, KeyEvent keyEvent) {
				Log.d(TAG, "onKey: 111111111111111111111111111111");
				if (KeyHandler.isBottomDown(i, keyEvent)) {

					return true;
				} else if (KeyHandler.isTopDown(i, keyEvent)) {

					return true;
				} else if (KeyHandler.isLeftDown(i, keyEvent)) {
					changeUiToPlayingShow();

					return true;
				} else if (KeyHandler.isRightDown(i, keyEvent)) {
					changeUiToPlayingShow();
					return true;
				} else if (KeyHandler.isEnterDown(i, keyEvent)) {
					clickStartIcon();
					Log.d(TAG, "onKey: " + mCurrentState);

					return true;
				}

				return false;
			}
		});
	}
}
