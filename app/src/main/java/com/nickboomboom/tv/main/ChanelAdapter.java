package com.nickboomboom.tv.main;

import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nickboomboom.tv.R;

import java.util.List;

public class ChanelAdapter extends RecyclerView.Adapter<ChanelAdapter.ViewHolder> {
	private static final String TAG = "ChanelAdapter";
	private List<ChannelBean> list;
	private Context context;


	public ChanelAdapter(Context context, List<ChannelBean> list) {
		this.list = list;
		this.context  = context;
	}

	@NonNull
	@Override
	public ChanelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(context).inflate(R.layout.channel_item, parent, false);
		return new ViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(@NonNull ChanelAdapter.ViewHolder holder, int position) {
		final int  _position = position;
		ChannelBean current = this.list.get(_position);
		String title = current.getTitle();
		
		holder.btn_view.setText(title);
		holder.btn_view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {


				Log.d(TAG, "onClick: " +		view.isFocused() );
			}
		});


	}

	@Override
	public int getItemCount() {
		return this.list.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		Button btn_view;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);

			btn_view = itemView.findViewById(R.id.channel_item_button);

		}
	}
}
