package com.bawie.todaynews.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawie.todaynews.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class MentLeftFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menuleft_fragment, container, false);
        ImageView img_qq = (ImageView) view.findViewById(R.id.img_qq);
//        ImageView img_tencent = (ImageView) view.findViewById(R.id.img_tencent);
//        ImageView img_weibo = (ImageView) view.findViewById(R.id.img_weibo);

        img_qq.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        UMShareAPI.get(getActivity()).getPlatformInfo(getActivity(), SHARE_MEDIA.QQ, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {
                System.out.println("onStart share_media = " + share_media);
            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                System.out.println("onComplete share_media = " + share_media);

                //获取资料
                String uid = map.get("uid");
                String name = map.get("name");
                String gender = map.get("gender");
                String iconurl = map.get("iconurl");
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                System.out.println("onError SHARE_MEDIA share_media = " + share_media);
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {
                System.out.println("onCancel SHARE_MEDIA share_media = " + share_media);
            }
        });
    }
}