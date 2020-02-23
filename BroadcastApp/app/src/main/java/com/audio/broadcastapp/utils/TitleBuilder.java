package com.audio.broadcastapp.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.audio.broadcastapp.R;

public class TitleBuilder {

    /**
         * 标题
         */
        private View titleView;

        /**
         * 左边相对布局
         */
        private RelativeLayout mRelLeft;

        /**
         * 左边TextView
         */
        private TextView mTvLeft;

        /**
         * 左边ImageView资源
         */
        private ImageView mImgLeft;

        /**
         * 中间TextView标题
         */
        private TextView mTvContent;

        /**
         * 右边相对布局
         */
        private RelativeLayout mRelRight;

        /**
         * 右边TextView
         */
        private TextView mTvRight;

        /**
         * 右边ImageView资源
         */
        private ImageView mImgRight;

        private Context context;


        /**
         * 第一种  初始化方式
         * 这里是直接引用进文件的初始化方式
         *
         * @param context 上下文
         */
        public TitleBuilder(Activity context) {
            this.context = context;
            titleView = context.findViewById(R.id.act_title_bor);

            mTvContent = titleView.findViewById(R.id.act_title_center_tv_title);

            mRelLeft = titleView.findViewById(R.id.act_title_left_rel);
            mImgLeft = titleView.findViewById(R.id.act_title_left_img);
            mTvLeft = titleView.findViewById(R.id.act_title_left_tv);


            mRelRight = titleView.findViewById(R.id.act_title_right_rel);
            mTvRight = titleView.findViewById(R.id.act_title_right_tv);
            mImgRight = titleView.findViewById(R.id.act_title_right_img);

        }

        /**
         * 初始化Fragment标题引用
         * @param activity 上下文
         * @param view     fragment布局引用
         */
        public TitleBuilder(Activity activity, View view) {
            this.context = activity;
            titleView = view.findViewById(R.id.act_title_bor);

            mTvContent = titleView.findViewById(R.id.act_title_center_tv_title);

            mRelLeft = titleView.findViewById(R.id.act_title_left_rel);
            mImgLeft = titleView.findViewById(R.id.act_title_left_img);
            mTvLeft = titleView.findViewById(R.id.act_title_left_tv);


            mRelRight = titleView.findViewById(R.id.act_title_right_rel);
            mTvRight = titleView.findViewById(R.id.act_title_right_tv);
            mImgRight = titleView.findViewById(R.id.act_title_right_img);
        }

        /**
         * title 的设置
         *
         * @param text 设置文本
         */

        public TitleBuilder setMiddleTitleBg(String text) {
            setMiddleTitleBg(text, R.color.white, R.color.title_blue);
            return this;
        }

        /**
         * title
         *
         * @param text       设置文本
         * @param textColor  字体颜色
         * @param titleColor 标题背景颜色
         */
        public TitleBuilder setMiddleTitleBg(String text, int textColor, int titleColor) {
            mTvContent.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE);
            if (!TextUtils.isEmpty(text)) {
                mTvContent.setText(text);
                mTvContent.setTextColor(context.getResources().getColor(textColor));
                titleView.setBackgroundColor(context.getResources().getColor(titleColor));
            }
            return this;
        }

        /**
         * left图片按钮
         *
         * @param resId 资源id
         */
        public TitleBuilder setLeftImageRes(int resId) {
            mImgLeft.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
            mImgLeft.setImageResource(resId);
            return this;
        }

        /**
         * 设置左边TextView
         *
         * @param text 文本
         * @return
         */
        public TitleBuilder setLeftText(String text) {
            setLeftText(text, 18, R.color.white);

            return this;
        }

        /**
         * 设置左边TextView
         *
         * @param text      文本
         * @param textSize  字体大小
         * @param textColor 字体颜色
         */
        public TitleBuilder setLeftText(String text, int textSize, int textColor) {
            mTvLeft.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE);
            if (!TextUtils.isEmpty(text)) {
                mTvLeft.setText(text);
                mTvLeft.setTextSize(textSize);
                mTvLeft.setTextColor(context.getResources().getColor(textColor));
            }
            return this;
        }

        /**
         * 设置左边的事件
         *
         * @param activity activity引用
         */
        public TitleBuilder setLeftRelativeLayoutListener(Activity activity) {
            if (mRelLeft.getVisibility() == View.VISIBLE) {
                mRelLeft.setOnClickListener(v -> {
                    if (!activity.isFinishing()) {
                        activity.finish();
                    }
                });
            }
            return this;
        }

        /**
         * right右边图片按钮
         *
         * @param resId 资源id
         */
        public TitleBuilder setRightImage(int resId) {
            mImgRight.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
            mImgRight.setImageResource(resId);
            return this;
        }

        /**
         * 右边文字按钮
         *
         * @param text 文本
         */
        public TitleBuilder setRightText(String text) {
            setRightText(text, 18, R.color.white);
            return this;
        }

        /**
         * 右边文本
         *
         * @param text      文本
         * @param textSize  字体大小
         * @param textColor 字体颜色
         */
        public TitleBuilder setRightText(String text, int textSize, int textColor) {
            mTvRight.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE);
            if (!TextUtils.isEmpty(text)) {
                mTvRight.setText(text);
                mTvRight.setTextSize(textSize);
                mTvRight.setTextColor(context.getResources().getColor(textColor));
            }
            return this;
        }

        /**
         * 设置右边的事件
         */
        public TitleBuilder setRightRelativeLayoutListener(View.OnClickListener listener) {
            if (mRelRight.getVisibility() == View.VISIBLE) {
                mRelRight.setOnClickListener(listener);
            }
            return this;
        }
    }
