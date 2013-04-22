package com.makemyandroidapp.example.stacksites;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;

public class SitesAdapter extends ArrayAdapter<StackSite> {

	ImageLoader imageLoader;
	DisplayImageOptions options;
	public SitesAdapter(Context ctx, int textViewResourceId, List<StackSite> sites) {
		super(ctx, textViewResourceId, sites);
		
		Log.i("StackSites", "getting image loader");
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(ctx).build();
        
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(config);
        
        options = new DisplayImageOptions.Builder()
		.cacheInMemory()
		.cacheOnDisc()
		.build();
        Log.i("StackSites", "got image loader");

	}
	
	
	@Override
	public View getView(int pos, View convertView, ViewGroup parent){
		RelativeLayout row = (RelativeLayout)convertView;
		Log.i("StackSites", "getView pos = " + pos);
		if(null == row){
			//No recycled View, we have to inflate one.
			LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = (RelativeLayout)inflater.inflate(R.layout.row_site, null);
		}
		final ImageView iconImg = (ImageView)row.findViewById(R.id.iconImg);
		TextView nameTxt = (TextView)row.findViewById(R.id.nameTxt);
		TextView aboutTxt = (TextView)row.findViewById(R.id.aboutTxt);
		final ProgressBar indicator = (ProgressBar)row.findViewById(R.id.progress);
		indicator.setVisibility(View.VISIBLE);
		iconImg.setVisibility(View.INVISIBLE);
		//imageLoader.displayImage(getItem(pos).getImgUrl(), iconImg);
		ImageLoadingListener listener = new ImageLoadingListener(){



			@Override
			public void onLoadingStarted(String arg0, View arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onLoadingCancelled(String arg0, View arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onLoadingComplete(String arg0, View arg1, Bitmap arg2) {
				indicator.setVisibility(View.INVISIBLE);
				iconImg.setVisibility(View.VISIBLE);
			}

			@Override
			public void onLoadingFailed(String arg0, View arg1, FailReason arg2) {
				// TODO Auto-generated method stub
				
			}
			
		};
		imageLoader.displayImage(getItem(pos).getImgUrl(), iconImg,options, listener);
		nameTxt.setText(getItem(pos).getName());
		aboutTxt.setText(getItem(pos).getAbout());
		
		
		
		return row;
				
				
	}

}
