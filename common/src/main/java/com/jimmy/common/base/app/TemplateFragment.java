package com.jimmy.common.base.app;

import android.view.View;
import android.widget.TextView;

import com.jimmy.common.R;


/**
 * Created by Jimmy on 2016/10/19 0019.
 */
public abstract class TemplateFragment extends BaseFragment {

    public void onLeftButtonClick(View v) {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    public void onRightButtonClick(View v) {

    }

    public void editTemplateTitle(String title) {
        if (getActivity() != null && getActivity() instanceof TemplateActivity) {
            TextView tvTemplateTitle = getActivity().findViewById(R.id.tvTemplateTitle);
            tvTemplateTitle.setText(title);
        }
    }

    public void hideLeftButton() {
        if (getActivity() != null && getActivity() instanceof TemplateActivity) {
            getActivity().findViewById(R.id.ibTemplateLeft).setVisibility(View.GONE);
        }
    }

}
